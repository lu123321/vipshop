package com.example.wph_shopcar_consumer.service.Impl;

import com.example.wph_shopcar_consumer.service.SelectSkuService;
import org.springframework.stereotype.Service;

@Service
public class SelectSkuServiceImpl implements SelectSkuService {
    @Override
    public String selectSku(Integer spuId) {
        return "熔断啦";
    }
}