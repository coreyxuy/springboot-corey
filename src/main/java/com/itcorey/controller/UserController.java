package com.itcorey.controller;

import com.itcorey.pojo.User;
import com.itcorey.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("根据id查询同志信息")
    public R UserRegist(@Valid User user) {
        return null;


    }
}
