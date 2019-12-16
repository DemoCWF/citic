package com.citic.demo.mapper;

import com.citic.demo.entity.SaleWay;

public interface SaleWayMapper {
    int deleteByPrimaryKey(Integer salewayId);

    int insert(SaleWay record);

    int insertSelective(SaleWay record);

    SaleWay selectByPrimaryKey(Integer salewayId);

    int updateByPrimaryKeySelective(SaleWay record);

    int updateByPrimaryKey(SaleWay record);
}