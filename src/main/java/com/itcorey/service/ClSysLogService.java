package com.itcorey.service;

import com.itcorey.pojo.ClSysLog;

/**
 * @Classname ClSysLogServer
 * @Description 接触服务
 * @Date 2020/6/12 14:46
 * @Created by corey
 */
public interface ClSysLogService {

    /**
     * 保存日志操作
     * @param clSysLog
     */
    void saveLog(ClSysLog clSysLog);
}
