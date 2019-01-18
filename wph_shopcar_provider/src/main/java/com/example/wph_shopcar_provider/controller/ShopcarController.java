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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String wph_shopcart_add(@RequestParam("listnumber") String listnumber){
        return shopcarService.wph_shopcart_add(listnumber);
    }

    @PostMapping("/del")
    @ResponseBody
    public void wph_shopcart_del(HttpServletRequest request,@RequestParam("skuserialnumber") String skuserialnumber) {
        String userid = request.getHeader("userid");
        shopcarService.wph_shopcart_del(Integer.parseInt(userid), skuserialnumber);
    }

    @PostMapping("/shopcartupdate")
    @ResponseBody
    public void wph_shopcart_update(HttpServletRequest request, @RequestParam("shoping")String shoping){
        String userid=request.getHeader("userid");
        System.out.println("用户id为:"+userid);
        shopcarService.wph_shopcart_update(Integer.parseInt(userid),shoping);
    }

    @PostMapping("/wphshopcartsel")
    @ResponseBody
    public String wph_shopcart_sel( HttpServletRequest request){
        String userid=request.getHeader("userid");
        return JSON.toJSONString(shopcarService.wph_shopcart_sel(Integer.parseInt(userid)));
    }

    @PostMapping(path = "/wphshophistroy")
    @ResponseBody
    public String wph_shophistroy_sel( HttpServletRequest request){
        String userid=request.getHeader("userid");
        return JSON.toJSONString(shopcarService.wph_shophistroy_sel(Integer.parseInt(userid)));
    }

    @PostMapping("/shopcartdel")
    @ResponseBody
    public void del(HttpServletRequest request){

        String userid=request.getHeader("userid");
        shopcarService.del(Integer.parseInt(userid));
    }

    @PostMapping("/selshopingnum")
    @ResponseBody
    public Integer selshopingnum(HttpServletRequest request){
        String userid=request.getHeader("userid");
        System.out.println(userid);
        return shopcarService.selchopingnum(Integer.parseInt(userid));
    }
}
