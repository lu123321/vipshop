package com.example.wph_seckill_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_seckill_provider.config.RabbitConfig;
import com.example.wph_seckill_provider.entity.Kc;
import com.example.wph_seckill_provider.service.CutRepertoryService;
import com.example.wph_seckill_provider.service.pojo.GetRepertoey;
import com.example.wph_seckill_provider.util.RedisUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.KdcComm;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CutRepertoryServiceImpl implements CutRepertoryService {
    @Autowired
    private  RabbitTemplate rabbitTemplate;
    @Resource
    private RedisUtil redisUtil;
    /**
     * 通过商品编号和商品数量进行库存锁定
     * @param productId
     * @param number
     * @return
     */
    @Override
    public String cutrepertory(String pinpaiId,String productId, String number) {
        if(pinpaiId != null && pinpaiId !="" && productId != null && productId != ""&& number != null && number != ""){
            //得到对应的商品的数量
            Map<Object, Object> hmget = redisUtil.hmget(pinpaiId+"pp");
            if(hmget.size() != 0){
                Integer o = (Integer) hmget.get(productId);
                int i = Integer.parseInt(number);
                if(o >= i){
                    //如果扣除数量后还有剩余数量，就更新redis数量
                    if(o-i>0){
                        hmget.put(productId,o-i);
                        redisUtil.hmset(pinpaiId+"pp",hmget);
                        //返回有库存
                        return "1";
                    }else if(o-i == 0){
                        //此时需要将商品进行下架
                        hmget.put(productId,0);
                        redisUtil.hmset(pinpaiId+"pp",hmget);
                        //将下架商品通过MQ通知到商品模块
                        rabbitTemplate.convertAndSend(RabbitConfig.WPH_SPRETURN,productId);
                        return "1";
                    }
                }else{
                    //返回无库存
                    return "2";
                }
            }else{
                return "2";
            }
        }else{
            return "2";
        }
        return  null;
    }
    /**
     * 通过品牌订单和商品信息来进行商品的上架
     * @param brandId
     * @param message
     * @return
     */
    @Override
    public String addRepertory(String brandId, String message) {
        List<GetRepertoey> getRepertoeys = JSON.parseArray(message, GetRepertoey.class);
        Map<Object,Object> rMap = new HashMap<Object, Object>();
        for (GetRepertoey g:getRepertoeys) {
            rMap.put(g.getProductId(),g.getNumber());
        }
        redisUtil.hmset(brandId+"pp",rMap);
        return "200";
    }

    /**
     * 通过品牌Id将有关品牌的商品移出redis
     * @param brandId
     * @return
     */
    @Override
    public String removeRepertory(String brandId) {
        System.out.println(brandId);
        Map<Object, Object> hmget = redisUtil.hmget(brandId+"pp");
        List<GetRepertoey> glist = new ArrayList<GetRepertoey>();
        Set<Object> objects = hmget.keySet();
        System.out.println(objects.size());
        for (Object o:objects) {
            GetRepertoey g = new GetRepertoey();
            g.setProductId((String) o);
            g.setNumber((Integer) hmget.get(o));
            glist.add(g);
        }
        System.out.println("***********");
        redisUtil.del(brandId+"pp");
        System.out.println("qqqqqqqqqqqq");
        System.out.println(glist.size());
        return JSON.toJSONString(glist);
    }

    /**
     * 如果购物车或订单取消时进行商品归还
     * @param message
     * @return
     */

    @RabbitListener(queues = RabbitConfig.FKC_Queue)
    public void returnsku(String message) {
        System.out.println(message);
        List<Kc> kcs = JSON.parseArray(message, Kc.class);
        List<GetRepertoey> glist = new ArrayList<GetRepertoey>();
        //如果格式正确，进行相应的库存增加
        for (Kc k:kcs){
            boolean b = redisUtil.hasKey(k.getBrand().toString()+"pp");
            System.out.println(b);
            if(b){
                System.out.println("111111111");
                long l = k.getSkunum().longValue();
                redisUtil.hincr(k.getBrand().toString()+"pp",k.getSkunumber(),l);
            }else{
                System.out.println("ccccccccccccc");
                GetRepertoey g = new GetRepertoey();
                g.setProductId(k.getSkunumber());
                g.setNumber(k.getSkunum());
                glist.add(g);
            }
        }
        rabbitTemplate.convertAndSend(RabbitConfig.XJFKC_Queue,JSON.toJSONString(glist));
    }
}
