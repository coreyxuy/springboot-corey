package com.itcorey.config;

import com.itcorey.mapper.sysConfigMapper;
import com.itcorey.pojo.sysConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname RedisUtils
 * @Description redis 缓存工具类
 * @DOC 次启动类会在启动的时候加载 sysconfig表多的配置信息
 *      并且同时同步信息到redis 缓存数
 * @Date 2020/5/28 11:11
 * @Created by corey
 */
@Component
public class RedisCacheUtils {

    private final static Logger log = LoggerFactory.getLogger(RedisCacheUtils.class);

    private static RedisTemplate<String, Object> redisTemplate;

    @Resource
    private sysConfigMapper sysConfigMapper;

    /**
     *
     * @param redisTemplate
     */
    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        if (null == redisTemplate) {
            log.info("Redis初始化配置失败，请检查配置项");
        } else {
            log.info("Redis初始化开始加载缓存。。。。。！");
            List<sysConfig> sysConfigs = sysConfigMapper.findAll();
            redisTemplate.opsForValue().set("REDIS_CONFIG_TEST",sysConfigs);
            log.info("加载缓存成功。。。。。！");
        }
    }

}


