package com.example.wph_order_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class WphOrderConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WphOrderConsumerApplication.class, args);
    }

}

