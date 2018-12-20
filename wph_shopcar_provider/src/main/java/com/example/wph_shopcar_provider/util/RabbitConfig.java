package com.example.wph_shopcar_provider.util;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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

    public static final String WPH_SHOPING = "wph_shoping";//商品上架队列
    public static final String WPH_SPRETURN = "wph_spReturn";//存款队列
    public static final String DLE_Queue = "del_queue";
    public static  final  String DLE_change = "dle_change";
    public static final String user_change = "user_change";
    public static final String YS_Queue = "ys_queue";
    public static final String KC_Queue = "kc_queue";//返库存
    @Bean
    public Queue seckillOrderQueue() {
        return new Queue(WPH_SHOPING);
    }

    @Bean
    public Queue seckillLoserQueue() {
        return new Queue(WPH_SPRETURN);
    }
    //配置延时队列
    @Bean
    public Queue DLEqueue(){
        Map<String,Object> args = new HashMap<String, Object>();
        args.put("x-dead-letter-exchange",user_change);
        args.put("x-dead-letter-routing-key",DLE_Queue);
        args.put("x-message-ttl",12000);
        return new Queue(DLE_Queue,false,false,false,args);
    }
    //配置用户队列
    @Bean
    public Queue ysqueue(){return new Queue(YS_Queue);}
    //返库存
    @Bean
    public Queue kcqueue(){return new Queue(KC_Queue);}
    //配置延时交换机
    @Bean
    public DirectExchange dalyExchange(){
        return new DirectExchange(DLE_change,true,false);
    }
    //配置用户交换机
    @Bean
    public DirectExchange userExchange(){
        return new DirectExchange(user_change,true,false);
    }
    //绑定延迟交换机和延迟队列
    @Bean
    Binding bindingSXExchangeA() {
        return BindingBuilder.bind(DLEqueue()).to(dalyExchange()).with(DLE_Queue);
    }
    //绑定用户交换机和用户队列
    @Bean
    Binding bindingDirectExchangeA() {
        return BindingBuilder.bind(ysqueue()).to(userExchange()).with(DLE_Queue);
    }
}
