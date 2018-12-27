package com.example.wph_seckill_provider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.wph_seckill_provider.service.CutRepertoryService;
import com.example.wph_seckill_provider.service.pojo.MoneyRepertoey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class seckillController {
    @Autowired
    private  CutRepertoryService cutRepertoryService;
    /**
     * 通过传来的商品编号和商品数量进行库存锁定
     * @return
     */
    @RequestMapping(value = "cutRepertory",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
        public String cutRepertory(@RequestParam("pinpaiId") String pinpaiId,@RequestParam("productId") String productId,@RequestParam("number") String number){
        return cutRepertoryService.cutrepertory(pinpaiId,productId,number);
    }

    /**
     * 购物车加减进行库存的锁定
     * @param pinpaiId
     * @param productId
     * @param number
     * @return
     */
    @RequestMapping(value = "cutlistRepertory",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String cutlistRepertory(@RequestParam("pinpaiId") String pinpaiId,@RequestParam("productId") String productId,@RequestParam("number") String number){
        return  cutRepertoryService.cutmoneyrep(pinpaiId,productId,number);
    }
    /**
     * 此方法为商品上架时进行商品的添加
     * @param brandId 品牌id
     * @param message 商品信息包括sku及数量
     * @return
     */
    @RequestMapping(value = "addRepertory",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addRepertory(@RequestParam("brandId") String brandId,@RequestParam("message") String message){
        return cutRepertoryService.addRepertory(brandId,message);
    }

    /**
     * 通过品牌ID进行下架操作
     * @param brandId
     * @return
     */
    @RequestMapping(value = "removeRepertory",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String removeRepertory(@RequestParam("brandId") String brandId){
        return cutRepertoryService.removeRepertory(brandId);
    }
}
