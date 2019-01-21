package com.example.wphticketsprovider.service;


import com.example.wphticketsprovider.entity.Couponsandusers;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CadService {

    //根据金额查看用户可用的优惠券
    String getAllCouponsById(Integer cauuid, Integer ctype);

    //增加优惠券id和用户id
    String insertCopAndUser( Integer caucid, Integer cauuid);

    //删除优惠券id和用户id
    String deleteCopAndUser( Integer caucid, Integer cauuid);

    //用户通过自己的id查看自己拥有的优惠券
    String getClistById( Integer cauuid);
}
