package com.itcorey.service.impl;

import com.itcorey.mapper.ClSysLogMapper;
import com.itcorey.pojo.ClSysLog;
import com.itcorey.service.ClSysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname ClSysLogServerImpl
 * @Description TODO
 * @Date 2020/6/12 14:58
 * @Created by corey
 */
@Service
public class ClSysLogServiceImpl implements ClSysLogService {

    @Resource
    private ClSysLogMapper clSysLogMapper;

    @Override
    public void saveLog(ClSysLog clSysLog) {
        clSysLogMapper.insert(clSysLog);
    }

}
