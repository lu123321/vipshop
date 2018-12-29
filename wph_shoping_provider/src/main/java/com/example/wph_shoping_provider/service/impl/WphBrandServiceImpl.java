package com.example.wph_shoping_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_shoping_provider.dao.WphBrandDao;
import com.example.wph_shoping_provider.dao.WphSmalltypeandbrandDao;
import com.example.wph_shoping_provider.entity.WphBrand;
import com.example.wph_shoping_provider.entity.WphSmalltypeandbrand;
import com.example.wph_shoping_provider.service.WphBrandService;
import com.example.wph_shoping_provider.util.DaoUtil;
import com.google.gson.annotations.JsonAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WphBrandServiceImpl implements WphBrandService {

    @Autowired
    private WphSmalltypeandbrandDao wphSmalltypeandbrandDao;
    @Autowired
    private WphBrandDao wphBrandDao;
    DaoUtil daoUtil;

    @Override
    public String selectBrandAll(Integer wphBrandId) {
        WphBrand wphBrand=new WphBrand();
        wphBrand.setBrandType(1);
        return null;
    }

    @Override
    public String selectTypeBrandAll(Integer typeId) {
        List<WphBrand> brands=null;
        WphSmalltypeandbrand wphSmalltypeandbrand=new WphSmalltypeandbrand();
        wphSmalltypeandbrand.setSandbAmalltypeid(typeId);
        List<WphSmalltypeandbrand> wphSmalltypeandbrandList = wphSmalltypeandbrandDao.queryAll(wphSmalltypeandbrand);
        for (WphSmalltypeandbrand w:wphSmalltypeandbrandList){
            brands.add(wphBrandDao.queryById(w.getSandbBrandid()));
        }
        return JSON.toJSONString(brands);
    }

    @Override
    public String updateBrand(WphBrand wphBrand) {
        if(wphBrand.getBrandName()!=null){
            int update = wphBrandDao.update(wphBrand);
           return daoUtil.updata(update);
        }

        return "品牌名不能为空";
    }

    @Override
    public String insertBrand(WphBrand wphBrand) {
        if (wphBrand!=null){
            int insert = wphBrandDao.insert(wphBrand);
            return daoUtil.insert(insert);
        }
        return "品牌不能为空";
    }
}
