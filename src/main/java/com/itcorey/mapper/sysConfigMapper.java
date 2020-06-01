package com.itcorey.mapper;

import com.itcorey.pojo.sysConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface sysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysConfig record);

    int insertSelective(sysConfig record);

    List selectByPrimaryKey();

    int updateByPrimaryKeySelective(sysConfig record);

    int updateByPrimaryKey(sysConfig record);

    List<sysConfig> findAll();

}