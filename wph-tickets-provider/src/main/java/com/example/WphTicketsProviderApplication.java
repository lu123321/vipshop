package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling     //启动定时任务
public class WphTicketsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WphTicketsProviderApplication.class, args);
    }

}

