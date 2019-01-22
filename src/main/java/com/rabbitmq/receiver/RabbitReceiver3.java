package com.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ZhangChao
 * @date 2019.01.19  10:27
 */
@Component
@RabbitListener(queues = "topic.message")
public class RabbitReceiver3 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver3  : " + hello);
    }
}
