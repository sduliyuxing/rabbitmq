package lyx.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Title usersender
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2019\1\10 0010 11:38
 */

@Component
public class productsender {


    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${topic.exchange}")
    private String exchange;

    public void send(String message){
        amqpTemplate.convertAndSend(exchange,"product.log.debug","product.log.debug"+message);
        amqpTemplate.convertAndSend(exchange,"product.log.error","product.log.error"+message);
        amqpTemplate.convertAndSend(exchange,"product.log.info","product.log.info"+message);
        amqpTemplate.convertAndSend(exchange,"product.log.warn","product.log.warn"+message);
    }
}
