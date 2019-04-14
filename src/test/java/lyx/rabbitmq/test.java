package lyx.rabbitmq;

import lyx.rabbitmq.direct.directsender;
import lyx.rabbitmq.fanout.fanoutsender;
import lyx.rabbitmq.helloworld.sender;
import lyx.rabbitmq.topic.ordersender;
import lyx.rabbitmq.topic.productsender;
import lyx.rabbitmq.topic.usersender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title test
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2019\1\9 0009 17:16
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = main.class)
public class test {

    @Autowired
    private sender sender;

    @Autowired
    private directsender directsender;

    @Autowired
    private usersender usersender;

    @Autowired
    private ordersender ordersender;

    @Autowired
    private productsender productsender;

    @Autowired
    private fanoutsender fanoutsender;


    @Test
    public void testhelloworld(){
        sender.send("hello mq");
    }

    @Test
    public void testdirect() throws InterruptedException {
        int i=0;
        while (true){
            System.out.println(i);
            i++;
            directsender.send("hello mq");
            Thread.sleep(1000);
        }
    }

    @Test
    public void testtopic(){
        usersender.send("usersender....");
        ordersender.send("ordersender....");
        productsender.send("productsender....");
    }

    @Test
    public void testfanout(){
        fanoutsender.send("hello mq");
    }
}
