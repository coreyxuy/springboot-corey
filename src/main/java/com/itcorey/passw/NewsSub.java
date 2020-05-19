package com.itcorey.passw;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Classname NewsSub
 * @Description TODO
 * @Date 2020/5/19 15:34
 * @Created by corey
 */
@Component
public class NewsSub {

    @JmsListener(destination = "news.topic")
    public void receive1(String text) {
        System.out.println("news.topic 消费者:receive1=" + text);
    }

    @JmsListener(destination = "news.topic")
    public void receive2(String text) {
        System.out.println("news.topic 消费者:receive2=" + text);
    }

    @JmsListener(destination = "news.topic")
    public void receive3(String text) {
        System.out.println("news.topic 消费者:receive3=" + text);
    }
}
