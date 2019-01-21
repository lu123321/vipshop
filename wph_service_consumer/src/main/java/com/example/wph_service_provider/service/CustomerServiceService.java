package com.example.wph_service_provider.service;

import com.example.wph_service_provider.service.impl.CustomerServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@FeignClient(value = "wph-service-provider",fallback =CustomerServiceFallback.class)
public interface CustomerServiceService {


    //通过问题类型查找具体的问题

    @RequestMapping("/findQuestionByType")
    public String findQuestionByType(@RequestParam("cstype") String cstype);

    //通过具体问题找解决方案
    @RequestMapping("/findSolutionByQuestion")
    public String findSolutionByQuestion(@RequestParam("csquestion") String csquestion);

//    //通过具体问题找解决方案
//    @RequestMapping("/findSolutionByQuestion")
//    public ModelAndView findSolutionByQuestion(@RequestParam("csquestion")String csquestion);
}
