package com.example.wph_order_consumer.service.Impl;

import com.example.wph_order_consumer.service.PayService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class PayServiceImpl implements PayService {
    @Override
    public String pay(String WIDout_trade_no, String WIDtotal_amount, String WIDsubject, String WIDbody) {
        return "支付失败";
    }
}
