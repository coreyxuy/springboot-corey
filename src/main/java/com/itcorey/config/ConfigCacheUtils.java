package com.itcorey.config;

import com.alibaba.fastjson.JSON;
import com.itcorey.pojo.sysConfig;
import com.itcorey.utils.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: corey
 * @Date: 2020/6/19 09:52
 * @Description: 加载缓存启动
 */
@Configuration
public class ConfigCacheUtils {

    private final static Logger log = LoggerFactory.getLogger(ConfigCacheUtils.class);

    @Resource
    private com.itcorey.mapper.sysConfigMapper sysConfigMapper;


    @Bean
    public Map<String, Object>  ConfigCache() {
        log.info("configMap缓存。。。开始加载缓存");
        Map<String, Object> configMap = new HashMap<String, Object>();
        List<sysConfig> sysConfigs = sysConfigMapper.findAll();
        log.info("sysConfig {}", JSON.toJSON(sysConfigs));
        for (sysConfig sysConfig : sysConfigs) {
            if (null != sysConfig && StringUtil.isNotBlank(sysConfig.getCode())) {
                configMap.put(sysConfig.getCode(), sysConfig.getValue());
            }
        }
        log.info("加载成功。。。。。。");
        Global.configMap = new HashMap<String, Object>();
        Global.configMap.putAll(configMap);
        return configMap;
    }
}
