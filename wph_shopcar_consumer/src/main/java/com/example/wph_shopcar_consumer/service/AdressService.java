package com.example.wph_shopcar_consumer.service;

import com.example.wph_shopcar_consumer.pojo.WphUserAddress;
import com.example.wph_shopcar_consumer.service.Impl.AdressServiceImpl;
import com.example.wph_shopcar_consumer.service.Impl.CouponsServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "wph-personal-provider",fallback = AdressServiceImpl.class)
public interface AdressService {


    /**
     * 通过用户编号查询用户对应的所有地址
     * @param id 用户编号
     * @return 数据集合
     */
    @RequestMapping(value = "selectAll" , method = RequestMethod.POST)
    @ResponseBody
    public List<WphUserAddress> selectAll(@RequestParam("id") int id);
    /**
     * 新增数据
     *
     * @param wphUserAddress 实例对象
     * @return 实例对象
     */
    @RequestMapping(value = "insertAdd" , method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody WphUserAddress wphUserAddress);
    /**
     * 修改数据
     *
     * @param wphUserAddress 实例对象
     * @return 实例对象
     */
    @RequestMapping(value = "updateAdd" , method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody WphUserAddress wphUserAddress);
}
