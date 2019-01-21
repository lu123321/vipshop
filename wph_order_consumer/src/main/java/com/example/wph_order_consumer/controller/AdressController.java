package com.example.wph_order_consumer.controller;

import com.example.wph_order_consumer.pojo.WphUserAddress;
import com.example.wph_order_consumer.service.AdressService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdressController {

    @Autowired
    private AdressService adressService;

    /**
     * 通过用户编号查询用户对应的所有地址
     *
     * @return 数据集合
     */
    @RequestMapping(value = "selectAll" , method = RequestMethod.POST)
    @ResponseBody
    public String selectAll(HttpServletRequest request){
        String userid = request.getHeader("userid");
        return adressService.selectAll(Integer.parseInt(userid));
    }

    /**
     * 新增数据
     *
     * @param wphUserAddress 实例对象
     * @return 实例对象
     */
    @RequestMapping(value = "insertAdd" , method = RequestMethod.POST)
    @ResponseBody
    public String insert( WphUserAddress wphUserAddress){
        System.out.println("wphUserAddress = [" + wphUserAddress.getAddAddress() + "]");
        return adressService.insert(wphUserAddress);
    }
    /**
     * 修改数据
     *
     * @param wphUserAddress 实例对象
     * @return 实例对象
     */
    @RequestMapping(value = "updateAdd" , method = RequestMethod.POST)
    @ResponseBody
    public String update(WphUserAddress wphUserAddress){
        return adressService.update(wphUserAddress);
    }
    /**
     * 修改地址状态
     * @param addId 地址id
     * @return
     */
    @RequestMapping(value = "updateAddState",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public String updateState(@RequestParam("addId") Integer addId ,HttpServletRequest request) {
        String userid=request.getHeader("userid");
        return adressService.updateState(addId,Integer.parseInt(userid));
    }
}
