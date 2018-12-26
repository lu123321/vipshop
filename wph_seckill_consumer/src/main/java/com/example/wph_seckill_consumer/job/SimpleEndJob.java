package com.example.wph_seckill_consumer.job;

import com.example.wph_seckill_consumer.service.SeckillService;
import com.example.wph_seckill_consumer.service.ShoppingService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SimpleEndJob extends QuartzJobBean implements InterruptableJob {
    private volatile boolean toStopFlag = true;
    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private SeckillService seckillService;
    @Override
    public void interrupt() throws UnableToInterruptJobException {
        System.out.println("Stopping thread... ");
        toStopFlag = false;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        String message = (String) mergedJobDataMap.get("message");
        System.out.println(message);
        //到了下架时间需要从redis中取出对应的品牌的所有sku和数量，发送到商品接口中进行商品下架处理
        String s1 = seckillService.removeRepertory(message);
        System.out.println(s1);
        shoppingService.xiajiaBrand(s1);
    }
}
