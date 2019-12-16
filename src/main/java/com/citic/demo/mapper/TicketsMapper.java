package com.citic.demo.mapper;

import com.citic.demo.entity.Tickets;

public interface TicketsMapper {
    int deleteByPrimaryKey(Integer ticketsId);

    int insert(Tickets record);

    int insertSelective(Tickets record);

    Tickets selectByPrimaryKey(Integer ticketsId);

    int updateByPrimaryKeySelective(Tickets record);

    int updateByPrimaryKey(Tickets record);
}