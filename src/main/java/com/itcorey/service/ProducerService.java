package com.itcorey.service;


import javax.jms.Destination;

/**
 * @Classname ProducerService
 * @Description 消息生产者
 * @Date 2020/5/19 14:47
 * @Created by corey
 */
public interface ProducerService {

    void sendMessage(final String msg);

    void sendMessage(final String msg, Destination destination);

    void publish(final String msg);


}
