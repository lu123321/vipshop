package com.example.wph_shopcar_consumer.controller;

import com.example.wph_shopcar_consumer.pojo.WphUserAddress;
import com.example.wph_shopcar_consumer.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdressController {

    @Autowired
    private AdressService adressService;

    /**
     * 通过用户编号查询用户对应的所有地址
     * @param id 用户编号
     * @return 数据集合
     */
    @RequestMapping(value = "selectAll" , method = RequestMethod.POST)
    @ResponseBody
    public List<WphUserAddress> selectAll(@RequestParam("id") int id){
        return adressService.selectAll(id);
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
}
