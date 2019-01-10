package lyx.rabbitmq.helloworld;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Title receiver
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2019\1\9 0009 17:13
 */

@Component
public class receiver {

    @RabbitListener(queues = "MQ-queue")
    public void get(String message){
        System.out.println("接收信息："+message);
    }
}
