package com.example.wph_order_consumer.service;

import com.example.wph_order_consumer.service.Impl.PayServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@FeignClient(name = "wph-pay-provider",fallback = PayServiceImpl.class)
public interface PayService {

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
    String pay(@RequestParam("WIDout_trade_no") String WIDout_trade_no,@RequestParam("WIDtotal_amount") String WIDtotal_amount,
                      @RequestParam("WIDsubject") String WIDsubject,@RequestParam("WIDbody") String WIDbody);
}
