package com.example.wph_shopcar_consumer.controller;

import com.example.wph_shopcar_consumer.service.SelectSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SelectSkuController {
    @Autowired
    private SelectSkuService selectSkuService;

    @RequestMapping(value = "selectspu",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectSku(@RequestParam("spuid")Integer spuId){
        System.out.println("spuId = [" + spuId + "]");
        return selectSkuService.selectSku(spuId);
    };
}
