package com.example.wph_shopcar_consumer.controller;

import com.example.wph_shopcar_consumer.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CouponsController {
    @Autowired
    private CouponsService couponsService;

    //根据金额查看用户所拥有的优惠券
    @RequestMapping("/getAllCouponsById")
    @ResponseBody
    public String getAllCouponsById(@RequestParam("cauuid") Integer cauuid, @RequestParam("ctype")Integer ctype){
        return couponsService.getAllCouponsById(cauuid,ctype);
    }
    //通过快递公司名和订单编号查询订单轨迹
    @RequestMapping("/selectTraces")
    @ResponseBody
    public String selectTraces(String shippercode, String logisticcode) throws Exception{
        return couponsService.selectTraces(shippercode,logisticcode);
    }
}
