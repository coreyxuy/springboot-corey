package com.itcorey.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.itcorey.mapper.sysConfigMapper;
import com.itcorey.pojo.sysConfig;
import com.itcorey.utils.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Classname RedisUtils
 * @Description redis 缓存工具类
 * @DOC 次启动类会在启动的时候加载 sysconfig表多的配置信息
 *      并且同时同步信息到 缓存map 和redis 缓存数
 * @Date 2020/5/28 11:11
 * @Created by corey
 */
@Component
public class RedisCacheUtils {

    private final static Logger log = LoggerFactory.getLogger(RedisCacheUtils.class);

    private static RedisTemplate<String, Object> redisTemplate;

    @Resource
    private sysConfigMapper sysConfigMapper;


    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        if (null == redisTemplate) {
            log.info("Redis初始化配置失败，请检查配置项");
        } else {
            log.info("Redis初始化配置注入成功!.....开始加载缓存");
            Map<String, Object> configMap = new HashMap<String, Object>();
            List<sysConfig> sysConfigs = sysConfigMapper.findAll();
            redisTemplate.opsForValue().set("REDIS_CONFIG_TEST",sysConfigs);
            log.info("sysConfig {}", JSON.toJSON(sysConfigs));
            for (sysConfig sysConfig : sysConfigs) {
                if (null != sysConfig && StringUtil.isNotBlank(sysConfig.getCode())) {
                    configMap.put(sysConfig.getCode(), sysConfig.getValue());
                }
            }
            Global.configMap = new HashMap<String, Object>();
            Global.configMap.putAll(configMap);
        }
    }

}


