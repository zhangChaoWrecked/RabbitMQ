package com.rabbitmq.rabbitmq;

import com.rabbitmq.receiver.RabbitReceiver;
import com.rabbitmq.send.RabbitSender;
import com.rabbitmq.send.RabbitSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {


    @Autowired
    private RabbitSender rabbitSender;
    @Autowired
    private RabbitSender2 rabbitSender2;

    @Autowired
    private RabbitReceiver rabbitReceiver;

    //一对一
    @Test
    public void one2one() throws Exception {
        rabbitSender.send("第一条消息");

    }

    //一对多消费者
    @Test
    public void one2Many() throws Exception {
        for (int i = 0; i < 10; i++) {
            rabbitSender.send("这是第" + i + "条消息");
        }
    }

    //多对多消费者
    @Test
    public void many2Many() throws Exception {
        for (int i = 0; i < 10; i++) {
            rabbitSender.send("这是第" + i + "条消息");
            rabbitSender2.send("这是第" + i * 20 + "条消息");
        }
    }


    @Test
    public void topic1() throws Exception {
        rabbitSender.send1();
        rabbitSender.send2();
    }

    //测试订阅或者广播模式
    @Test
    public void fanoutTest() throws Exception {
        rabbitSender.send3();
     }

}



