package com.itcorey.controller;

import com.itcorey.service.ProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname NewsController
 * @Description TODO
 * @Date 2020/5/19 15:47
 * @Created by corey
 */
@RequestMapping("/api/news")
@Api(tags = "发布订阅模式")
@RestController
public class NewsController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/publish")
    @ApiOperation("发布订阅发送消息")
    public String publish(String news) {
        // 发布信息
        producerService.publish(news);
        return "success!!!";
    }
}
