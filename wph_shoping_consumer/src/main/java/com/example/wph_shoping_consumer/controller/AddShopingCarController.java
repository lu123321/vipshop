package com.example.wph_shoping_consumer.controller;

import com.example.wph_shoping_consumer.service.AddShopingCar;
import com.example.wph_shoping_consumer.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class AddShopingCarController {
    @Autowired
    private AddShopingCar addShopingCar;
    @Autowired
    private SeckillService seckillService;

    @RequestMapping("/addShopingCar")
    @ResponseBody
    public String addShopingCar(@RequestParam("productId")String productId ,@RequestParam("shopingNumber") Integer shopingNumber,@RequestParam("userid")Integer userid ){
        return addShopingCar.addShoping(productId,shopingNumber,userid);
    }

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
    ){
       return seckillService.schedule(message,jobScheduleTime,jobendtime);
    }
}
