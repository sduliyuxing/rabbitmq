package lyx.rabbitmq.helloworld;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Title sender
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2019\1\9 0009 17:11
 */

@Component
public class sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message){
        System.out.println("发送信息："+message);
        amqpTemplate.convertAndSend("MQ-queue",message);
    }
}
