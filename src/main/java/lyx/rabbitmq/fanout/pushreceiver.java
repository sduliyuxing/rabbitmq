package lyx.rabbitmq.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * @RabbitListener bindings:绑定队列
 * @QueueBinding  value:绑定队列的名称
 *                exchange:配置交换器
 *
 * @Queue value:配置队列名称
 *        autoDelete:是否是一个可删除的临时队列
 *
 * @Exchange value:为交换器起个名称
 *           type:指定具体的交换器类型
 */

@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${fanout.queue.push}",autoDelete = "true"),
        exchange = @Exchange(value ="${fanout.exchange}",type = ExchangeTypes.FANOUT)
))
@Component
public class pushreceiver {

    @RabbitHandler
    public void get(String message){
        System.out.println("push接收:  "+message);
    }
}
