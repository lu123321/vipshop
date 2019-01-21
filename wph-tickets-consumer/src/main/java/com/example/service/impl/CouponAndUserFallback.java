package com.example.service.impl;


import com.alibaba.fastjson.JSON;
import com.example.service.CouponAndUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class CouponAndUserFallback implements CouponAndUserService {
    @Override
    public String getAllCouponsById(@RequestParam("cauuid") Integer cauuid,
                                    @RequestParam("ctype")double ctype) {
        return JSON.toJSONString("服务不在线");
    }

    //增加优惠券id和用户id
    public String insertCopAndUser(@RequestParam("caucid")Integer caucid,
                                   @RequestParam("cauuid")Integer cauuid){
        return JSON.toJSONString("服务不在线");
    }

    //删除优惠券id和用户id
    public String deleteCopAndUser(@RequestParam("caucid")Integer caucid,
                                   @RequestParam("cauuid")Integer cauuid){
        return JSON.toJSONString("服务不在线");
    }

    //用户通过自己的id查看自己拥有的优惠券
    @Override
    public String getClistById(Integer cauuid) {
        return null;
    }
}
