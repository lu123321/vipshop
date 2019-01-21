package com.example.wphticketsprovider.service.impl;

import com.alibaba.fastjson.JSON;

import com.example.wphticketsprovider.dao.CadDao;
import com.example.wphticketsprovider.dao.CouponsDao;
import com.example.wphticketsprovider.entity.Coupons;
import com.example.wphticketsprovider.entity.Couponsandusers;
import com.example.wphticketsprovider.service.CadService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里写了一个for循环和foreach循环都可以用。
 *
 */
@Service
public class CadServiceImpl implements CadService {

    @Autowired
    private CadDao cadDao;
    @Autowired
    private CouponsDao couponsDao;


    //根据金额查看用户可用的优惠券
    @Override
    public String getAllCouponsById(Integer cauuid,Integer ctype) {
        //获得一个优惠券集合
        List<Couponsandusers> allCouponsById = cadDao.getAllCouponsById(cauuid);
        //注意这里写size，不要直接写==null
        if (allCouponsById.size() >0) {
            //看优惠券集合长度
//            System.out.println(allCouponsById.size());
            //新建一个集合（注意不要把这个集合放到for循环中)
            List<Coupons> nnList = new ArrayList<>();

            //循环把获得的id赋值到方法中查询具体的优惠券
            for (int i = 0; i < allCouponsById.size(); i++) {
                //查看优惠券id的方法
                System.out.println(allCouponsById.get(i).getCaucid() + "优惠券");
                //把优惠券id找个变量接收（符合jvm的原理）
                Integer caucid = allCouponsById.get(i).getCaucid();
                //通过优惠券id和消费金额查询可用优惠券
                //这个金额需要调用别人接口去获取
                Coupons couponsById = couponsDao.getCouponsBy(caucid, ctype);
                //获得的优惠券不只一个，把它放到集合中
                //查到对象的时候再往集合里面填，查不到，不要填。
                if (couponsById != null) {
                    nnList.add(couponsById);
                }
                System.out.println(nnList.size() + "集合长度");
                //判断到最后一位的时候返回，不能直接返回，直接返回只能获得一个对象
                if (i == allCouponsById.size() - 1) {
                    if (nnList.size() >0){
                        return JSON.toJSONString(nnList);
                    }else {
                        return JSON.toJSONString("没有可用优惠券");
                    }

                }
            }

//            for (Couponsandusers s :allCouponsById){
//                Integer caucid = s.getCaucid();
//                Coupons couponsBy = couponsDao.getCouponsBy(caucid, ctype);
//                if (couponsBy != null){
//                    nnList.add(couponsBy);
//                }
//
//            }
//
//            return JSON.toJSONString(nnList);

        }else{
            return JSON.toJSONString("没有可用优惠券");
        }
        return  JSON.toJSONString("没有可用优惠券");
    }







    //增加优惠券id和用户id  领取优惠券
    @Override
    public String insertCopAndUser(Integer caucid, Integer cauuid) {
        //通过优惠券Id和用户id查看有没有优惠券
        Couponsandusers oneCouponsBy = cadDao.getOneCouponsBy(caucid, cauuid);
        //看看这个类型的优惠券还有没有
        Coupons moneyById = couponsDao.getMoneyById(caucid);
        Integer c1 = moneyById.getC1();
        if (oneCouponsBy == null &&c1 >0){
            //插入用户 领取成功
            cadDao.insertCopAndUser(caucid,cauuid);
            //总优惠券数量减1
            couponsDao.updateCouponC1(caucid);
            return JSON.toJSONString("领取成功");
        }else if (c1 ==0){
            return JSON.toJSONString("该优惠券已领完，请领其它优惠券");
        }else {
            return JSON.toJSONString("你已经领取过");
        }
    }

    //删除优惠券id和用户id
    @Override
    public String deleteCopAndUser(Integer caucid, Integer cauuid) {
        int i = cadDao.deleteCopAndUser(caucid, cauuid);
        if (i > 0){
            return JSON.toJSONString("优惠券使用成功");
        }
        return JSON.toJSONString("优惠券使用失败");

    }


    //用户通过自己的id查看自己拥有的优惠券
    @Override
    public String getClistById(Integer cauuid) {
        //获得一个优惠券集合
        List<Couponsandusers> clistById = cadDao.getClistById(cauuid);
        //如果能查到
        if (clistById.size() >0){
            List<Coupons> couponsList = new ArrayList<>();
            for (Couponsandusers c:clistById){
                Integer caucid = c.getCaucid();
                Coupons moneyById = couponsDao.getMoneyById(caucid);
                couponsList.add(moneyById);
            }
            return JSON.toJSONString(couponsList);
        }else {
            return  JSON.toJSONString("您暂时没有优惠券哦，去别的地方逛逛");
        }

    }


}
