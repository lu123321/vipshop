package com.example.wph_shopcar_provider.srvice.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_shopcar_provider.pojo.Shoping;
import com.example.wph_shopcar_provider.pojo.WphSku;
import com.example.wph_shopcar_provider.srvice.ShopcarService;
import com.example.wph_shopcar_provider.util.RabbitConfig;
import com.example.wph_shopcar_provider.util.RedisUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.*;

@Service
public class ShopcarServiceImpl implements ShopcarService{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisUtil redisUtil=new RedisUtil();
    Map<String,Object> wphSkuMap=new HashMap<String,Object>();

    /**
     * 延时队列监听,二十分钟
     * @param message 购物车中过期信息
     */
    @RabbitListener(queues = RabbitConfig.YS_Queue)
    public void geta(Map message){
        redisUtil.hmset(message.keySet()+"shophistroy", message);
        rabbitTemplate.convertAndSend(RabbitConfig.KC_Queue, message );
    }

    /**
     * 购物车中增加商品
     * @param id 测试参数,暂定为用户id或商品编号
     * @param num 测试参数,暂定为商品数量
     */
    @Override
    public void wph_shopcart_add(String id, int num) {

        //检测其中是否有相同商品编号id,若有则叠加商品数量,至多为两件
        if(redisUtil.hmget("["+id+"]shopcart").containsKey(id)){
            wphSkuMap.put(id,2);
            redisUtil.hmset("["+id+"]shopcart",wphSkuMap,12000);
        }else{
            WphSku wphSku=new WphSku();
            wphSku.setSkuNumber(num);
            wphSkuMap.put(id,num);
            redisUtil.hmset("["+id+"]shopcart",wphSkuMap,12000);//存放至redis中;设置20分钟过期时间;
        }
        //将信息存至延时队列进行监听
        rabbitTemplate.convertAndSend(RabbitConfig.YS_Queue,wphSkuMap );

    }


    /**
     * 删除购物车中商品
     * @param id 测试参数,暂定为用户id或商品编号
     */
    @Override
    public void wph_shopcart_del(String id) {
        Integer num=(Integer) redisUtil.hget("["+id+"]shopcart",id);//获取其中商品列表
        wphSkuMap.put(id,num);
        redisUtil.hmset("["+id+"]shophistroy", wphSkuMap);//将其存入购物历史
        redisUtil.hdel("["+id+"]shopcart",id);
        rabbitTemplate.convertAndSend(RabbitConfig.KC_Queue, wphSkuMap);//返库存
    }

    /**
     * 修改商品数量
     * @param id
     * @param num
     */
    @Override
    public void wph_shopcart_update(String id,int num){
        //调用查看库存接口
        if(num>2){
            num=2;
        }else {
            num=1;
        }
        wphSkuMap.put(id,num);
        redisUtil.hmset("["+id+"]shopcart",wphSkuMap);
        rabbitTemplate.convertAndSend(RabbitConfig.KC_Queue, wphSkuMap);//返库存
    }

    /**
     * 查看购物车中商品
     * @param id 测试参数,暂定为用户id
     * @return
     */
    @Override
    public Map wph_shopcart_sel(String id) {
        Map map= redisUtil.hmget("["+id+"]shopcart");
        return map;
    }

}
