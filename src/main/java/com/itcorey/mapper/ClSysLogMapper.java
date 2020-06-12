package com.itcorey.mapper;

import com.itcorey.pojo.ClSysLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClSysLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClSysLog record);

    int insertSelective(ClSysLog record);

    ClSysLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClSysLog record);

    int updateByPrimaryKey(ClSysLog record);
}