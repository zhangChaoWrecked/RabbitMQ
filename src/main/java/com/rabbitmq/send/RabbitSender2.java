package com.rabbitmq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Wrecked
 * @date 2019.01.19  10:28
 */
@Component
public class RabbitSender2 {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        System.out.println("Sender2 : " + msg);
        this.rabbitTemplate.convertAndSend("hello", msg);
    }
}
