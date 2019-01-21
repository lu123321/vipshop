package com.example.wphticketsprovider.controller;

import com.alibaba.fastjson.JSON;
import com.example.wphticketsprovider.entity.Logistics;
import com.example.wphticketsprovider.service.LogisticsService;
import com.example.wphticketsprovider.util.KdniaoTrackQueryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (Logistics)表控制层
 *
 * @author makejava
 * @since 2018-12-27 14:51:13
 */
@RestController
public class LogisticsController {
    /**
     * 服务对象
     */
    @Resource
    private LogisticsService logisticsService;

    @Autowired
    private KdniaoTrackQueryAPI kdniaoTrackQueryAPI;

    //通过快递公司名和订单编号查询订单轨迹
    @RequestMapping("/selectTraces")
    public String selectTraces( String shippercode, String logisticcode) throws Exception {
        String orderTracesByJson = kdniaoTrackQueryAPI.getOrderTracesByJson(shippercode, logisticcode);
        //物流接口生成的就是一个json字符串，甩自己去转json字符串
        return orderTracesByJson;
    }



    //修改订单状态
    @RequestMapping("/updateStates")
    public String updateStates( String logisticcode, String state){
        String s = logisticsService.updateStates(logisticcode, state);
        return JSON.toJSONString(s);
    }

    //新增物流单号
    @RequestMapping("/insertLog")
    public String insertLog( String shippercode, String logisticcode){
        return logisticsService.insertLog(shippercode,logisticcode);
    }


    //在自己本数据库通过订单号查询
    @RequestMapping("getByLogisticcode")
    public String  getByLogisticcode(String logisticcode){

        return logisticsService.getByLogisticcode(logisticcode);
    }






//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("selectOne")
//    public Logistics selectOne(Integer id) {
//        return this.logisticsService.queryById(id);
//    }

}