package com.ynu.zoo.PO;

// 设计出错了!应该是有一堆作为List，而不是一个记录一堆
public class RoomListPeople {
    private Integer id;

    private Integer roomId;

    private Integer peopleMax;

    private String spare;

    private String player1;
    // 好,我宣布剩下仨全都给废了
    private String player2;

    private String player3;

    private String player4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(Integer peopleMax) {
        this.peopleMax = peopleMax;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }
}