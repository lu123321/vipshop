package com.example.wph_shoping_provider.controller;

import com.example.wph_shoping_provider.entity.WphSku;
import com.example.wph_shoping_provider.service.WphSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WphSkuController {
    @Autowired
    private WphSkuService wphSkuService;

    @RequestMapping(value = "selectSku",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectSku(@RequestParam("skuSerialnumber")String skuSerialnumber,@RequestParam("shopingNumber")Integer shopingNumber ){

        return wphSkuService.WphSeleteSku(skuSerialnumber,shopingNumber);
    }


    @RequestMapping(value = "WphSelectku",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String WphSelectku(@RequestParam("skuSerialnumber")String skuSerialnumber,@RequestParam("shopingNumber")Integer shopingNumber){
        System.out.println("123");
        return wphSkuService.WphSelectku(skuSerialnumber,shopingNumber);
    }


    @RequestMapping(value = "WphBrandSku",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String WphBrandSku(@RequestParam("BrandId") String BrandId,@RequestParam("time") String time){
        System.out.println("66666");
        return wphSkuService.BrandSku(BrandId,time);
    }

    @RequestMapping(value = "xiajiaBrand",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String xiajiaBrand(@RequestParam("xiajia") String xiajia){
        return wphSkuService.xiajiaBrand(xiajia);
    }

    @RequestMapping("/UpdateSkus")
    @ResponseBody
    public String UpdateSku(@RequestBody WphSku wphSku) {
        return wphSkuService.UpdateSku(wphSku);
    }

    @RequestMapping("/insterSkus")
    @ResponseBody
    public String insterSku(@RequestBody WphSku wphSku) {
        return wphSkuService.insterSku(wphSku);
    }
}
