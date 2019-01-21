package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.entity.Coupons;
import com.example.service.CouService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class CouFallback implements CouService {

    //通过优惠券id查看具体的优惠金额
    @Override
    public String getMoneyById(@RequestParam("cid") Integer cid) {
        return JSON.toJSONString("服务不在线");
    }


    @Override
    public String getOne(Integer cid) {
        return JSON.toJSONString("服务不在线");
    }

    //商家查看所有的优惠券
    @Override
    public String getAll() {
        return JSON.toJSONString("服务不在线");
    }
    //商家增加优惠券种类
    @Override
    public String insertCoupons(@RequestBody Coupons coupons) {
        return JSON.toJSONString("服务不在线");
    }
    //商家删除优惠券
    @Override
    public String deleteCoupons(@RequestParam("cid") Integer cid) {
        return JSON.toJSONString("服务不在线");
    }
    //商家修改优惠券
    @Override
    public String updateCoupons(@RequestBody Coupons coupons) {
        return JSON.toJSONString("服务不在线");
    }

    //后台商家批量删除优惠券
    @Override
    public String deleteByCids(String str) {
        return JSON.toJSONString("服务不在线");
    }

    //商家查询所有的优惠券  返回page对象
    @Override
    public String getAllCou(Integer index, Integer pageSize) {
        return JSON.toJSONString("服务不在线");
    }


    @Override
    public String fuzzySearch(String cname) {
        return JSON.toJSONString("服务不在线");
    }


}
