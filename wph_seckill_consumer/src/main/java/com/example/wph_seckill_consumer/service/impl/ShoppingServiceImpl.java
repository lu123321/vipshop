package com.example.wph_seckill_consumer.service.impl;

import com.example.wph_seckill_consumer.service.ShoppingService;
import org.springframework.stereotype.Component;

@Component
public class ShoppingServiceImpl  implements ShoppingService {


    @Override
    public String WphBrandSku(String BrandId, String time) {
        return "上架失败";
    }

    @Override
    public String xiajiaBrand(String xiajia) {
        return "下架失败";
    }
}
