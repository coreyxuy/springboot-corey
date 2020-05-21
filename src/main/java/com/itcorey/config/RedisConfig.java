package com.itcorey.config;

import com.itcorey.pojo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Classname RedisConfig
 * @Description Rredis 配置类
 * @Date 2020/5/21 11:38
 * @Created by corey
 */
@Configuration
public class RedisConfig {

    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String ,Object> template = new RedisTemplate<>();
        //关联
        template.setConnectionFactory(factory);
        //设置key的序列化
        template.setKeySerializer(new StringRedisSerializer());
        //设置key的序列化
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        return template;
    }
}
