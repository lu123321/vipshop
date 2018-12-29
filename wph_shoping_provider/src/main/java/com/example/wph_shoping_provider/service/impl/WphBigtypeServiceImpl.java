package com.example.wph_shoping_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_shoping_provider.dao.WphBigtypeDao;
import com.example.wph_shoping_provider.entity.WphBigtype;
import com.example.wph_shoping_provider.service.WphBigtypeService;
import com.example.wph_shoping_provider.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WphBigtypeServiceImpl implements WphBigtypeService {
    @Autowired
    private WphBigtypeDao wphBigtypeDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String selectBigtype() {
        Object bigtype = redisUtil.get("bigtype");
        if (redisUtil.get("bigtype") == null) {
            WphBigtype wphBigtype = new WphBigtype();
            wphBigtype.setBigtypeType(1);
            List<WphBigtype> wphBigtypes = wphBigtypeDao.queryAll(wphBigtype);
            redisUtil.set("bigtype", wphBigtypes);
        } 
        return JSON.toJSONString(redisUtil.get("bigtype"));
    }

    @Override
    public String insetBigtype(WphBigtype wphBigtype) {
        if (wphBigtype.getBigtypeName() != null && !wphBigtype.getBigtypeName().equals("")) {
           wphBigtype.setBigtypeType(1);
            int insert = wphBigtypeDao.insert(wphBigtype);
            if (insert>0){
                return "添加成功";
            }
            return "添加失败";
        }
        return "类型名不能为空";
    }

    @Override
    public String delBigtype(Integer bigTypeId) {
        if(bigTypeId!=null) {
            int i = wphBigtypeDao.deleteById(bigTypeId);
            if (i>0){
                return "删除成功";
            }
            return "删除失败";
        }
        return "类型不能为空";
    }


}
