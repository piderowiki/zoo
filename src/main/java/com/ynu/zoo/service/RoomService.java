package com.ynu.zoo.service;

import com.ynu.zoo.DelayedQueueConfig;
import com.ynu.zoo.PO.Room;
import com.ynu.zoo.PO.RoomExample;
import com.ynu.zoo.PO.RoomListPeople;
import com.ynu.zoo.PO.RoomListPeopleExample;
import com.ynu.zoo.VO.RoomVO;
import com.ynu.zoo.mapper.RoomListPeopleMapper;
import com.ynu.zoo.mapper.RoomMapper;
import com.ynu.zoo.utils.ConstUtil;
import com.ynu.zoo.utils.ZooMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoomService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    RoomMapper roomMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    RoomListPeopleMapper roomListPeopleMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    public final static int roomTtlTime = 7200 * 1000;

    public List<Room> selectAllRoom(int gameType){
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andTypeEqualTo(gameType);
       return roomMapper.selectByExample(new RoomExample());
    }

    public Room selectRoomByID(int id){
        return roomMapper.selectByPrimaryKey(id);
    }

    public List<Room> selectRoomByName(String roomName,int gameType){
        return roomMapper.selectByNameAndType(roomName,gameType);
    }

    public List<RoomListPeople> selectPeopleInRoom(int roomID){
        RoomListPeopleExample roomListPeopleExample = new RoomListPeopleExample();
        roomListPeopleExample.createCriteria().andRoomIdEqualTo(roomID);
        return roomListPeopleMapper.selectByExample(roomListPeopleExample);
    }

    @Transactional
    public ZooMessage createRoom(RoomVO roomVO){
        // 还需要保证你本人不在其它房间
        if(!sureYouAreNotInRoom(roomVO.getMasterName())){
            ZooMessage zooMessage = new ZooMessage();
            zooMessage.setSuccessFlag(ConstUtil.MESSAGE_FAILED);
            return zooMessage;
        }
        // 创造房间步骤
        // Step1.创建房间
        Room room = new Room();
        // 好像开发出观战功能也不需要满足已满功能,算是把大人员席作为观战席
        room.setName(roomVO.getRoomName());
        room.setFirst(roomVO.getFirst());
        room.setTime(roomVO.getTime());
        room.setType(roomVO.getType());
        room.setOnlinePeople("0");
        room.setIsBegin("false");
        room.setReadyPeople("0");
        roomMapper.insert(room);
        int roomID = room.getId();
        // Step2.给房间创建一个列表
        /*进房间这步给进入房间代理
        RoomListPeople roomListPeople = new RoomListPeople();
        roomListPeople.setPeopleMax(ConstUtil.GAME_ZOO_PEOPLE_MAX);
        roomListPeople.setPlayer1(roomVO.getMasterName());
        roomListPeople.setRoomId(roomID);
        roomListPeopleMapper.insert(roomListPeople);
         */

        // Step3.给MQ发准备删除的任务
        // 用_作为分隔符,前者代表操作,后者是数据
        String delteTaskMsg = ConstUtil.MQ_DELETE_ROOM + "_" + roomID;
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_EXCHANGE_NAME,
                DelayedQueueConfig.DELAYED_ROUTING_NAME,delteTaskMsg,(message -> {
                    message.getMessageProperties().setDelay(roomTtlTime);
                    return message;
                }));
        // Step5.Redis这部分也要改,Redis数据是干啥的?答曰:在连接中途断开的时候用来查询用户属于哪个房间用的
        // 暂时不进房间,这部分就不用进
        //redisTemplate.opsForValue().set(roomVO.getMasterName(),roomID);

        // 返回roomID,作为成功的消息,并准备连上
        return new ZooMessage(ConstUtil.MESSAGE_SUCCESS,"" + roomID);
    }

    @Transactional
    public void deleteRoom(int roomID){
        // 删除房间步骤
        // Step1.把房间内的所有人t出.并删除
        // t出这步具体交给NioChannel做,这边只负责Redis的移回
        RoomListPeopleExample roomListPeopleExample = new RoomListPeopleExample();
        roomListPeopleExample.createCriteria().andRoomIdEqualTo(roomID);
        List<RoomListPeople> roomListPeopleList = roomListPeopleMapper.selectByExample(roomListPeopleExample);
        // 如果是空值,让程序正常跑就可以了
        if(roomListPeopleList == null){
            roomListPeopleList = new ArrayList<>();
        }
        for (RoomListPeople people :
                roomListPeopleList) {
            String playerName = people.getPlayer1();
            redisTemplate.opsForValue().set(playerName,ConstUtil.USER_IN_HALL);
        }
        // t完就可以了
        roomListPeopleMapper.deleteByExample(roomListPeopleExample);

        // Step2.把房间删除
        roomMapper.deleteByPrimaryKey(roomID);
    }

    @Transactional
    public void outTheRoom(int roomID,String userName){
        Room room = selectRoomByID(roomID);
        String onlinePeopleStr = room.getOnlinePeople();
        Integer onlinePeople = Integer.parseInt(onlinePeopleStr);
        room.setOnlinePeople("" + (onlinePeople - 1));
        roomMapper.updateByPrimaryKey(room);

        RoomListPeopleExample roomListPeopleExample = new RoomListPeopleExample();
        roomListPeopleExample.createCriteria().andRoomIdEqualTo(roomID).andPlayer1EqualTo(userName);
        roomListPeopleMapper.deleteByExample(roomListPeopleExample);

        redisTemplate.opsForValue().set(userName,ConstUtil.USER_IN_HALL);

        // 只有一个人的时候
        if(onlinePeople == 1){
            // 退出的同时也把房间删了
            roomMapper.deleteByPrimaryKey(roomID);
        }
    }

    @Transactional
    public ZooMessage InTheRoom(int roomID,String userName){
        // 想进入房间,那就是Redis要进入,数据库要有记录
        // 先确认房间是否存在
        Room room = roomMapper.selectByPrimaryKey(roomID);
        if(room == null){
            ZooMessage zooMessage = new ZooMessage();
            zooMessage.setSuccessFlag(ConstUtil.MESSAGE_FAILED);
            zooMessage.setMessageBody("房间不存在");
            return zooMessage;
        }
        // 再确认房间游戏还未开始
        if(room.getIsBegin() == "true"){
            ZooMessage zooMessage = new ZooMessage();
            zooMessage.setSuccessFlag(ConstUtil.MESSAGE_FAILED);
            zooMessage.setMessageBody("房间游戏已开始!");
            return zooMessage;
        }

        Integer onlinePeople = Integer.parseInt(room.getOnlinePeople());
        room.setOnlinePeople("" + (onlinePeople + 1));
        if(onlinePeople == 2){
            room.setIsBegin("true");
        }
        roomMapper.updateByPrimaryKey(room);

        // 还需要保证你本人不在其它房间
        if(!sureYouAreNotInRoom(userName)){
            ZooMessage zooMessage = new ZooMessage();
            zooMessage.setSuccessFlag(ConstUtil.MESSAGE_FAILED);
            zooMessage.setMessageBody("涉嫌重复登录");
            return zooMessage;
        }


        // 先加数据库,再改Redis
        RoomListPeople roomListPeople = new RoomListPeople();
        roomListPeople.setPeopleMax(ConstUtil.GAME_ZOO_PEOPLE_MAX);
        roomListPeople.setPlayer1(userName);
        roomListPeople.setRoomId(roomID);
        roomListPeopleMapper.insert(roomListPeople);
        // 改Redis
        redisTemplate.opsForValue().set(userName,roomID);

        ZooMessage zooMessage = new ZooMessage();
        zooMessage.setSuccessFlag(ConstUtil.MESSAGE_SUCCESS);

        return zooMessage;
    }

    public boolean sureYouAreNotInRoom(String userName){
        Integer whereIsUser = (Integer) redisTemplate.opsForValue().get(userName);
        return (whereIsUser == ConstUtil.USER_IN_HALL)||(whereIsUser == ConstUtil.USER_IS_OFFLINE);
    }
}
