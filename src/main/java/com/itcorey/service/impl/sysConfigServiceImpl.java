package com.itcorey.service.impl;

import com.itcorey.mapper.sysConfigMapper;
import com.itcorey.pojo.sysConfig;
import com.itcorey.service.sysConfigService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname sysConfigServiceImpl
 * @Description TODO
 * @Date 2020/5/28 17:16
 * @Created by corey
 */
public class sysConfigServiceImpl implements sysConfigService {

    @Resource
    private sysConfigMapper sysConfigMapper;

    @Override
    public List<sysConfig> findAll() {
        return sysConfigMapper.findAll();
    }
}
