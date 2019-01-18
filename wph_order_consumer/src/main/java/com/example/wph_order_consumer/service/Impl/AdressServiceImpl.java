package com.example.wph_order_consumer.service.Impl;

import com.example.wph_order_consumer.pojo.WphUserAddress;
import com.example.wph_order_consumer.service.AdressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressServiceImpl implements AdressService {


    @Override
    public String selectAll(Integer id) {
        return "查询失败";
    }

    @Override
    public String insert(WphUserAddress wphUserAddress) {
        return "新增失败";
    }

    @Override
    public String update(WphUserAddress wphUserAddress) {
        return "修改失败";
    }

    @Override
    public String updateState(Integer addId,Integer addState) {
        return "修改默认地址异常";
    }
}
