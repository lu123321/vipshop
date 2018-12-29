package com.example.wph_shoping_consumer.service.impl;

import com.example.wph_shoping_consumer.service.SeckillService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SeckillServiceImpl implements SeckillService {

    @Override
    public String cutRepertory(String pinpaiId, String productId, String number) {
        return "内部服务错误";
    }

    @Override
    public String schedule(String message, Date jobScheduleTime, Date jobendtime) {
        return "系统故障";
    }
}
