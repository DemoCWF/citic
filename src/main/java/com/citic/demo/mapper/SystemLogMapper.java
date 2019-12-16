package com.citic.demo.mapper;

import com.citic.demo.entity.SystemLog;

public interface SystemLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    SystemLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}