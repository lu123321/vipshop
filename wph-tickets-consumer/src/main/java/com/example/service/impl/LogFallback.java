package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.service.LogService;
import org.springframework.stereotype.Component;

@Component
public class LogFallback  implements LogService {


    //通过快递公司名和订单编号查询物流轨迹
    @Override
    public String selectTraces(String shippercode, String logisticcode) throws Exception {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //修改订单状态
    @Override
    public String updateStates(String logisticcode, String state) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //新增物流单号
    @Override
    public String insertLog(String shippercode, String logisticcode) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //在自己本数据库通过订单号查询
    @Override
    public String getByLogisticcode(String logisticcode) {
        return JSON.toJSONString("服务出错，请稍后");
    }
}
