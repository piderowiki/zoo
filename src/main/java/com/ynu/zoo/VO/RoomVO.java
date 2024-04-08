package com.ynu.zoo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomVO {
    String roomName;
    int first;
    int time;
    int type;
    String masterName;
}
