package com.example.wph_seckill_consumer.job;

import com.alibaba.fastjson.JSON;
import com.example.wph_seckill_consumer.service.SeckillService;
import com.example.wph_seckill_consumer.service.ShoppingService;
import com.example.wph_seckill_consumer.service.pojo.GetRepertoey;
import org.quartz.InterruptableJob;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;


public class SimplestartJob extends QuartzJobBean implements InterruptableJob {
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

    /**
     * job执行体
     * @param context
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        //获取数据集合
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        //得到秒杀服务接口
        String message = (String) mergedJobDataMap.get("message");
        String time = (String) mergedJobDataMap.get("subday");
        //此时需要从messsage中取出商品id和时间,再发送到shop服务查到对应的商品sku和数量，再将得到的返回值传到Seckill
        //服务进行商品数量缓存
       // Seckill.addRepertory(message,)
        System.out.println(message);
        System.out.println(shoppingService);
        System.out.println(seckillService);
        String s = shoppingService.WphBrandSku(message,time);
        System.out.println(s);
        if (s != null){
            seckillService.addRepertory(message,s);
        }
    }
}
