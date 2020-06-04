package com.itcorey.mapper;

import com.itcorey.pojo.QuartzInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuartzInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuartzInfo record);

    int insertSelective(QuartzInfo record);

    QuartzInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuartzInfo record);

    int updateByPrimaryKey(QuartzInfo record);
}