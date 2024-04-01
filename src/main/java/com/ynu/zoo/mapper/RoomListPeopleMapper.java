package com.ynu.zoo.mapper;

import com.ynu.zoo.PO.RoomListPeople;
import com.ynu.zoo.PO.RoomListPeopleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomListPeopleMapper {
    long countByExample(RoomListPeopleExample example);

    int deleteByExample(RoomListPeopleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomListPeople record);

    int insertSelective(RoomListPeople record);

    List<RoomListPeople> selectByExample(RoomListPeopleExample example);

    RoomListPeople selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomListPeople record, @Param("example") RoomListPeopleExample example);

    int updateByExample(@Param("record") RoomListPeople record, @Param("example") RoomListPeopleExample example);

    int updateByPrimaryKeySelective(RoomListPeople record);

    int updateByPrimaryKey(RoomListPeople record);
}