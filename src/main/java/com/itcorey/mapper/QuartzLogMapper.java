package com.itcorey.mapper;

import com.itcorey.pojo.QuartzLog;

public interface QuartzLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuartzLog record);

    int insertSelective(QuartzLog record);

    QuartzLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuartzLog record);

    int updateByPrimaryKey(QuartzLog record);
}