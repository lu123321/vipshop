package com.example.wph_seckill_provider.controller;

import com.example.wph_seckill_provider.service.CutRepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
//        String userid = request.getHeader("userid");
//        System.out.println(userid);
        System.out.println("aaaaaaaaaaaaaaaaaaaaa");
        return cutRepertoryService.cutrepertory(pinpaiId,productId,number);
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
