package com.itcorey;

import com.itcorey.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloworldApplicationTests {

    @Resource
    private RedisTemplate<String,User> redisTemplate;
    private User user;


    @Before
    public void before(){
      user=new User();
        user.setDate("123");
        user.setDaysId("456");
        user.setItemNumber(123);
        user.setOpenId("dawda");
        user.setTitle("title");

    }

    @Test
    public void testUser(){
        this.redisTemplate.opsForValue().set("days",user);
        System.out.println((redisTemplate.opsForValue().get("days")));
    }




    @Test
    public void redisTemplateTest(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());

//        redisTemplate.opsForValue().set("傻逼","看过来");
//        System.out.println("corey"+redisTemplate.opsForValue().get("corey"));
    }



	@Test
	public void contextLoads() {
        System.out.println("success!");
    }



}
