package com.example.wph_shopcar_consumer.service;

import com.example.wph_shopcar_consumer.service.Impl.CouponsServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//,fallback = CouponsServiceImpl.class
@FeignClient(name = "wph-tickets-provider",fallback = CouponsServiceImpl.class)
public interface CouponsService {
    //根据金额查看用户所拥有的优惠券
    @RequestMapping("getAllCouponsById")
    String getAllCouponsById(@RequestParam("cauuid") Integer cauuid, @RequestParam("ctype") Integer ctype);
    //通过快递公司名和订单编号查询订单轨迹
    @RequestMapping("/selectTraces")
    public String selectTraces(@RequestParam("shippercode")String shippercode,@RequestParam("logisticcode") String logisticcode) throws Exception;
}
