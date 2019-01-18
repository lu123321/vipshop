package com.example.wph_order_consumer.controller;

import com.example.wph_order_consumer.service.CouponsService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CouponsController {
    @Autowired
    private CouponsService couponsService;

    //根据金额查看用户所拥有的优惠券
    @RequestMapping("/getAllCouponsById")
    @ResponseBody
    public String getAllCouponsById(@RequestParam("ctype")double ctype, HttpServletRequest request){
        String cauuid=request.getHeader("userid");
        return couponsService.getAllCouponsById(Integer.parseInt(cauuid),ctype);
    }
    //通过快递公司名和订单编号查询订单轨迹
    @RequestMapping("/selectTraces")
    @ResponseBody
    public String selectTraces( String shippercode, String logisticcode) throws Exception{
        return couponsService.selectTraces(shippercode,logisticcode);
    }
    //新增物流单号
    @RequestMapping("/insertLog")
    @ResponseBody
    public String insertLog( String shippercode, String logisticcode){
        return couponsService.insertLog(shippercode, logisticcode);
    }
    //删除优惠券id和用户id
    @RequestMapping("deleteCopAndUser")
    @ResponseBody
    public String deleteCopAndUser(@RequestParam("caucid") Integer caucid,@RequestParam("cauuid")Integer cauuid){
        return couponsService.deleteCopAndUser(caucid, cauuid);
    }
}
