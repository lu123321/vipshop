package com.example.wph_shopcar_consumer.service;

import com.example.wph_shopcar_consumer.service.Impl.UpdateKcServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "wph-seckill-provider",fallback = UpdateKcServiceImpl.class)
public interface UpdateKcService {
    /**
     * 购物车加减进行库存的锁定
     * @param pinpaiId
     * @param productId
     * @param number
     * @return
     */
    @RequestMapping(value = "cutlistRepertory",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    String cutlistRepertory(@RequestParam("pinpaiId") String pinpaiId,@RequestParam("productId") String productId,@RequestParam("number") String number);
}
