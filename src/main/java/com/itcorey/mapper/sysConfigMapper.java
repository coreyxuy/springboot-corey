package com.itcorey.mapper;

import com.itcorey.pojo.sysConfig;

import java.util.List;


public interface sysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysConfig record);

    int insertSelective(sysConfig record);

    List selectByPrimaryKey();

    int updateByPrimaryKeySelective(sysConfig record);

    int updateByPrimaryKey(sysConfig record);

    List<sysConfig> findAll();

}