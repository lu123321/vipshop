package com.example.wph_shoping_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.wph_shoping_provider.dao.WphBrandDao;
import com.example.wph_shoping_provider.dao.WphShopingpictureDao;
import com.example.wph_shoping_provider.dao.WphSkuDao;
import com.example.wph_shoping_provider.dao.WphSpuDao;
import com.example.wph_shoping_provider.entity.*;
import com.example.wph_shoping_provider.service.WphSkuService;
import com.example.wph_shoping_provider.util.DaoUtil;
import com.example.wph_shoping_provider.util.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WphSkuServiceImpl implements WphSkuService {
    @Autowired
    private WphBrandDao wphBrandDao;
    @Autowired
    private WphSkuDao wphSkuDao;
    @Autowired
    private WphSpuDao wphSpuDao;
    @Autowired
    private WphShopingpictureDao wphShopingpictureDao;

    DaoUtil daoUtil;
    @Override
    public String WphSeleteSku(String skuSerialnumber,Integer shopingNumber) {
        WphSku wphSku=new WphSku();
        if (skuSerialnumber != null && skuSerialnumber != "") {
            wphSku.setSkuSerialnumber(skuSerialnumber);
            wphSku.setSkuType(1);
            List<WphSku> queryAll = wphSkuDao.queryAll(wphSku);
            List<String> listnumber=new ArrayList<>();
            listnumber.add(queryAll.get(0).getSkuName());
            listnumber.add(skuSerialnumber);
            listnumber.add(""+queryAll.get(0).getSkuMoney()+"");
            WphShopingpicture wphShopingpicture = wphShopingpictureDao.queryById(queryAll.get(0).getSkuPictureid());
            listnumber.add(wphShopingpicture.getPictureAddress());
            listnumber.add(""+shopingNumber);
            WphSpu wphSpu1 = wphSpuDao.queryById(queryAll.get(0).getSkuSpuid());
            listnumber.add(""+wphSpu1.getSpuBrandid());
            listnumber.add(""+queryAll.get(0).getSkuSpuid());
            return JSON.toJSONString(listnumber);
        }
        return null;
    }

    @Override
    public String WphSelectku(String skuSerialnumber,Integer shopingNumber) {
        WphSku wphSku=new WphSku();
        if (skuSerialnumber != null && skuSerialnumber != "") {
            wphSku.setSkuSerialnumber(skuSerialnumber);
            List<WphSku> queryAll = wphSkuDao.queryAll(wphSku);
            WphSpu wphSpu1 = wphSpuDao.queryById(queryAll.get(0).getSkuSpuid());
            List<String> listnumber=new ArrayList<>();
            listnumber.add(skuSerialnumber);
            listnumber.add(""+shopingNumber);
            listnumber.add(""+wphSpu1.getSpuBrandid());
            return JSON.toJSONString(listnumber);
        }
        return null;
    }

    @Override
        public String BrandSku(String Brand,String time) {
        if (Brand!=null) {
            List<WphSku> wphSkuList;
            List<GetRepertoey> brandSku = new ArrayList<>();
            WphSpu wphSpu = new WphSpu();
            Integer brands=Integer.parseInt(Brand);
            System.out.println("-------------"+brands);
            wphSpu.setSpuBrandid(brands);
            wphSpu.setSpuType(1);
            System.out.println(wphSpu.getSpuBrandid());
            System.out.println(wphSpu.getSpuType());
            List<WphSpu> wphSpuList = wphSpuDao.queryAll(wphSpu);
            System.out.println(wphSpuList.size());
            if (wphSpuList.size()!=0) {
                for (WphSpu ww : wphSpuList) {
                    WphSku wphSku = new WphSku();
                    wphSku.setSkuSpuid(ww.getSpuId());
                    System.out.println(ww.getSpuId());
                    wphSku.setSkuType(1);
                    wphSkuList = wphSkuDao.queryAll(wphSku);
                    System.out.println(wphSkuList.size());
                    if(wphSkuList.size()>=0) {
                        for (WphSku wsku : wphSkuList) {
                            GetRepertoey getRepertoey = new GetRepertoey();
                            getRepertoey.setProductId(wsku.getSkuSerialnumber());
                            getRepertoey.setNumber(wsku.getSkuNumber());
                            brandSku.add(getRepertoey);
                            WphSku wphSku2 = new WphSku();
                            wphSku2.setSkuSerialnumber(wsku.getSkuSerialnumber());
                            wphSku2.setSkuNumber(0);
                            wphSku2.setSku_1(time);
                            wphSkuDao.update(wphSku2);
                        }
                    }else {
                        return JSON.toJSONString("无此商品");
                    }
                }
                return JSON.toJSONString(brandSku);
            }else {
                return JSON.toJSONString("无此产品");
            }
        }
        return JSON.toJSONString("品牌Id不能为空");
    }

    @Override
    public String xiajiaBrand(String Skuser) {
        try {
            List<GetRepertoey> SkuKer = JSON.parseArray(Skuser, GetRepertoey.class);
            for (GetRepertoey shop : SkuKer) {
                WphSku wphSku = new WphSku();
                wphSku.setSkuSerialnumber(shop.getProductId());
                wphSku.setSkuNumber(shop.getNumber());
                wphSku.setSkuType(2);
                int update = wphSkuDao.update(wphSku);
                System.out.println(shop.getNumber());
            }
            WphSku wphSku = new WphSku();
            wphSku.setSkuSerialnumber(SkuKer.get(0).getProductId());
            List<WphSku> wphSkus = wphSkuDao.queryAll(wphSku);
            WphSpu wphSpu = new WphSpu();
            wphSpu.setSpuId(wphSkus.get(0).getSkuSpuid());
            wphSpu.setSpuType(1);
            List<WphSpu> wphSpuList = wphSpuDao.queryAll(wphSpu);
            for (WphSpu wphSpu1 : wphSpuList) {
                WphSpu wphSpu3 = new WphSpu();
                wphSpu3.setSpuId(wphSpu1.getSpuId());
                wphSpu3.setSpuType(2);
                int update = wphSpuDao.update(wphSpu);
            }
            WphBrand wphBrand = new WphBrand();
            wphBrand.setBrandId(wphSpuList.get(0).getSpuBrandid());
            wphBrand.setBrandType(2);
            int update = wphBrandDao.update(wphBrand);
            if (update > 0) {
                return "下架成功";
            }
            return "下架失败";
        }catch (Exception e){
            System.out.println("下架异常");
            return "系统维护";
        }
    }

    @Override
    public String UpdateSku(WphSku wphSku) {
        if (wphSku!=null){
            int update = wphSkuDao.update(wphSku);
           return daoUtil.updata(update);
        }
        return "商品编码不能为空";
    }

    @Override
    public String insterSku(WphSku wphSku) {
        if (wphSku!=null) {
            int insert = wphSkuDao.insert(wphSku);
            return daoUtil.insert(insert);
        }
        return "商品编码不能为空";
    }

    @RabbitListener(queues = RabbitConfig.WPH_SPRETURN)
    private void xiaJiaShoping(String message){
        System.out.println("666666666666666666666666666666");
        WphSku wphSku=new WphSku();
        wphSku.setSkuSerialnumber(message);
        wphSku.setSkuType(0);
        wphSku.setSkuNumber(0);
        wphSkuDao.update(wphSku);
    }


    @RabbitListener(queues = RabbitConfig.XJFKC_Queue )
    private void xiajiShoping(String message){
        try {
            List<GetRepertoey> getRepertoeys=JSON.parseArray(message,GetRepertoey.class);
            for (GetRepertoey repertoey:getRepertoeys){
                WphSku wphSku=new WphSku();
                wphSku.setSkuSerialnumber(repertoey.getProductId());
                List<WphSku> wphSkus = wphSkuDao.queryAll(wphSku);
                WphSku wphSku2=new WphSku();
                wphSku2.setSkuSerialnumber(wphSkus.get(0).getSkuSerialnumber());
                wphSku2.setSkuNumber((wphSkus.get(0).getSkuNumber()+repertoey.getNumber()));
                wphSkuDao.update(wphSku2);
            }
        }catch (Exception e){
            System.out.println("出错了");
        }

    }
}
