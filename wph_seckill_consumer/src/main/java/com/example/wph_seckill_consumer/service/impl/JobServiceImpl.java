package com.example.wph_seckill_consumer.service.impl;


import com.example.wph_seckill_consumer.service.Jobservice;
import com.example.wph_seckill_consumer.service.SeckillService;
import com.example.wph_seckill_consumer.service.ShoppingService;
import com.example.wph_seckill_consumer.util.JobUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 此服务提供上架的任务调度服务
 */
@Service
public class JobServiceImpl implements Jobservice {
    @Autowired
    @Lazy
    SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private ApplicationContext context;

    /**
     * 上架接口
     * @param message
     * @param jobClass
     * @param startdate
     * @return
     */
    @Override
    public boolean scheduleOneTimeStartJob(String message, Class<? extends QuartzJobBean> jobClass, Date startdate,Date jobendtime) {
        String startjobKey = "start"+message+System.currentTimeMillis();
        String groupKey = "SampleGroup";
        String triggerKey = "start"+message+System.currentTimeMillis();
        //将需要调用的两个服务的接口对象传入job中
        JobDetail jobDetail = JobUtil.createJob(message,jobClass, false, context, startjobKey, groupKey,jobendtime);
        Trigger cronTriggerBean = JobUtil.createSingleTrigger(triggerKey, startdate, SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            Date dt = scheduler.scheduleJob(jobDetail, cronTriggerBean);
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 下架接口
     * @param message
     * @param jobClass
     * @param enddate
     * @return
     */
    @Override
    public boolean scheduleOneTimeEndJob(String message, Class<? extends QuartzJobBean> jobClass, Date enddate,Date jobendtime) {
        String startjobKey = "end"+message+System.currentTimeMillis();
        String groupKey = "SampleGroup";
        String triggerKey = "end"+message+System.currentTimeMillis();
        //将需要调用的两个服务的接口对象传入job中
        JobDetail jobDetail = JobUtil.createJob(message,jobClass, false, context, startjobKey, groupKey,jobendtime);
        Trigger cronTriggerBean = JobUtil.createSingleTrigger(triggerKey, enddate, SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            Date dt = scheduler.scheduleJob(jobDetail, cronTriggerBean);
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return false;
    }

}
