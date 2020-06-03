package com.itcorey.service;

import com.github.pagehelper.Page;
import com.itcorey.pojo.QuartzLog;
import com.itcorey.pojo.QuartzLogModel;

import java.util.Map;

/**
 * @Classname QuartzLogService
 * @Description 定时任务记录Service
 * @Date 2020/6/3 11:07
 * @Created by corey
 */
public interface QuartzLogService {

    /**
     * 保存日志
     */
    int save(QuartzLog ql);

    Page<QuartzLogModel> page(Map<String, Object> searchMap, int current,
                              int pageSize);
}
