package com.itcorey.passw;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Classname MessageConsumer
 * @Description TODO
 * @Date 2020/5/19 15:01
 * @Created by corey
 */
@Component
public class MessageConsumer {

    @JmsListener(destination = "message.queue")
    public void receiveMessage(String txt) {
        System.out.println("MessageConsumer接收到的信息：" + txt);
    }
}
