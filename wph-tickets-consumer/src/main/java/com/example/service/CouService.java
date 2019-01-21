package com.example.service;

import com.example.entity.Coupons;
import com.example.service.impl.CouFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//,fallback = CouFallback.class
@FeignClient(value = "wph-tickets-provider")
public interface CouService {


    //通过优惠券id查看具体的优惠金额
    @RequestMapping("getMoneyById")
    public String getMoneyById(@RequestParam("cid") Integer cid);


    //通过优惠券id查看一条优惠券的信息
    @RequestMapping("getOne")
    public String getOne(@RequestParam("cid") Integer cid);

    //商家查看所有的优惠券
    @RequestMapping("getAll")
    public String  getAll();

    //商家增加优惠券种类
    @RequestMapping("insertCoupons")
    public String insertCoupons(@RequestBody Coupons coupons);

    //商家删除优惠券
    @RequestMapping("deleteCoupons")
    public String deleteCoupons(@RequestParam("cid") Integer cid);

    //商家修改优惠券
    @RequestMapping("updateCoupons")
    public String updateCoupons(@RequestBody Coupons coupons);

    //后台商家批量删除优惠券
    @RequestMapping("deleteByCids")
    public String deleteByCids(@RequestParam("str") String str);

    //商家查询所有的优惠券  返回page对象
    @RequestMapping("getAllCou")
    public String  getAllCou(@RequestParam("index") Integer index,
                             @RequestParam("pageSize") Integer pageSize);

    //商家后台模糊查询
    @RequestMapping("fuzzySearch")
    public String fuzzySearch(@RequestParam("cname") String cname);
}
