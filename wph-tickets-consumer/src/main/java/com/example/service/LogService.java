package com.example.service;

import com.example.service.impl.LogFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "wph-tickets-provider",fallback = LogFallback.class)
public interface LogService {

    //通过快递公司名和订单编号查询订单轨迹
    @RequestMapping("/selectTraces")
    public String selectTraces(@RequestParam("shippercode") String shippercode,
                               @RequestParam("logisticcode")String logisticcode) throws Exception;

    //修改订单状态
    @RequestMapping("/updateStates")
    public String updateStates(@RequestParam("logisticcode") String logisticcode,
                               @RequestParam("state") String state);


    //新增物流单号
    @RequestMapping("/insertLog")
    public String insertLog(@RequestParam("shippercode") String shippercode,
                            @RequestParam("logisticcode") String logisticcode);

    //在自己本数据库通过订单号查询
    @RequestMapping("getByLogisticcode")
    public String  getByLogisticcode(@RequestParam("logisticcode") String logisticcode);


}
