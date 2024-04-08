package com.ynu.zoo.controller;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;
import com.ynu.zoo.PO.Room;
import com.ynu.zoo.VO.RoomVO;
import com.ynu.zoo.service.RoomService;
import com.ynu.zoo.utils.ConstUtil;
import com.ynu.zoo.utils.ZooMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

@Controller
@ResponseBody
@Slf4j
// 全权代理Room相关
public class HallController {
    @Autowired
    RoomService roomService;

    @RequestMapping("/zoo/get/all/room/{gameType}")
    public List<Room> getAllRoom(@PathVariable("gameType")int gameType){
        log.info("外部访问");
        return roomService.selectAllRoom(gameType);
    }

    @RequestMapping("/zoo/get/room/name/{roomName}/{gameType}")
    public List<Room> getRoomByName(@PathVariable("roomName")String roomName,@PathVariable("gameType")int gameType){
        // 很好奇查出空List会怎样
        List<Room> rooms = roomService.selectRoomByName(roomName, gameType);
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i));
        }
        return rooms;
    }

    @RequestMapping("/zoo/get/room/id/{roomID}")
    public Room getRoomByID(@PathVariable("roomID")int roomID){
        // 很好奇查到null是怎样的
        return roomService.selectRoomByID(roomID);
    }

    // 创建房间后，就可以连上Netty服务器了
    @RequestMapping("/zoo/create/room")
    public ZooMessage createRoom(@RequestBody RoomVO room){
        int first = room.getFirst();
        if( first == ConstUtil.ROOM_NEED_RANDOM_FIRST){
            int randomFirst = new Random().nextInt(2);
            room.setFirst(randomFirst);
        }
        log.info("接收到创建房间请求,room是:"+room);

        ZooMessage result = roomService.createRoom(room);
        return result;
    }

    // 加入房间后，就可以连上Netty服务器了
    @RequestMapping("/zoo/in/room/{roomID}/{userName}")
    public ZooMessage inRoom(@PathVariable("roomID")int roomID,@PathVariable("userName")String userName){
        log.info(userName + "请求加入房间"+roomID);
        ZooMessage zooMessage = roomService.InTheRoom(roomID, userName);
        if(zooMessage.getSuccessFlag() == ConstUtil.MESSAGE_FAILED){
            log.info("拒绝请求,理由是" + zooMessage.getMessageBody());
        }
        return zooMessage;
    }

    // 真的需要吗
    @RequestMapping("/zoo/exit/room/{roomID}/{userName}")
    public String exitRoom(@PathVariable("roomID")String roomID,@PathVariable("userName")String roomName){
        return "";
    }
}