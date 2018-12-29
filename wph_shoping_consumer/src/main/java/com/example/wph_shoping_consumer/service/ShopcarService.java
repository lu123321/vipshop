package com.example.wph_shoping_consumer.service;

import com.example.wph_shoping_consumer.service.impl.ShopcarServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@FeignClient(name = "wph-shopcar-provider",fallback = ShopcarServiceImpl.class)
public interface ShopcarService {
    @RequestMapping(value = "addshopcar",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    String wph_shopcart_add(@RequestParam("listnumber")String listnumber,@RequestParam("userid")Integer userid);
}
