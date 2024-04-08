package com.ynu.zoo.utils;

public class ConstUtil {
    public static final int USER_IN_HALL  = 0;
    public static final int ROOM_NEED_RANDOM_FIRST = 9;
    public static final int USER_IS_OFFLINE = -999;

    // 这里是Error消息
    public static final int MESSAGE_SUCCESS  = 1;
    public static final int MESSAGE_FAILED  = 0;
    // 这里是游戏人数对应
    public static final int GAME_ZOO_PEOPLE_MAX = 2;
    // 这里是MQ处理消息
    public static final String MQ_DELETE_ROOM = "deleteRoom";
    // 这是Netty部分的消息
    public static final int NETTY_REGISTER_READY = -1;
    public static final int NETTY_SEND_MESSAGE  = 0;
    public static final int NETTY_FRESH_USER = 1;
    public static final int NETTY_DIALOG_SHOW = 2;
    public static final int NETTY_MOVE_ORDER = 3;
}
