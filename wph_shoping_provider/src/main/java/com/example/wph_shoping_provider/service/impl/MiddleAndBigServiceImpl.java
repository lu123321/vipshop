package com.example.wph_shoping_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.wph_shoping_provider.dao.WphBigtypeDao;
import com.example.wph_shoping_provider.dao.WphMiddletypeDao;
import com.example.wph_shoping_provider.dao.WphSmalltypeDao;
import com.example.wph_shoping_provider.entity.WphBigtype;
import com.example.wph_shoping_provider.entity.WphMiddletype;
import com.example.wph_shoping_provider.entity.WphSmalltype;
import com.example.wph_shoping_provider.service.MiddleAndBigService;
import com.example.wph_shoping_provider.utilentity.MiddleAndBig;
import com.example.wph_shoping_provider.utilentity.SmallAndMiddle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MiddleAndBigServiceImpl implements MiddleAndBigService {
    @Autowired
    WphBigtypeServiceImpl wphBigtypeService;

    @Autowired
    private WphBigtypeDao wphBigtypeDao;
    @Autowired
    private WphMiddletypeDao wphMiddletypeDao;
    @Autowired
    private WphSmalltypeDao wphSmalltypeDao;

    @Override
    public String type() {
        List<MiddleAndBig> middleAndBigs=new ArrayList<>();
        WphBigtype wphBigtype = new WphBigtype();
        wphBigtype.setBigtypeType(1);
        System.out.println(wphBigtype.getBigtypeName());
        List<WphBigtype> wphBigtypes = wphBigtypeDao.queryAll(wphBigtype);
        /*String s = wphBigtypeService.selectBigtype();
        List<WphBigtype> wphBigtypes = JSON.parseArray(s, WphBigtype.class);*/
        System.out.println(wphBigtypes.size());
        for (WphBigtype Bigtype:wphBigtypes){
            MiddleAndBig middleAndBig=new MiddleAndBig();
            WphMiddletype wphMiddletype=new WphMiddletype();
            wphMiddletype.setMiddletypeBigtyprid(Bigtype.getBigtypeId());
            wphMiddletype.setMiddletypeType(1);
            middleAndBig.setBigTypeId(Bigtype.getBigtypeId());
            List<WphMiddletype> middletypeList = wphMiddletypeDao.queryAll(wphMiddletype);
            List<WphMiddletype> middletypes=new ArrayList<WphMiddletype>();
            for(WphMiddletype middletype:middletypeList){
                WphSmalltype wphSmalltype=new WphSmalltype();
                wphSmalltype.setSmalltypeMiddletypeid(middletype.getMiddletypeId());
                wphSmalltype.setSmalltypeType(1);
                List<WphSmalltype> wphSmalltypes = wphSmalltypeDao.queryAll(wphSmalltype);
                middletype.setSmallAndMiddles(wphSmalltypes);
                middletypes.add(middletype);
            }
            middleAndBig.setMiddletypes(middletypes);
            middleAndBigs.add(middleAndBig);
        }
        return JSON.toJSONString(middleAndBigs);
    }
}
