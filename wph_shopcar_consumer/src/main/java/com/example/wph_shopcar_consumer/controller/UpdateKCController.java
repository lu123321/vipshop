package com.example.wph_shopcar_consumer.controller;

import com.example.wph_shopcar_consumer.service.UpdateKcService;
import com.netflix.client.http.HttpResponse;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UpdateKCController {

    @Autowired
    private UpdateKcService updateKcService;

    /**
     * 购物车加减进行库存的锁定
     * @param pinpaiId
     * @param productId
     * @param number
     * @return
     */
    @RequestMapping(value = "cutlistRepertory",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String cutlistRepertory(@RequestParam("pinpaiId") String pinpaiId, @RequestParam("productId") String productId, @RequestParam("number") String number){

//        response.setHeader("Access-Control-Allow-Origin","*");
        return updateKcService.cutlistRepertory(pinpaiId,productId,number);
    };
}
