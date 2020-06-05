package com.itcorey.controller;

import com.itcorey.controller.dto.req.UserReqDto;
import com.itcorey.mapper.UserMapper;
import com.itcorey.pojo.User;
import com.itcorey.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tool.util.StringUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/6/4 18:36
 * @Created by corey
 */
@Controller
@Api(tags = "用户相关")
@RequestMapping("/user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(FileController.class);

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("根据id查询同志信息")
    public R UserRegist(@Valid UserReqDto userReqDto) {
        User user = new User();

//        userMapper.insert();
        return null;


    }
}
