package com.example.wphticketsprovider.controller;


import com.example.wphticketsprovider.service.CadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadController {

    @Autowired
    private CadService cadService;

    //根据金额和用户id查看用户所拥有的优惠券
    @RequestMapping("getAllCouponsById")
    public String getAllCouponsById( Integer cauuid, double ctype){
        int ctype1 = (int)ctype;
        return cadService.getAllCouponsById(cauuid,ctype1);
    }

    //增加优惠券id和用户id  领取优惠券
    @RequestMapping("insertCopAndUser")
    public String insertCopAndUser(@RequestParam("caucid") Integer caucid,
                                   @RequestParam("cauuid")Integer cauuid){
        return cadService.insertCopAndUser(caucid,cauuid);
    }

    //删除优惠券id和用户id
    @RequestMapping("deleteCopAndUser")
    public String deleteCopAndUser(@RequestParam("caucid") Integer caucid,
                                   @RequestParam("cauuid")Integer cauuid){
        return cadService.deleteCopAndUser(caucid,cauuid);
    }

    //用户通过自己的id查看自己拥有的优惠券
    @RequestMapping("getClistById")
    public String getClistById(Integer cauuid){
        return cadService.getClistById(cauuid);
    }

}
