package com.itcorey.service.impl;

import com.itcorey.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Classname ProducerServiceImpl
 * @Description 上产消息的实现类
 * @Date 2020/5/19 14:57
 * @Created by corey
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Resource
    private Topic topic;

    @Resource
    private Queue queue;//默认消息队列

    //用来发送消息到broker的对象
    @Autowired
    private JmsMessagingTemplate JmsTemplate;

    //发送消息
    @Override
    public void sendMessage(String msg) {
        JmsTemplate.convertAndSend(this.queue, msg);
    }

    //发送消息
    @Override
    public void sendMessage(String msg, Destination destination) {
        JmsTemplate.convertAndSend(destination, msg);
    }

    @Override
    public void publish(String msg) {
        JmsTemplate.convertAndSend(this.topic, msg);
    }
}
