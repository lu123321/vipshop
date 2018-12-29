package com.example.wph_shopcar_consumer.service;

import com.example.wph_shopcar_consumer.service.Impl.SelectSkuServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "wph-shoping-provider",fallback = SelectSkuServiceImpl.class)
public interface SelectSkuService {

    @RequestMapping(value = "selectspu",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectSku(@RequestParam("spuid")Integer spuId);
}
