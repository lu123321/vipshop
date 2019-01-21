package com.example.wph_service_provider.controller;

import com.example.wph_service_provider.service.CustomerServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
public class CustomerServiceController {

    @Autowired
    private CustomerServiceService cs;


    //通过问题类型查找具体的问题
    @RequestMapping("/findQuestionByType")
    public String findQuestionByType(String cstype, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return cs.findQuestionByType(cstype);
    }

    //通过具体问题找解决方案
    @RequestMapping("/findSolutionByQuestion")
    public String findSolutionByQuestion( String csquestion,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return cs.findSolutionByQuestion(csquestion);
    }


//    //通过具体问题找解决方案
//    @RequestMapping("/findSolutionByQuestion")
//    public ModelAndView findSolutionByQuestion(String csquestion){
//        ModelAndView solutionByQuestion = cs.findSolutionByQuestion(csquestion);
//        return solutionByQuestion;
//    }


}
