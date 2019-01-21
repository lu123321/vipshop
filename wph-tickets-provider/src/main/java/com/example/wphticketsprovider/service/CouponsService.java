package com.example.wphticketsprovider.service;

import com.example.wphticketsprovider.entity.Coupons;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface CouponsService {

    //商家查看所有的优惠券
    List<Coupons> getAll();

    //通过优惠券id查看具体的优惠金额
    Coupons getMoneyById(Integer cid);

    //商家增加优惠券种类
    String insertCoupons(Coupons coupons);

    //商家删除优惠券
    String  deleteCoupons( Integer cid);

    //商家修改优惠券
    String  updateCoupons(Coupons coupons);

    //后台商家批量删除优惠券
    String deleteByCids(String str);

    //后台商家查询所有的优惠券  返回page的对象
    PageInfo getAllCou(Integer index,Integer pageSize);

    //商家后台模糊查询
    String fuzzySearch( String  cname);

}
