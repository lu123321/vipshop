package com.example.wph_order_consumer.service.Impl;

import com.example.wph_order_consumer.service.CouponsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class CouponsServiceImpl implements CouponsService {
    @Override
    public String getAllCouponsById(Integer cauuid,double ctype) {
        return "查询优惠券异常";
    }

    //通过快递公司名和订单编号查询订单轨迹
    @RequestMapping("/selectTraces")
    public String selectTraces(String shippercode, String logisticcode) throws Exception{
        return "查询物流异常";
    }

    @Override
    public String insertLog(String shippercode, String logisticcode) {
        return "新增物流异常";
    }

    @Override
    public String deleteCopAndUser(Integer caucid, Integer cauuid) {
        return "删除优惠券异常";
    }
}
