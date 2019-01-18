package com.example.wph_order_provider.util;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfig {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static final String WPH2_SHOPING = "wph2_shoping";//商品上架队列
    public static final String WPH2_SPRETURN = "wph2_spReturn";//存款队列
    public static final String DLE2_Queue = "del2_queue";
    public static  final  String DLE2_change = "dle2_change";
    public static final String user2_change = "user2_change";
    public static final String YS2_Queue = "ys2_queue";
    public static final String KC2_Queue = "kc2_queue";//返库存
    public static final String HQY_queue = "hqy_queue";//返库存

    @Bean
    public Queue seckillOrderQueue() {
        return new Queue(WPH2_SHOPING);
    }

    @Bean
    public Queue seckillLoserQueue() {
        return new Queue(WPH2_SPRETURN);
    }
    //配置延时队列
    @Bean
    public Queue DLEqueue(){
        Map<String,Object> args = new HashMap<String, Object>();
        args.put("x-dead-letter-exchange",user2_change);
        args.put("x-dead-letter-routing-key",DLE2_Queue);
        args.put("x-message-ttl",1000*60*19+55);
        return new Queue(DLE2_Queue,false,false,false,args);
    }
    //配置用户队列
    @Bean
    public Queue ys2queue(){return new Queue(YS2_Queue);}

    //返库存
    @Bean
    public Queue kc2queue(){return new Queue(KC2_Queue);}

    //配置延时交换机
    @Bean
    public DirectExchange dalyExchange(){
        return new DirectExchange(DLE2_change,true,false);
    }
    //配置用户交换机
    @Bean
    public DirectExchange userExchange(){
        return new DirectExchange(user2_change,true,false);
    }
    //绑定延迟交换机和延迟队列
    @Bean
    Binding bindingSXExchangeA() {
        return BindingBuilder.bind(DLEqueue()).to(dalyExchange()).with(DLE2_Queue);
    }
    //绑定用户交换机和用户队列
    @Bean
    Binding bindingDirectExchangeA() {
        return BindingBuilder.bind(ys2queue()).to(userExchange()).with(DLE2_Queue);
    }
}
