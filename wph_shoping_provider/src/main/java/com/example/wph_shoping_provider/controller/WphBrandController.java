package com.example.wph_shoping_provider.controller;

import com.example.wph_shoping_provider.entity.WphBrand;
import com.example.wph_shoping_provider.service.WphBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Brand")
public class WphBrandController{
    @Autowired
    private WphBrandService wphBrandService;

    @RequestMapping("/selectBrandAll")
    @ResponseBody
    public String selectBrandAll(@RequestParam("wphBrandId") Integer wphBrandId) {
        return wphBrandService.selectBrandAll(wphBrandId);
    }
    @RequestMapping("/selectTypeBrandAll")
    @ResponseBody
    public String selectTypeBrandAll(@RequestParam("typeId") Integer typeId) {
        return wphBrandService.selectTypeBrandAll(typeId);
    }

    @RequestMapping("/updateBrand")
    @ResponseBody
    public String updateBrand(@RequestBody WphBrand wphBrand) {
        return wphBrandService.updateBrand(wphBrand);
    }
    @RequestMapping("/insertBrand")
    @ResponseBody
    public String insertBrand(@RequestBody WphBrand wphBrand) {
        return wphBrandService.insertBrand(wphBrand);
    }
}
