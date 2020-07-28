package com.itcorey.controller;

import com.itcorey.controller.dto.req.UserReqDto;
import com.itcorey.mapper.UserMapper;
import com.itcorey.passw.MyLog;
import com.itcorey.pojo.User;
import com.itcorey.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tool.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Classname UserController
 * @Description 用户信息
 * @Date 2020/6/4 18:36
 * @Created by corey
 */
@RestController
@Api(tags = "用户相关")
@RequestMapping("/user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(FileController.class);

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("用户信息注册！")
    @MyLog(value = "用户注册操作!")
    public R UserRegist(@Valid UserReqDto userReqDto, BindingResult result) {
        if (result.hasErrors()) {
            return R.error().data("userReqDto", userReqDto).message(result.getAllErrors().get(0).getDefaultMessage());
        }
        User user = new User();
        user.setName(userReqDto.getName());
        user.setEmail(userReqDto.getEmail());
        user.setPassword(userReqDto.getPassword());
        user.setPhone(userReqDto.getPhone());
        user.setSex(userReqDto.getSex());
        //user.setBirthday(userReqDto.getBirthday());
        user.setStatus(1);
        int insert = userMapper.insert(user);
        return R.ok().data("insert", insert).message("注册成功！");
    }


    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("用户信息注册！")
    @MyLog(value = "用户注册操作!")
    public R UserFeedback() {
        //SESSION 获取用户信息request.getSession();
        return R.ok().message("反馈信息添加成功！");
    }


}
