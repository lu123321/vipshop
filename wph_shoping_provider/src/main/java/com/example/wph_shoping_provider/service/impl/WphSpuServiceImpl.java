package com.example.wph_shoping_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_shoping_provider.dao.WphBrandDao;
import com.example.wph_shoping_provider.dao.WphShopingpictureDao;
import com.example.wph_shoping_provider.dao.WphSpuDao;
import com.example.wph_shoping_provider.entity.WphBrand;
import com.example.wph_shoping_provider.entity.WphShopingpicture;
import com.example.wph_shoping_provider.entity.WphSpu;
import com.example.wph_shoping_provider.service.WphSpuService;
import com.example.wph_shoping_provider.util.DaoUtil;
import com.example.wph_shoping_provider.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import groovy.util.IFileNameFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WphSpuServiceImpl implements WphSpuService {
    @Autowired
    private WphSpuDao wphSpuDao;
    @Autowired
    private WphBrandDao wphBrandDao;
    @Autowired
    private WphShopingpictureDao wphShopingpictureDao;

    DaoUtil daoUtil;

    @Override
    public String wphselectSpuShow(Integer spuid) {
        WphSpu wphSpu = wphSpuDao.queryById(spuid);
        if (wphSpu != null) {
            List<String> list = new ArrayList();
            WphBrand wphBrand = wphBrandDao.queryById(wphSpu.getSpuBrandid());
            list.add(wphBrand.getBrandName());
            list.add(wphSpu.getSpuName());
            list.add(wphSpu.getSpuDetails());
            list.add("" + wphSpu.getSpuListmoney());
            list.add(DateUtil.DchangeS(wphSpu.getSpuAddtime()));
            return JSON.toJSONString(list);
        }
        return null;
    }


    @Override
    public String wphselectSpuAll(Integer smalltypeId, Integer pageNum, Integer pageSize) {
        List<String> image=new ArrayList<>();
        WphSpu wphSpu = new WphSpu();
        wphSpu.setSpuSmalltypeId(smalltypeId);
        wphSpu.setSpuType(1);
        PageHelper.startPage(pageNum, pageSize);
        List<WphSpu> wphSpuList = wphSpuDao.queryAll(wphSpu);
        for (WphSpu wphSpu1:wphSpuList){
            WphShopingpicture wphShopingpicture = wphShopingpictureDao.queryById(Integer.parseInt(wphSpu1.getSpu_1()));
            image.add(wphShopingpicture.getPictureAddress());
        }
        List<Object> wphAll=new ArrayList<>();
        wphAll.add(wphSpuList);
        wphAll.add(image);
        return JSON.toJSONString(wphAll);
    }

    @Override
    public String wphBranSpu(Integer BranId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        WphSpu wphSpu = new WphSpu();
        wphSpu.setSpuBrandid(BranId);
        wphSpu.setSpuType(1);
        List<WphSpu> wphSpuList = wphSpuDao.queryAll(wphSpu);
        if (!wphSpuList.isEmpty()) {
            PageInfo<WphSpu> pageInfo = new PageInfo<>(wphSpuList);
            return JSON.toJSONString(pageInfo);
        }
        return JSON.toJSONString(wphSpuList);
    }


    @Override
    public String insertSpu(WphSpu wphSpu) {
        if (wphSpu != null) {
            int insert = wphSpuDao.insert(wphSpu);
            return daoUtil.insert(insert);
        }
        return "产品名字不能为空";
    }

    @Override
    public String wphUpdataSpuShow(WphSpu wphSpu) {
        if (wphSpu != null) {
            int update = wphSpuDao.update(wphSpu);
            return daoUtil.updata(update);
        }
        return "产品名字不能为空";
    }

    @Override
    public String ASCspu(String id, String brandid) {
        try {
            List<WphSpu> wphSpuList = wphSpuDao.ASC(paixu(id, brandid));
            return JSON.toJSONString(wphSpuList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return JSON.toJSONString("输入有误");
        }
    }

    @Override
    public String DESCspu(String id, String brandid) {
        try {
            List<WphSpu> wphSpuList = wphSpuDao.DESC(paixu(id, brandid));
            return JSON.toJSONString(wphSpuList);
        } catch (Exception e) {
            return JSON.toJSONString("输入有误");
        }
    }

    private WphSpu paixu(String id, String brandid) {
        WphSpu wphSpu = new WphSpu();
        if (id != null && id != "") {
            int i = Integer.parseInt(id);
            wphSpu.setSpuSmalltypeId(i);
        }
        if (brandid != null && brandid != "") {
            int i = Integer.parseInt(brandid);
            wphSpu.setSpuBrandid(i);
        }
        wphSpu.setSpuType(1);
        return wphSpu;
    }
}
