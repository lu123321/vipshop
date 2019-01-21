package com.example.wphticketsprovider.dao;


import com.example.wphticketsprovider.entity.Coupons;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CouponsDao {

    //查询优惠券
    @Select("select * from coupons where cid = #{cid} and ctype <= #{ctype}")
    Coupons getCouponsBy(@Param("cid") Integer cid, @Param("ctype") Integer ctype);


    //根据优惠券id和金额特定查找优惠券
    @Select("select * from coupons where cid = #{cid} and ctype = #{ctype}")
    Coupons getCobponByCtyp(@Param("cid") Integer cid, @Param("ctype") Integer ctype);


    //通过优惠券id查看所有
    @Select("select cname,ctype,money,c1 from coupons where cid = #{cid}")
    Coupons getMoneyById(Integer cid);


    //更改优惠券的数量
    @Update("update coupons set c1 =c1-1 where cid =#{cid}")
    int updateCouponC1(Integer cid);

    //商家增加优惠券种类
    @Insert("insert into coupons (cname,ctype,money,c1) VALUES (#{coupons.cname},#{coupons.ctype},#{coupons.money},#{coupons.c1}) ")
    int insertCoupons(@Param("coupons") Coupons coupons);

    //查询优惠券通过消费金额
    @Select("select * from coupons where ctype =  #{ctype}")
    Coupons getOne(@Param("ctype") Integer ctype);

    //商家删除优惠券
    @Delete("delete from coupons   where cid = #{cid}")
    int deleteCoupons(@Param("cid") Integer cid);

    //商家修改优惠券
    int updateCoupons(Coupons coupons);


    //商家查看所有的优惠券
    @Select("select * from coupons")
    List<Coupons> getAll();

    //商家后台模糊查询
    @Select("select * from coupons where cname like CONCAT('%',#{cname},'%')")
    List<Coupons> fuzzySearch(@Param("cname") String  cname);

}
