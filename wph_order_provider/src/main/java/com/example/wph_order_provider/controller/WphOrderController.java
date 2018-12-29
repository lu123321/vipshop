package com.example.wph_order_provider.controller;

import com.alibaba.fastjson.JSON;
import com.example.wph_order_provider.entity.WphOrder;
import com.example.wph_order_provider.service.WphOrderService;
import com.example.wph_order_provider.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (WphOrder)表控制层
 *
 * @author makejava
 * @since 2018-12-19 09:15:13
 */
@RestController
public class WphOrderController {
    /**
     * 服务对象
     */
    @Autowired
    private WphOrderService wphOrderService;

    /**
     * 通过主键查询单条数据
     * @param orderId 订单id
     * @return 单条数据
     */
    @PostMapping("/selectOne")
    public String selectOne(@RequestParam("orderId") Integer orderId) {
        return JSON.toJSONString(wphOrderService.queryById(orderId));
    }

    @PostMapping("/add")
    public void add(Integer id,String ordershoping,Integer money,String orderadress){
        wphOrderService.insert(id,ordershoping,money,orderadress);
    }

    @PostMapping("/update")
    public String update(@RequestParam("orderno") String orderno,@RequestParam("orderstate")Integer orderstate,@RequestParam("orderpaynumber")String orderpaynumber){
        return wphOrderService.update(orderno,orderstate,orderpaynumber);
    }

    @PostMapping("/del")
    public void del(Integer orderid){
        wphOrderService.deleteById(orderid);
    }

    @PostMapping("/selall")
    public String selpage(Integer userid,Integer pagenum){
        return JSON.toJSONString(wphOrderService.queryAll(userid, pagenum));
    }

    /**
     * 后台查看订单状态
     * @return
     */
    public List<WphOrder> selstate(){
        return wphOrderService.selstate();
    }

    /**
     * 后台发货
     * @return
     */
    public int updatestate(Integer userid ,Integer orderid){
        return wphOrderService.updatestate(userid,orderid);
    }

}