package lyx.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Title sender
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2019\1\10 0010 10:55
 */

@Component
public class directsender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${direct.exchange}")
    private String exchange;

//    @Value("${direct.queue.info.key}")
    @Value("${direct.queue.error.key}")
    private String key;

    public void send(String message){
        //向消息队列发送消息
        //参数一：交换器名称。
        //参数二：路由键
        //参数三：消息
        amqpTemplate.convertAndSend(exchange,key,message);
    }
}