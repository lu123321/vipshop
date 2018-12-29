package com.example.wph_shoping_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_shoping_provider.dao.WphSmalltypeDao;
import com.example.wph_shoping_provider.entity.WphSmalltype;
import com.example.wph_shoping_provider.service.WphSmalltypeService;
import com.example.wph_shoping_provider.util.DaoUtil;
import com.example.wph_shoping_provider.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WphSmalltypeServiceImpl implements WphSmalltypeService {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private WphSmalltypeDao wphSmalltypeDao;
    DaoUtil daoUtil;
    @Override
    public String selectSmalltypr(Integer middletypeid) {
        if (redisUtil.get("smalltype"+middletypeid)==null){
            WphSmalltype wphSmalltype=new WphSmalltype();
            wphSmalltype.setSmalltypeType(1);
            wphSmalltype.setSmalltypeMiddletypeid(middletypeid);
            List<WphSmalltype> wphSmalltypeList = wphSmalltypeDao.queryAll(wphSmalltype);
            redisUtil.set("smalltype"+middletypeid,wphSmalltypeList);
        }
        return JSON.toJSONString(redisUtil.get("smalltype"+middletypeid));
    }

    @Override
    public String insertSmalltype(WphSmalltype wphSmalltype) {
        if (wphSmalltype!=null) {
            int insert = wphSmalltypeDao.insert(wphSmalltype);
            return daoUtil.insert(insert);
        }
        return "类型名不能为空";
    }

    @Override
    public String updataSmalltype(WphSmalltype wphSmalltype) {
        if (wphSmalltype!=null) {
            int insert = wphSmalltypeDao.update(wphSmalltype);
            return daoUtil.updata(insert);
        }
        return "类型名不能为空";
    }
}
