package com.itcorey.service.impl;

import com.itcorey.mapper.UserMapper;
import com.itcorey.pojo.User;
import com.itcorey.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2020/6/3 11:20
 * @Created by corey
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUserInfo() {
        return userMapper.QueryAllUser();
    }
}
