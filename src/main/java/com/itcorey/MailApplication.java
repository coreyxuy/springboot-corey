package com.itcorey;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootApplication
@EnableJms //支持jms
@EnableScheduling
@ComponentScan(basePackages = "com.itcorey.*")
public class MailApplication {


	private static ApplicationContext applicationContext;


	@Bean
	public Topic topic() {
		return new ActiveMQTopic("news.topic");
	}

	@Bean
	ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory();
	}

	@Bean
	JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.setPriority(999);
		return jmsTemplate;
	}

	@Bean(value = "jmsMessagingTemplate")
	JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
		JmsMessagingTemplate messagingTemplate = new JmsMessagingTemplate(jmsTemplate);
		return messagingTemplate;
	}

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("message.queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class, args);
    }
}
