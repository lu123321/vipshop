package com.example.wph_seckill_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WphSeckillProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WphSeckillProviderApplication.class, args);
    }

}

