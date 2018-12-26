package com.example.wph_seckill_consumer.service;

import com.example.wph_seckill_consumer.service.impl.ShoppingServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "wph-shoping-provider",fallback = ShoppingServiceImpl.class)
public interface ShoppingService {
    @RequestMapping(value = "BrandSku",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    String WphBrandSku(@RequestParam("BrandId")String BrandId,@RequestParam("time")String time);
    @RequestMapping(value = "xiajiaBrand",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    String xiajiaBrand(@RequestParam("xiajia") String xiajia);
}
