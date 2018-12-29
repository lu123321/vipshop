package com.example.wph_shopcar_provider.srvice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.wph_shopcar_provider.pojo.Kc;
import com.example.wph_shopcar_provider.pojo.Shoping;
import com.example.wph_shopcar_provider.pojo.WphSku;
import com.example.wph_shopcar_provider.srvice.ShopcarService;
import com.example.wph_shopcar_provider.util.DateUtil;
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
    private RedisUtil redisUtil;


    private DateUtil dateUtil=new DateUtil();
    WphSku wphSku=new WphSku();
    Kc kc=new Kc();


    /**
     * 延时队列监听,二十分钟
     * @param shoping1 购物车中过期信息   ?
     */
    @RabbitListener(queues = RabbitConfig.YS_Queue)
    public void geta(String shoping1){
        Shoping shoping= JSON.parseObject(shoping1,Shoping.class);
        Integer id=shoping.getUserid();
        long s=redisUtil.getExpire("["+id+"]shopcart");
        if(s<=5) {
            Map map=redisUtil.hmget("["+id+"]shopcart");
            List<Kc> list=new ArrayList<Kc>();
            Set set=map.keySet();
            for (Object a:set){
                Kc kc=new Kc();
                Shoping b=(Shoping) map.get(a);
                String skuserialnumber1=b.getShopingnumber();
                Integer brand1=b.getBrand();
                Integer skunum1=b.getShopingnum();
                kc.setSkunumber(skuserialnumber1);
                kc.setBrand(brand1);
                kc.setSkunum(skunum1);
                list.add(kc);
            }
            redisUtil.hmset("["+id+"]shophistroy", map);
            rabbitTemplate.convertAndSend(RabbitConfig.FKC_Queue, JSON.toJSONString(list));
        }
    }

    /**
     * 购物车中增加商品
     * @param listnumber json中包含
     */
    @Override
    public String wph_shopcart_add(String listnumber,Integer userid) {
        boolean flag;
        Map<String,Object> wphSkuMap=new HashMap<String,Object>();
        List list=JSON.parseArray(listnumber);
        String skuserialnumber=(String)list.get(1);
        String skuname=(String)list.get(0);
        Double skumoney=Double.parseDouble((String) list.get(2));
        String skupicture=(String)list.get(3);
        Integer skunum=Integer.parseInt((String) list.get(4));
        Shoping shoping=new Shoping();
        shoping.setShopingname(skuname);
        shoping.setShopingnumber(skuserialnumber);
        shoping.setShopingmoney(skumoney);
        shoping.setPicture(skupicture);
        shoping.setShopingnum(skunum);
        shoping.setBrand(Integer.parseInt((String) list.get(5)));
        shoping.setSpuid(Integer.parseInt((String)list.get(6)));
        shoping.setUserid(userid);
        if(skunum>2){
            kc.setSkunum(skunum);
            kc.setSkunumber(skuserialnumber);
            kc.setBrand(shoping.getBrand());
            List li=new ArrayList();
            li.add(kc);
            rabbitTemplate.convertAndSend(RabbitConfig.FKC_Queue, JSON.toJSONString(li));
            return "不能超过两件";
        }
        //检测其中是否有相同商品编号id,若有则叠加商品数量,至多为两件
        if(redisUtil.hmget("["+userid+"]shopcart").containsKey(skuserialnumber)){
            Shoping shoping1 =(Shoping) redisUtil.hget("["+userid+"]shopcart",skuserialnumber);
            System.out.println("123"+shoping1.getShopingname());
            System.out.println("已有该商品");
            if (shoping1.getShopingnum()==2){
                kc.setSkunum(skunum);
                kc.setSkunumber(skuserialnumber);
                kc.setBrand(shoping.getBrand());
                List li=new ArrayList();
                li.add(kc);
                rabbitTemplate.convertAndSend(RabbitConfig.FKC_Queue, JSON.toJSONString(li));
                System.out.println("listnumber = [" + listnumber + "], userid = [" + userid + "]");
                return "不能增加啦";
            }
            shoping1.setShopingnum(2);
            wphSkuMap.put(skuserialnumber,shoping1);
            flag=redisUtil.hmset("["+userid+"]shopcart",wphSkuMap);
        }else{
            wphSkuMap.put(skuserialnumber,shoping);
            flag=redisUtil.hmset("["+userid+"]shopcart",wphSkuMap,60);//存放至redis中;设置20分钟过期时间;单位秒
        }

        //将信息存至延时队列进行监听
        rabbitTemplate.convertAndSend(RabbitConfig.DLE_change,RabbitConfig.DLE_Queue,JSON.toJSONString(shoping) );
        if (flag==true){
            System.out.println("添加成功");
            return "添加成功";
        }else {
            System.out.println("添加失败");
            return "添加失败";
        }
    }


    /**
     * 删除购物车中商品
     * @param userid 测试参数,暂定为用户id或商品编号
     */
    @Override
    public void wph_shopcart_del(String userid,String skuserialnumber) {
        System.out.println(" skuserialnumber = [" + skuserialnumber + "]");
        Map<String,Object> wphSkuMap=new HashMap<String,Object>();
        Shoping shoping=(Shoping) redisUtil.hget("["+userid+"]shopcart",skuserialnumber);//获取其中商品列表
        Integer skunum=(Integer)shoping.getShopingnum();
        Map map=new HashMap();
        map.put(skuserialnumber,shoping);
        redisUtil.hmset("["+userid+"]shophistroy", map);//将其存入购物历史
        redisUtil.hdel("["+userid+"]shopcart",skuserialnumber);
        kc.setBrand( shoping.getBrand());
        kc.setSkunumber(shoping.getShopingnumber());
        kc.setSkunum(shoping.getShopingnum());
        List li=new ArrayList();
        li.add(kc);
        rabbitTemplate.convertAndSend(RabbitConfig.FKC_Queue, JSON.toJSONString(li));//返库存
    }

    /**
     * 修改商品数量
     * @param userid 用户id
     * @param shoping 商品列表
     */
    @Override
    public void wph_shopcart_update(Integer userid,String shoping){
        Map<String,Object> wphSkuMap=new HashMap<String,Object>();
        List list= JSON.parseArray(shoping);
        for(int i=0;i<list.size();i++){
            List a=JSON.parseArray((String) list.get(i));
            String skunumber=(String) a.get(0);
            Integer num=Integer.parseInt((String) list.get(1));
            List b =(List) redisUtil.hget("["+userid+"]shopcart",skunumber);
            b.set(4,num);
            wphSkuMap.put(skunumber,b);
            redisUtil.hmset("["+userid+"]shopcart",wphSkuMap);
        }
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

    /**
     * 查看订单历史
     * @param id
     * @return
     */
    @Override
    public Map wph_shophistroy_sel(String id) {
        Map map= redisUtil.hmget("["+id+"]shophistroy");
        return map;
    }
}
