package com.example.wph_order_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_order_provider.dao.WphOrderShopingDao;
import com.example.wph_order_provider.entity.WphOrderShoping;
import com.example.wph_order_provider.service.WphOrderShopingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WphOrderShopingServiceImpl implements WphOrderShopingService {

    @Autowired
    private WphOrderShopingDao wphOrderShopingDao;


    @Override
    public int insert(Integer orderid, String skuSerialnumber, Integer num,Integer money) {
        return wphOrderShopingDao.insert(orderid,skuSerialnumber,num,money);
    }

    @Override
    public boolean deleteById(Integer orderShopingId,Integer userid) {
        return wphOrderShopingDao.deleteById(orderShopingId)==1;
    }

    @Override
    public List<WphOrderShoping> queryAll(Integer orderid) {
        List list=wphOrderShopingDao.queryAll(orderid);
        return list;
    }
}
