package com.itcorey.mapper;

import com.itcorey.pojo.UplocalFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UplocalFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UplocalFile record);

    int insertSelective(UplocalFile record);

    UplocalFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UplocalFile record);

    int updateByPrimaryKey(UplocalFile record);
}