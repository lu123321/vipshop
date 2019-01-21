package com.example.controller;

import com.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    //通过快递公司名和订单编号查询物流轨迹
    @RequestMapping("/selectTraces")
    public String selectTraces(String shippercode, String logisticcode) throws Exception{
        return logService.selectTraces(shippercode,logisticcode);
    }


    //修改物流状态
    @RequestMapping("/updateStates")
    public String updateStates( String logisticcode, String state){
        return logService.updateStates(logisticcode,state);
    }


    //新增物流单号
    @RequestMapping("/insertLog")
    public String insertLog( String shippercode, String logisticcode){
        return logService.insertLog(shippercode,logisticcode);
    }

    //在自己本数据库通过订单号查询
    @RequestMapping("getByLogisticcode")
    public String  getByLogisticcode( String logisticcode, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return logService.getByLogisticcode(logisticcode);
    }
}
