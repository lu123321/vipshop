package com.example.wph_seckill_consumer.job;


import com.example.wph_seckill_consumer.service.Jobservice;
import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CronJob extends QuartzJobBean implements InterruptableJob {
    private volatile boolean toStopFlag = true;

    @Autowired
    Jobservice jobService;
    @Override
    public void interrupt() throws UnableToInterruptJobException {
        System.out.println("Stopping thread... ");
        toStopFlag = false;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

    }
}
