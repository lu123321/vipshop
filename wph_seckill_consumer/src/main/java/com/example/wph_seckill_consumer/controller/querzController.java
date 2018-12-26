package com.example.wph_seckill_consumer.controller;

import com.example.wph_seckill_consumer.job.SimpleEndJob;
import com.example.wph_seckill_consumer.job.SimplestartJob;
import com.example.wph_seckill_consumer.service.Jobservice;
import com.example.wph_seckill_consumer.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class querzController {
    @Autowired
    Jobservice jobService;

    /**
     * 后台上班上线
     * @param message
     * @param jobScheduleTime
     * @param jobendtime
     */
    @RequestMapping("schedule")
    public String schedule(@RequestParam("message") String message,
                           @RequestParam("jobScheduleTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date jobScheduleTime,
                           @RequestParam("jobendtime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date jobendtime
                           ){
        //@RequestParam("cronExpression") String cronExpression
        boolean b1 = jobService.scheduleOneTimeStartJob(message, SimplestartJob.class, jobScheduleTime,jobendtime);
        boolean b = jobService.scheduleOneTimeEndJob(message, SimpleEndJob.class, jobendtime,jobendtime);
        if(b1 == true && b == true){
            return "上架成功";
        }else{
            return "上架失败";
        }
    }
}
