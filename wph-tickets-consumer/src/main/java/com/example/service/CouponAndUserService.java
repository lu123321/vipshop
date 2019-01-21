package com.example.service;


import com.example.service.impl.CouponAndUserFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//,fallback = CouponAndUserFallback.class
//注意wph-tickets-provider写法，他是注册中心里面的。不要用下划线
@FeignClient(value = "wph-tickets-provider")
public interface CouponAndUserService {
    //根据金额查看用户所拥有的优惠券
    @RequestMapping("getAllCouponsById")
    public String getAllCouponsById(@RequestParam("cauuid") Integer cauuid,
                                    @RequestParam("ctype") double ctype);


    //增加优惠券id和用户id
    @RequestMapping("insertCopAndUser")
    public String insertCopAndUser(@RequestParam("caucid")Integer caucid,
                                   @RequestParam("cauuid")Integer cauuid);

    //删除优惠券id和用户id
    @RequestMapping("deleteCopAndUser")
    public String deleteCopAndUser(@RequestParam("caucid")Integer caucid,
                                   @RequestParam("cauuid") Integer cauuid);

    //用户通过自己的id查看自己拥有的优惠券
    @RequestMapping("getClistById")
    public String getClistById(@RequestParam("cauuid") Integer cauuid);
}
