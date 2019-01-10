package lyx.rabbitmq.helloworld;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title config
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2019\1\9 0009 17:08
 */

@Configuration
public class config {


    @Bean
    public Queue getqueue(){
        return new Queue("MQ-queue");
    }
}
