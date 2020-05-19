package com.itcorey.controller;

import com.itcorey.service.ProducerService;
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
@RestController
public class NewsController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/publish")
    public String publish(String news) {
        // 发布信息
        producerService.publish(news);
        return "success!!!";
    }
}
