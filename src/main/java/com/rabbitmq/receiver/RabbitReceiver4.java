package com.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Wrecked
 * @date 2019.01.19  10:27
 */
@Component
@RabbitListener(queues = "topic.messages")
public class RabbitReceiver4 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver4  : " + hello);
    }
}
