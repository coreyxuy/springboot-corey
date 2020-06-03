package com.itcorey.service;

import com.itcorey.pojo.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description 用户服务类
 * @Date 2020/6/3 11:16
 * @Created by corey
 */
public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> queryUserInfo();
}
