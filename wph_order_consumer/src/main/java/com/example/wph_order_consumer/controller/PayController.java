package com.example.wph_order_consumer.controller;

import com.example.wph_order_consumer.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * 支付接口
     * @param WIDout_trade_no 订单编号
     * @param WIDtotal_amount 支付金额
     * @param WIDsubject 商品名称
     * @param WIDbody 商品描述
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "pay",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
    public String pay(@RequestParam("WIDout_trade_no") String WIDout_trade_no,@RequestParam("WIDtotal_amount") String WIDtotal_amount,
                      @RequestParam("WIDsubject") String WIDsubject,@RequestParam("WIDbody") String WIDbody) {
        System.out.println("WIDout_trade_no = [" + WIDout_trade_no + "], WIDtotal_amount = [" + WIDtotal_amount + "], WIDsubject = [" + WIDsubject + "], WIDbody = [" + WIDbody + "]");
        return payService.pay(WIDout_trade_no,WIDtotal_amount,WIDsubject,WIDbody);
    }
}
