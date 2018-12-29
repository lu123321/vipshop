package com.example.wph_shoping_provider.controller;

import com.example.wph_shoping_provider.service.WphBigtypeService;
import com.example.wph_shoping_provider.service.WphMiddletypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WphMiddleType")
public class WphMiddletypeController {
    @Autowired
    private WphMiddletypeService wphMiddletypeService;
    @RequestMapping("/middletypeAlls")
    public String bigtypeAll(@RequestParam("bigtype")Integer bigtype){
        System.out.println("----------------------------------------------------------");
        System.out.println(bigtype);
        //System.out.println(wphMiddletypeService.selectMiddletype(bigtype));
        System.out.println("************************************************************");
        return wphMiddletypeService.selectMiddletype(bigtype);
    }
}
