package com.example.wphticketsprovider.controller;

import com.alibaba.fastjson.JSON;
import com.example.wphticketsprovider.entity.Coupons;
import com.example.wphticketsprovider.service.CouponsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouponsController {
    @Autowired
    private CouponsService couponsService;

    //通过优惠券id查看具体的优惠金额
   @RequestMapping("getMoneyById")
    public String getMoneyById(Integer cid){
       Double money = couponsService.getMoneyById(cid).getMoney();
       return  JSON.toJSONString(money);
    }


    //通过优惠券id查看一条优惠券的信息
    @RequestMapping("getOne")
    public String getOne(Integer cid){
        Coupons moneyById = couponsService.getMoneyById(cid);
        return JSON.toJSONString(moneyById);

    }



    //商家查看所有的优惠券
    @RequestMapping("getAll")
    public String getAll(){
        List<Coupons> all = couponsService.getAll();
        return JSON.toJSONString(all);
    }

    //商家增加优惠券种类
    @RequestMapping("insertCoupons")
    public String insertCoupons(@RequestBody Coupons coupons){
        String s = couponsService.insertCoupons(coupons);
        return JSON.toJSONString(s);
    }

    //商家删除优惠券
    @RequestMapping("deleteCoupons")
    public String deleteCoupons( Integer cid){
        String s = couponsService.deleteCoupons(cid);
        return JSON.toJSONString(s);
    }

    //商家修改优惠券
    @RequestMapping("updateCoupons")
    public String updateCoupons(@RequestBody Coupons coupons){
        System.out.println(coupons.getCtype()+"ctype");
        String s = couponsService.updateCoupons(coupons);
        return JSON.toJSONString(s);
    }

    //后台商家批量删除优惠券
    @RequestMapping("deleteByCids")
    public String deleteByCids(String str){
        String s = couponsService.deleteByCids(str);
        return JSON.toJSONString(s);
    }

    //商家查询所有的优惠券  返回page对象
    @RequestMapping("getAllCou")
    public String  getAllCou(Integer index, Integer pageSize){
        PageInfo allCou = couponsService.getAllCou(index, pageSize);
        return JSON.toJSONString(allCou);
    }

    //商家后台模糊查询
    @RequestMapping("fuzzySearch")
    public String fuzzySearch(String cname){
        String s = couponsService.fuzzySearch(cname);
        return s;
    }
}
