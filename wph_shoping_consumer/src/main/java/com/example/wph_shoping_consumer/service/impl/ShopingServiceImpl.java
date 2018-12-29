package com.example.wph_shoping_consumer.service.impl;

import com.example.wph_shoping_consumer.service.ShopingService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
@Component
public class ShopingServiceImpl implements ShopingService {
    @Override
    public String selectSku(@RequestParam("skuSerialnumber")String skuSerialnumber,@RequestParam("shopingNumber")Integer shopingNumber) {
        return "系统异常";
    }

    @Override
    public String WphSelectku(String skuSerialnumber,Integer shopingNumber) {
        return "系统故障";
    }
}
