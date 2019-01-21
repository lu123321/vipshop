package com.example.wph_service_provider.controller;

import com.alibaba.fastjson.JSON;
import com.example.wph_service_provider.entity.Customerservice;
import com.example.wph_service_provider.service.CustomerserviceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * (Customerservice)表控制层
 *
 * @author makejava
 * @since 2018-12-20 14:18:52
 */
@RestController
public class CustomerserviceController {


    /**
     * 服务对象
     */
    @Resource
    private CustomerserviceService customerserviceService;

    //通过问题类型查找具体的问题
    @RequestMapping("/findQuestionByType")
    public String findQuestionByType(String cstype) {
        return customerserviceService.findQuestionByType(cstype);
    }

    //通过具体问题找解决方案
    @RequestMapping("/findSolutionByQuestion")
    public String findSolutionByQuestion(String csquestion) {
        Customerservice solutionByQuestion = customerserviceService.findSolutionByQuestion(csquestion);
        String s = JSON.toJSONString(solutionByQuestion);
        return s;
     }

//        //通过具体问题找解决方案
//    @RequestMapping("/findSolutionByQuestion")
//    public ModelAndView  findSolutionByQuestion(@RequestParam("csquestion") String csquestion){
//        Customerservice solutionByQuestion = customerserviceService.findSolutionByQuestion(csquestion);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("msg",solutionByQuestion);
//        mav.setViewName("connectService");
//        return mav;
//    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Customerservice selectOne(Integer id) {
        return this.customerserviceService.queryById(id);
    }

}