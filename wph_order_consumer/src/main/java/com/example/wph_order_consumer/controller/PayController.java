package com.example.wph_order_consumer.controller;

import com.example.wph_order_consumer.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * 支付接口
     *
     * @param WIDout_trade_no 订单编号
     * @param WIDtotal_amount 支付金额
     * @param WIDsubject      商品名称
     * @param WIDbody         商品描述
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "pay", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String pay(@RequestParam("WIDout_trade_no") String WIDout_trade_no, @RequestParam("WIDtotal_amount") String WIDtotal_amount,
                      @RequestParam("WIDsubject") String WIDsubject, @RequestParam("WIDbody") String WIDbody) {
        System.out.println("WIDout_trade_no = [" + WIDout_trade_no + "], WIDtotal_amount = [" + WIDtotal_amount + "], WIDsubject = [" + WIDsubject + "], WIDbody = [" + WIDbody + "]");
        return payService.pay(WIDout_trade_no, WIDtotal_amount, WIDsubject, WIDbody);
    }

    /**
     *
     * @param WIDTRout_trade_no   商户订单号，商户网站订单系统中唯一订单号
     * @param WIDTRtrade_no       支付宝交易号
     * @param WIDTRrefund_amount  需要退款的金额，该金额不能大于订单金额，必填
     * @param WIDTRrefund_reason  退款的原因说明
     * @param WIDTRout_request_no 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "refund",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
    public String refund(@RequestParam("WIDTRout_trade_no")String WIDTRout_trade_no, @RequestParam("WIDTRtrade_no")String WIDTRtrade_no, @RequestParam("WIDTRrefund_amount")String WIDTRrefund_amount, @RequestParam("WIDTRrefund_reason")String WIDTRrefund_reason, @RequestParam("WIDTRout_request_no") String WIDTRout_request_no, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        return payService.refund(WIDTRout_trade_no, WIDTRtrade_no, WIDTRrefund_amount, WIDTRrefund_reason, WIDTRout_request_no);
    }
}