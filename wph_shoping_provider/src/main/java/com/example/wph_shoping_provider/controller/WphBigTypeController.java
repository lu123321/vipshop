package com.example.wph_shoping_provider.controller;

import com.example.wph_shoping_provider.entity.WphBigtype;
import com.example.wph_shoping_provider.entity.WphBrand;
import com.example.wph_shoping_provider.service.MiddleAndBigService;
import com.example.wph_shoping_provider.service.WphBigtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WphType")
public class WphBigTypeController {
    @Autowired
    private MiddleAndBigService middleAndBigService;
    @Autowired
    private WphBigtypeService wphBigtypeService;

    @RequestMapping("/type")
    public String typeAll(){
        System.out.println(middleAndBigService.type());
        return middleAndBigService.type();
    }

    @RequestMapping("/BigType")
    public String bigtypeAll(){
        System.out.println(wphBigtypeService.selectBigtype());
        return wphBigtypeService.selectBigtype();
    }

    @RequestMapping("/delbigtypes")
    public String delbigtype(Integer bigTypeId) {
        return wphBigtypeService.delBigtype(bigTypeId);
    }

    @RequestMapping("/insertbigtypes")
    public String insertbigtype(WphBigtype wphBigtype) {
        return wphBigtypeService.insetBigtype(wphBigtype);
    }
}
