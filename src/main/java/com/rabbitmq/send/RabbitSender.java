package com.rabbitmq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Wrecked
 * @date 2019.01.19  10:28
 */
@Component
public class RabbitSender {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        System.out.println("Sender1 : " + msg);
        this.rabbitTemplate.convertAndSend("hello", msg);
    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }

    public void send3() {
        String context = "hi, fanout msg";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "topic.messages", context);
    }
}
