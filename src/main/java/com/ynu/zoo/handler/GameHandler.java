package com.ynu.zoo.handler;

import com.ynu.zoo.PO.Room;
import com.ynu.zoo.PO.RoomListPeople;
import com.ynu.zoo.VO.NettyMessagePOJO;
import com.ynu.zoo.mapper.RoomListPeopleMapper;
import com.ynu.zoo.service.RoomService;
import com.ynu.zoo.utils.ConstUtil;
import com.ynu.zoo.utils.DoubleMap;
import com.ynu.zoo.utils.ZooMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ynu.zoo.utils.ConstUtil.NETTY_FRESH_USER;

// 几乎只负责指令传达,因此不需要针对每个游戏开发一个Handler
@Slf4j
@Component
@ChannelHandler.Sharable
public class GameHandler extends SimpleChannelInboundHandler<NettyMessagePOJO.NettyMessage> {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RoomService roomService;
    @Autowired
    private DoubleMap doubleMap;

    /* 如果要new 一个对象的话,应该是要这么做
    public GameHandler() {
        ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfig.class);
        RedisTemplate redis = context.getBean("redisTemplate",RedisTemplate.class);
        ...
    }
    */

    // 功能如下:
    // 1.可以根据用户名和房间名把消息转发给正确的用户
    // 2.有人忽然断开连接时,可以断线重连

    // 表示连接建立,一旦连接,第一个被执行
    // 将当前的channel加入到channelGroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("用户连入"+ctx.channel().remoteAddress());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, NettyMessagePOJO.NettyMessage nettyMessage) throws Exception {
        log.info("netty收到消息");
        Channel channel = ctx.channel();
        log.info(nettyMessage.toString());
        String sender = nettyMessage.getSender();
        int roomID = nettyMessage.getRoomID();
        Room room = roomService.selectRoomByID(roomID);
        if(room == null){
            log.error("有人向不存在的房间发消息,发信人用户名:"+sender +",连接名:"+channel.remoteAddress());
            return;
        }
        List<RoomListPeople> roomListPeopleList = roomService.selectPeopleInRoom(roomID);
        if(roomListPeopleList.size() == 0){
            log.error("房间存在,但人员列表为空,需要排查问题");
            return;
        }

