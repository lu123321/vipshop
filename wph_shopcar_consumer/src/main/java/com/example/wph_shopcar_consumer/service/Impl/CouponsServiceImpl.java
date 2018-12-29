package com.example.wph_shopcar_consumer.service.Impl;

import com.example.wph_shopcar_consumer.service.CouponsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CouponsServiceImpl implements CouponsService {
    @Override
    public String getAllCouponsById(Integer cauuid,Integer ctype) {
        return "系统报错";
    }

    //通过快递公司名和订单编号查询订单轨迹
    @RequestMapping("/selectTraces")
    public String selectTraces(String shippercode, String logisticcode) throws Exception{
        return "系统异常";
    }
}
