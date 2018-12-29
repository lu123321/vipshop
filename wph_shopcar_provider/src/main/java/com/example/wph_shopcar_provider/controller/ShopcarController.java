package com.example.wph_shopcar_provider.controller;

import com.alibaba.fastjson.JSON;
import com.example.wph_shopcar_provider.pojo.Shoping;
import com.example.wph_shopcar_provider.srvice.ShopcarService;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShopcarController {

    @Autowired
    private ShopcarService shopcarService;

    @RequestMapping(value = "addshopcar",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String wph_shopcart_add(@RequestParam("listnumber") String listnumber,@RequestParam("userid") Integer userid){
        return shopcarService.wph_shopcart_add(listnumber,userid);
    }

    @PostMapping("/del")
    @ResponseBody
    public String wph_shopcart_del(@RequestParam("userid") String userid,@RequestParam("skuserialnumber") String skuserialnumber){
        System.out.println("userid = [" + userid + "], skuserialnumber = [" + skuserialnumber + "]");
        shopcarService.wph_shopcart_del(userid, skuserialnumber);
        return "成功啦";
    }

    @PostMapping("/update")
    public void wph_shopcart_update(@RequestParam("userid") Integer userid, @RequestParam("shoping")String shoping){
         shopcarService.wph_shopcart_update(userid,shoping);
    }

    @RequestMapping("/wphshopcart1")
    @ResponseBody
    public String wph_shopcart_sel(@RequestParam("id") String id){
        return JSON.toJSONString(shopcarService.wph_shopcart_sel(id));
    }

    @PostMapping(path = "/wph_shophistroy")
    public String wph_shophistroy_sel(String id){
        return JSON.toJSONString(shopcarService.wph_shophistroy_sel(id));
    }
}
