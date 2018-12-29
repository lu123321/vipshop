package com.example.wph_shoping_consumer.service;

import com.example.wph_shoping_consumer.service.impl.SeckillServiceImpl;
import com.example.wph_shoping_consumer.service.impl.ShopingServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "wph-shoping-provider",fallback = ShopingServiceImpl.class)
public interface ShopingService {
    @RequestMapping(value = "selectSku",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    String selectSku(@RequestParam("skuSerialnumber")String skuSerialnumber,@RequestParam("shopingNumber")Integer shopingNumber );

    @RequestMapping(value = "WphSelectku",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    String WphSelectku(@RequestParam("skuSerialnumber")String skuSerialnumber,@RequestParam("shopingNumber")Integer shopingNumber);
}
