package com.example.controller;


import com.example.service.CouponAndUserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponAndUserController {
    @Autowired
    private CouponAndUserService couponAndUserService;


    //根据金额查看用户所拥有的优惠券
    @RequestMapping("getAllCouponsById")
    public String getAllCouponsById(@RequestParam("cauuid") Integer cauuid,
                                    @RequestParam("ctype")double ctype){
        return couponAndUserService.getAllCouponsById(cauuid,ctype);
    }

    //增加优惠券id和用户id
    @RequestMapping("insertCopAndUser")
    public String insertCopAndUser(@RequestParam("caucid")Integer caucid,
                                   @RequestParam("cauuid")Integer cauuid){
        return couponAndUserService.insertCopAndUser(caucid,cauuid);
    }


    //删除优惠券id和用户id
    @RequestMapping("deleteCopAndUser")
    public String deleteCopAndUser(@RequestParam("caucid")Integer caucid,
                                   @RequestParam("cauuid") Integer cauuid){
        return couponAndUserService.deleteCopAndUser(caucid,cauuid);
    }

    //用户通过自己的id查看自己拥有的优惠券
    @RequestMapping("getClistById")
    public String getClistById(HttpServletRequest request){
        String userid = request.getHeader("userid");
        int cauuid = Integer.parseInt(userid);
        return couponAndUserService.getClistById(cauuid);
    }
}
