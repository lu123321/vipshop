package com.example.wph_order_provider.controller;

import com.alibaba.fastjson.JSON;
import com.example.wph_order_provider.entity.WphOrderShoping;
import com.example.wph_order_provider.service.WphOrderShopingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (WphOrderShoping)表控制层
 *
 * @author makejava
 * @since 2018-12-20 11:55:39
 */
@Controller
public class WphOrderShopingController {
    /**
     * 服务对象
     */
    @Resource
    private WphOrderShopingService wphOrderShopingService;

    /**
     * 通过主键查询单条数据
     * @return 单条数据
     */
    @PostMapping("/selectOne1")
    @ResponseBody
    public String selectOne(HttpServletRequest request){
        String userid=request.getHeader("userid");
        return JSON.toJSONString(wphOrderShopingService.queryAll(Integer.parseInt(userid)));
    }

}