package com.itcorey.controller;

import com.itcorey.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname MessageController
 * @Description 定义消息的生产者和消费者
 * @Date 2020/5/19 14:44
 * @Created by corey
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Resource
    private ProducerService producerService;

    @GetMapping("/send")
    public String sendMsg(String message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
            for (int i = 0;i<=10;i++){
                // 目的地
                ActiveMQQueue desination = new ActiveMQQueue("message.queue");
                // 发送消息
                producerService.sendMessage(message, desination);
            }
            }
        }).start();
        return "success!!";
    }
}
