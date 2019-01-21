package com.example.controller;

import com.example.entity.Coupons;
import com.example.service.CouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouController {
    @Autowired
    private CouService couService;

    //通过优惠券id查看具体的优惠金额
    @RequestMapping("getMoneyById")
    public String getMoneyById( Integer cid){
        return couService.getMoneyById(cid);
    }

    //通过优惠券id查看一条优惠券的信息
    @RequestMapping("getOne")
    public String getOne( Integer cid){
        return couService.getOne(cid);
    }

    //商家查看所有的优惠券
    @RequestMapping("getAll")
    public String  getAll(){
        return couService.getAll();
    }

    //商家增加优惠券种类
    @RequestMapping("insertCoupons")
    public String insertCoupons(@RequestBody Coupons coupons){
        System.out.println("优惠券名" + coupons.getCname());
        return couService.insertCoupons(coupons);
    }

    //商家删除优惠券
    @RequestMapping("deleteCoupons")
    public String deleteCoupons( Integer cid){
        return couService.deleteCoupons(cid);
    }

    //商家修改优惠券
    @RequestMapping("updateCoupons")
    public String updateCoupons(@RequestBody Coupons coupons){
        System.out.println("修改" + coupons.getCname());
        return couService.updateCoupons(coupons);
    }

    //后台商家批量删除优惠券
    @RequestMapping("deleteByCids")
    public String deleteByCids(String str){
        return couService.deleteByCids(str);
    }

    //商家查询所有的优惠券  返回page对象
    @RequestMapping("getAllCou")
    public String  getAllCou( Integer index, Integer pageSize){
        return couService.getAllCou(index, pageSize);
    }

    //商家后台模糊查询
    @RequestMapping("fuzzySearch")
    public String fuzzySearch(@RequestParam("cname") String cname){
        return couService.fuzzySearch(cname);
    }
}
