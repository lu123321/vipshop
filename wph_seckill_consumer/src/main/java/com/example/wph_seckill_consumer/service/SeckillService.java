package com.example.wph_seckill_consumer.service;

import com.example.wph_seckill_consumer.service.impl.SeckillServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "wph-seckill-provider",fallback = SeckillServiceImpl.class)
public interface SeckillService {
    /**
     * 此方法为商品上架时进行商品的添加
     * @param brandId 品牌id
     * @param message 商品信息包括sku及数量
     * @return
     */
    @RequestMapping(value = "addRepertory",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    @ResponseBody
    String addRepertory(@RequestParam("brandId") String brandId, @RequestParam("message") String message);
    /**
     * 通过品牌ID进行下架操作
     * @param brandId
     * @return
     */
    @RequestMapping(value = "removeRepertory",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    @ResponseBody
    String removeRepertory(@RequestParam("brandId") String brandId);
}
