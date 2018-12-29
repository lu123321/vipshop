package com.example.wph_shoping_consumer.service.impl;

import com.example.wph_shoping_consumer.service.ShopcarService;
import org.springframework.stereotype.Component;

@Component
public class ShopcarServiceImpl implements ShopcarService {
    @Override
    public String wph_shopcart_add(String listnumber,Integer userid) {
        return "系统故障";
    }
}
