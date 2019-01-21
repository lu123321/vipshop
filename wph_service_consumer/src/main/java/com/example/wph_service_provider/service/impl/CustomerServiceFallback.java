package com.example.wph_service_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_service_provider.service.CustomerServiceService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomerServiceFallback implements CustomerServiceService {
    @Override
    public String findQuestionByType(String cstype) {
        return JSON.toJSONString("服务出错，请稍后");
    }

//    @Override
//    public ModelAndView findSolutionByQuestion(String csquestion) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("服务出错，请稍后");
//        mav.setViewName("connectService");
//        return mav;
//    }

    @Override
    public String findSolutionByQuestion(String csquestion) {
        return JSON.toJSONString("服务出错，请稍后");
    }
}
