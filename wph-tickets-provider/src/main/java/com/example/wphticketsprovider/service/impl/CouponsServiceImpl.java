package com.example.wphticketsprovider.service.impl;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.alibaba.fastjson.JSON;
import com.example.wphticketsprovider.dao.CadDao;
import com.example.wphticketsprovider.dao.CouponsDao;
import com.example.wphticketsprovider.entity.Coupons;
import com.example.wphticketsprovider.entity.Couponsandusers;
import com.example.wphticketsprovider.service.CouponsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CouponsServiceImpl implements CouponsService {

    @Autowired
    private CouponsDao couponsDao;

    @Autowired
    private CadDao cadDao;

    //商家查看所有的优惠券
    @Override
    public List<Coupons> getAll() {
        List<Coupons> all = couponsDao.getAll();
        return all;
    }

    //通过优惠券id查看具体的优惠金额
    @Override
    public Coupons getMoneyById(Integer cid) {
        Coupons moneyById = couponsDao.getMoneyById(cid);
        return moneyById;
    }

    //商家增加优惠券种类
    @Override
    public String insertCoupons(Coupons coupons) {
        Coupons one = couponsDao.getOne(coupons.getCtype());
        String s ="";
        if (one == null){
            int i = couponsDao.insertCoupons(coupons);
            if (i >0){
                return  s ="添加成功";
            }else {
                return  s = "添加失败";
            }
        }else {
            return  s ="此优惠券已存在";
        }
    }

    //商家删除优惠券
    @Override
    public String deleteCoupons(Integer cid) {
        //连表删除
        List<Couponsandusers> list = cadDao.getList(cid);
        if (list.size()>0){
            int i = cadDao.deleList(cid);
            int i1 = couponsDao.deleteCoupons(cid);
            if (i >0&&  i1>0){
                return "删除成功";
            }else {
                return "删除失败";
            }
        }else{
            int i = couponsDao.deleteCoupons(cid);
            if (i >0){
                return "删除成功";
            }else {
                return "删除失败";
            }
        }


    }

    //商家修改优惠券
    @Override
    public String updateCoupons(Coupons coupons) {
        int i = couponsDao.updateCoupons(coupons);
        if (i >0){
            return  "修改成功";
        }else {
            return  "修改失败";
        }
    }

    //后台商家批量删除优惠券
    @Override
    public String deleteByCids(String str) {
        //前台传来多个id，以逗号隔开。这里把逗号去掉
        String[] s = str.split(",");
        Integer num = null;
        for (int i = 0; i < s.length; i++){
            //把所有的字符id转换成数字，才能运算
            Integer inte = Integer.valueOf(s[i]);
            System.out.println(inte+"inte");
            int j = couponsDao.deleteCoupons(inte);
            //反过来想，只要有一个没有删除成功，就跳出
            if (j == 0){
                //给num赋值
                num = 0;
                break;
            }else {
                num = 1;
            }
        }


        if ( num ==1){
            return "删除成功";
        }else {
            return "删除失败";
        }



    }

    //商家查询所有的优惠券  返回page对象
    @Override
    public PageInfo getAllCou(Integer index, Integer pageSize) {
        PageHelper.startPage(index,pageSize);
        List<Coupons> all = couponsDao.getAll();
        PageInfo p = new PageInfo(all);
        return p;
    }

    //商家后台模糊查询
    @Override
    public String fuzzySearch(String cname) {
        List<Coupons> couponsList = couponsDao.fuzzySearch(cname);
        if (couponsList.size() >0){
            return JSON.toJSONString(couponsList);
        }else {
            return JSON.toJSONString("没有查到");
        }

    }


}
