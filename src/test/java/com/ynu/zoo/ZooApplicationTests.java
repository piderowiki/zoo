package com.ynu.zoo;

import com.ynu.zoo.PO.Room;
import com.ynu.zoo.mapper.RoomMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ZooApplicationTests {
    @Autowired
    RoomMapper roomMapper;

    @Test
    public void contextLoads() {
        Room room = new Room();
        int insert = roomMapper.insert(room);
        System.out.println(insert);
        System.out.println(room.getId());
    }

}
