package com.itcorey.service;

import com.itcorey.pojo.sysConfig;

import java.util.List;

/**
 * @Classname sysConfigService
 * @Description TODO
 * @Date 2020/5/28 17:14
 * @Created by corey
 */
public interface sysConfigService {

    /**
     * 查询所有配置
     *
     * @return
     */
    List<sysConfig> findAll();
}
