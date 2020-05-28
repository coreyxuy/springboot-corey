package com.itcorey.utils;


import com.alibaba.fastjson.JSONObject;
import com.itcorey.config.Global;
import com.itcorey.pojo.sysConfig;
import com.itcorey.service.sysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Classname CacheUtil
 * @Description 缓存启动类
 * @Date 2020/5/28 15:40
 * @Created by corey
 */
@Component
public class CacheUtil {

    private static final Logger logger = LoggerFactory.getLogger(CacheUtil.class);


    public static void initSysConfig() {
        logger.info("初始化系统配置Config...");
        sysConfigService sysConfigService = (sysConfigService) SpringBeanUtil.getBean("sysConfigService");
        Map<String, Object> configMap = new HashMap<String, Object>();
        List<sysConfig> sysConfigs = sysConfigService.findAll();
        logger.info("===="+ JSONObject.toJSONString(sysConfigs));
        for (sysConfig sysConfig : sysConfigs) {
            if (null != sysConfig && !Objects.isNull(sysConfig.getCode())) {
                configMap.put(sysConfig.getCode(), sysConfig.getValue());
            }
        }
        Global.configMap = new HashMap<String, Object>();
        Global.configMap.putAll(configMap);

    }
}
