package com.example.wph_shoping_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_shoping_provider.dao.WphMiddletypeDao;
import com.example.wph_shoping_provider.dao.WphSmalltypeDao;
import com.example.wph_shoping_provider.entity.WphMiddletype;
import com.example.wph_shoping_provider.entity.WphSmalltype;
import com.example.wph_shoping_provider.service.WphMiddletypeService;
import com.example.wph_shoping_provider.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WphMiddletypeServiceImpl implements WphMiddletypeService {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private WphMiddletypeDao wphMiddletypeDao;

    @Override
    public String selectMiddletype(Integer bigpeid) {
        if (redisUtil.get("middletype"+bigpeid)==null){
            WphMiddletype wphMiddletype=new WphMiddletype();
            wphMiddletype.setMiddletypeType(1);
            wphMiddletype.setMiddletypeBigtyprid(bigpeid);
            List<WphMiddletype> wphMiddletypes = wphMiddletypeDao.queryAll(wphMiddletype);
            redisUtil.set("middletype"+bigpeid,wphMiddletypes);
        }
        return JSON.toJSONString(redisUtil.get("middletype"+bigpeid));
    }
}
