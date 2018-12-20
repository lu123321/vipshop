package com.example.wph_shopcar_provider.controller;

import com.example.wph_shopcar_provider.pojo.Shoping;
import com.example.wph_shopcar_provider.srvice.ShopcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShopcarController {

    @Autowired
    private ShopcarService shopcarService;

    @GetMapping("/add")
    public void wph_shopcart_add(String id, int num){
        shopcarService.wph_shopcart_add(id,num);
    }

    @GetMapping("/del")
    public void wph_shopcart_del(String id){
        shopcarService.wph_shopcart_del(id);
    }

    @GetMapping("/update")
    public void wph_shopcart_update(String id,int num){
        shopcarService.wph_shopcart_update(id,num);
    }

    @GetMapping(path = "/wph_shopcart")
    public String wph_shopcart_sel(Model model,String id){
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("shoping",shopcarService.wph_shopcart_sel(id));
        list.add(map);
        model.addAttribute("map",list);
        return "wph_shopcart";
    }

}
