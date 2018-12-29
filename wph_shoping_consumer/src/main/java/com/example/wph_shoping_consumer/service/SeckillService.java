package com.example.wph_shoping_consumer.service;

import com.example.wph_shoping_consumer.service.impl.SeckillServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@FeignClient(name = "wph-seckill-provider",fallback = SeckillServiceImpl.class)
public interface SeckillService {
    /**
     * 通过传来的商品编号和商品数量进行库存锁定
     * @return
     */
    @RequestMapping(value = "cutRepertory",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String cutRepertory(@RequestParam("pinpaiId") String pinpaiId,@RequestParam("productId") String productId,@RequestParam("number") String number);
    /**
     * 后台上线
     * @param message
     * @param jobScheduleTime
     * @param jobendtime
     */
    @RequestMapping("schedule")
    public String schedule(@RequestParam("message") String message,
                           @RequestParam("jobScheduleTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date jobScheduleTime,
                           @RequestParam("jobendtime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date jobendtime
    );
}
