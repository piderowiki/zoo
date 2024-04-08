package com.ynu.zoo.PO;

public class Room {
    private Integer id;

    private String name;

    private Integer type;

    // 你好,你被废弃了
    private String onlinePeople;
    // 你也被废了
    private String isBegin;

    // 你好,你也被废弃了,因为我弄错了类型
    // 你俩就准备给personnelList取代吧
    // ready人数准备给HashMap取代
    private String readyPeople;
    // 真没想到,连你也有被废弃的一天
    private Integer personnelId;

    private Integer first;

    private Integer time;

    private String spare;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOnlinePeople() {
        return onlinePeople;
    }

    public void setOnlinePeople(String onlinePeople) {
        this.onlinePeople = onlinePeople;
    }

    public String getIsBegin() {
        return isBegin;
    }

    public void setIsBegin(String isBegin) {
        this.isBegin = isBegin;
    }

    public String getReadyPeople() {
        return readyPeople;
    }

    public void setReadyPeople(String readyPeople) {
        this.readyPeople = readyPeople;
    }

    public Integer getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Integer personnelId) {
        this.personnelId = personnelId;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", onlinePeople='" + onlinePeople + '\'' +
                ", isBegin='" + isBegin + '\'' +
                ", readyPeople='" + readyPeople + '\'' +
                ", personnelId=" + personnelId +
                ", first=" + first +
                ", time=" + time +
                ", spare='" + spare + '\'' +
                '}';
    }
}