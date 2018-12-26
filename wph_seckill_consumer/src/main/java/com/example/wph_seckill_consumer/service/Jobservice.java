package com.example.wph_seckill_consumer.service;

import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public interface Jobservice {
    boolean scheduleOneTimeStartJob(String message, Class<? extends QuartzJobBean> jobClass, Date startdate,Date jobendtime);
    boolean scheduleOneTimeEndJob(String message, Class<? extends QuartzJobBean> jobClass, Date enddate,Date jobendtime);

}
