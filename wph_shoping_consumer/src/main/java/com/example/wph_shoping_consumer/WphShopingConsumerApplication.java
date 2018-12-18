package com.example.wph_shoping_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class WphShopingConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WphShopingConsumerApplication.class, args);
    }
}

