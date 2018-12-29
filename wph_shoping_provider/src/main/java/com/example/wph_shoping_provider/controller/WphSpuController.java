package com.example.wph_shoping_provider.controller;

import com.example.wph_shoping_provider.entity.WphSpu;
import com.example.wph_shoping_provider.service.WphSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/WphSpu")
public class WphSpuController {
    @Autowired
    private WphSpuService wphSpuService;

    @RequestMapping(value = "selectspus",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectSku(@RequestParam("spuid")Integer spuId){
        System.out.println("----------------------------");
        return wphSpuService.wphselectSpuShow(spuId);
    }


    @RequestMapping("/wphselectSpuShows")
    @ResponseBody
    public String wphselectSpuShow(@RequestParam("spuid") Integer spuid) {
        return wphSpuService.wphselectSpuShow(spuid);
    }

    @RequestMapping("/wphselectSpuAlls")
    @ResponseBody
    public String wphselectSpuAll(@RequestParam("smalltypeid") Integer smalltypeId, @RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize) {
        System.out.println(wphSpuService.wphselectSpuAll(smalltypeId,pageNum,pageSize));
        return wphSpuService.wphselectSpuAll(smalltypeId,pageNum,pageSize);
    }

    @RequestMapping("/wphBranSpus")
    @ResponseBody
    public String wphBranSpu(@RequestParam("BranId") Integer BranId, @RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize) {
        return wphSpuService.wphBranSpu(BranId,pageNum,pageSize);
    }

    @RequestMapping("/insertSpus")
    @ResponseBody
    public String insertSpu(@RequestBody WphSpu wphSpu) {
        return wphSpuService.insertSpu(wphSpu);
    }

    @RequestMapping("/wphUpdataSpuShows")
    @ResponseBody
    public String wphUpdataSpuShow(@RequestBody WphSpu wphSpu) {
        return wphSpuService.wphUpdataSpuShow(wphSpu);
    }

    @RequestMapping("/ASCspus")
    @ResponseBody
    public String ASCspu( String typeid, String brandid) {
        System.out.println(typeid);
        System.out.println(brandid);
        return wphSpuService.ASCspu(typeid,brandid);
    }

    @RequestMapping("/DESCspus")
    @ResponseBody
    public String DESCspu(@RequestParam("typeid") String typeid,@RequestParam("brandid")  String brandid) {
        return wphSpuService.DESCspu(typeid,brandid);
    }
}
