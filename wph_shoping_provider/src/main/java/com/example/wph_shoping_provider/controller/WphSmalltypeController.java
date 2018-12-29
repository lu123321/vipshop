package com.example.wph_shoping_provider.controller;

import com.example.wph_shoping_provider.entity.WphSmalltype;
import com.example.wph_shoping_provider.service.WphSmalltypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/WphSmalltype")
public class WphSmalltypeController {
    @Autowired
    private WphSmalltypeService wphSmalltypeService;

    @RequestMapping("/selectSmalltyprs")
    @ResponseBody
    public String selectSmalltypr(@RequestParam("middletypeid") Integer middletypeid) {
        return wphSmalltypeService.selectSmalltypr(middletypeid);
    }

    @RequestMapping("/insertSmalltypes")
    @ResponseBody
    public String insertSmalltype(@RequestBody WphSmalltype wphSmalltype) {
        return wphSmalltypeService.insertSmalltype(wphSmalltype);
    }

    @RequestMapping("/updataSmalltypes")
    @ResponseBody
    public String updataSmalltype(@RequestBody WphSmalltype wphSmalltype) {
        return wphSmalltypeService.updataSmalltype(wphSmalltype);
    }
}
