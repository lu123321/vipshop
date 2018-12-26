package com.example.wph_seckill_consumer.service.impl;

import com.example.wph_seckill_consumer.service.SeckillService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SeckillServiceImpl implements SeckillService {
    @Override
    public String addRepertory(String brandId, String message) {
        return "系统维护";
    }

    @Override
    public String removeRepertory(String brandId) {
        return "系统维护";
    }
}