        NettyMessagePOJO.NettyMessage serverNettyMessage;
        NettyMessagePOJO.NettyMessage serverNettyMessage1 = null;
        NettyMessagePOJO.NettyMessage promptMessage = null;
        List<RoomListPeople> peopleInRoom;
        switch (nettyMessage.getMessageType()){
            // 本部分是玩家点准备
            case ConstUtil.NETTY_REGISTER_READY:
                log.info("有玩家注册,注册人为"+sender);
                doubleMap.put(sender,channel);
                // 玩家加入并注册后,会为该房间其它玩家发送玩家已经到来的信息,并准备
                peopleInRoom = roomService.selectPeopleInRoom(roomID);
                // 测，忘了给nettyMessage设置集合类型的
                // 那没办法了
                if(peopleInRoom.size() == 1){
                    // 此时,sender作为user1
                    serverNettyMessage = NettyMessagePOJO.NettyMessage.newBuilder()
                            .setSender(peopleInRoom.get(0).getPlayer1())
                            .setParameter1(room.getTime())
                            .setParameter2(room.getFirst())
                            .setMessageType(NETTY_FRESH_USER).build();

                }else if(peopleInRoom.size() == 2){
                    serverNettyMessage = NettyMessagePOJO.NettyMessage.newBuilder()
                            .setSender(peopleInRoom.get(0).getPlayer1())
                            .setParameter3(peopleInRoom.get(1).getPlayer1())
                            .setParameter1(room.getTime())
                            .setMessageType(NETTY_FRESH_USER)
                            .setParameter2(room.getFirst()).build();
                    serverNettyMessage1 = NettyMessagePOJO.NettyMessage.newBuilder()
                            .setSender(peopleInRoom.get(0).getPlayer1())
                            .setParameter3(peopleInRoom.get(1).getPlayer1())
                            .setParameter1(room.getTime())
                            .setMessageType(NETTY_FRESH_USER)
                            .setParameter2(1 - room.getFirst()).build();
                    // 这里要塞提示信息
                    String firstPlayer;
                    if(room.getFirst() == 0){
                        firstPlayer = peopleInRoom.get(0).getPlayer1();
                    }else {
                        firstPlayer = peopleInRoom.get(1).getPlayer1();
                    }
                    promptMessage = NettyMessagePOJO.NettyMessage.newBuilder()
                            .setSender("系统").setMessageType(ConstUtil.NETTY_SEND_MESSAGE)
                            .setMessageBody("游戏开始,请"+firstPlayer+"先开始移动!").build();

                    // 这里把roomService
                }else {
                    log.info("房间人数出错,请检查");
                    return;
                }
                // 发出消息
                log.info(serverNettyMessage.toString());

                peopleInRoom = roomService.selectPeopleInRoom(roomID);
                for (int i = 0; i < peopleInRoom.size(); i++) {
                    RoomListPeople people = peopleInRoom.get(i);
                    Channel peopleChannel = doubleMap.get(people.getPlayer1());
                    if(peopleChannel == null)continue;

                    if(i == 0){
                        log.info("向"+people.getPlayer1()+"发送消息,内容是"+serverNettyMessage);
                        peopleChannel.writeAndFlush(serverNettyMessage);
                    }else {
                        log.info("向"+people.getPlayer1()+"发送消息,内容是"+serverNettyMessage1);
                        peopleChannel.writeAndFlush(serverNettyMessage1);
                    }
                    // 发送提示消息
                    if(peopleInRoom.size() >= 2){
                        //peopleChannel.writeAndFlush(promptMessage);
                    }
                }
                
                break;

            case ConstUtil.NETTY_SEND_MESSAGE:
                log.info("接收到"+sender +"发来的消息:"+nettyMessage.getMessageBody());
                serverNettyMessage = NettyMessagePOJO.NettyMessage.newBuilder().setMessageType(ConstUtil.NETTY_SEND_MESSAGE)
                        .setMessageBody(nettyMessage.getMessageBody()).setSender(sender).build();
                // 给房间内的每一个人都发送
                peopleInRoom = roomService.selectPeopleInRoom(roomID);
                for (RoomListPeople people : peopleInRoom) {
                    Channel peopleChannel = doubleMap.get(people.getPlayer1());
                    if(peopleChannel == null)continue;
                    peopleChannel.writeAndFlush(serverNettyMessage);
                }

                break;
            case ConstUtil.NETTY_MOVE_ORDER:
                int x = nettyMessage.getParameter1();
                int y = nettyMessage.getParameter2();
                String newXY = nettyMessage.getParameter3();
                log.info("接收到房间"+roomID+"内由"+sender+"发来的移动请求,请求在"+x+","+y+
                        "的棋子移动至"+newXY);

                peopleInRoom = roomService.selectPeopleInRoom(roomID);
                // 直接转发即可
                for (RoomListPeople people : peopleInRoom) {
                    if(people.getPlayer1().equals(sender)){
                        continue;
                    }
                    Channel peopleChannel = doubleMap.get(people.getPlayer1());
                    if(peopleChannel == null)continue;
                    peopleChannel.writeAndFlush(nettyMessage);
                }
                break;
            default:
                log.error("netty接收消息出错");
                break;
        }
    }

    // 断开连接会触发
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel socketAddress = ctx.channel();
        String userName = doubleMap.get(socketAddress);
        Integer roomID =(Integer)redisTemplate.opsForValue().get(userName);
        // 上半部分是断线重连
        // 后半部分是退出房间
        // 不对,好像不需要,到时间了自动认输
        doubleMap.remove(socketAddress);
        roomService.outTheRoom(roomID,userName);
    }
}
