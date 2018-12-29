package com.example.wph_shoping_consumer.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.wph_shoping_consumer.service.AddShopingCar;
import com.example.wph_shoping_consumer.service.SeckillService;
import com.example.wph_shoping_consumer.service.ShopcarService;
import com.example.wph_shoping_consumer.service.ShopingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddShopingCarImpl implements AddShopingCar {
    @Autowired
    private ShopingService shopingService;
    @Autowired
    private SeckillService seckillService;
    @Autowired
    private ShopcarService shopcarService;
    @Override
    public String addShoping(String productId,Integer shopingNumber,Integer userid) {
        String s = shopingService.selectSku(productId,shopingNumber);
        System.out.println(s);
        if(s!=null){
            String s1 = shopingService.WphSelectku(productId,shopingNumber);
            JSONArray objects = JSON.parseArray(s1);
            String s2 = seckillService.cutRepertory((String) objects.get(2), productId, (String) objects.get(1));
            System.out.println((String) objects.get(2));
            System.out.println(productId);
            System.out.println((String) objects.get(1));
            System.out.println("-----------------"+s2);
            if (s2.equals("1")){
                System.out.println(userid);
                String s3 = shopcarService.wph_shopcart_add(s,userid);
                System.out.println("******************"+s3);
                return s3;
            }
            return "库存不足";
        }
        return "无此商品";
    }
}
