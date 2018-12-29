package com.example.wph_shopcar_consumer.service.Impl;

import com.example.wph_shopcar_consumer.pojo.WphUserAddress;
import com.example.wph_shopcar_consumer.service.AdressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressServiceImpl implements AdressService {


    @Override
    public List<WphUserAddress> selectAll(int id) {
        return null;
    }

    @Override
    public String insert(WphUserAddress wphUserAddress) {
        return "新增失败";
    }

    @Override
    public String update(WphUserAddress wphUserAddress) {
        return "修改失败";
    }
}
