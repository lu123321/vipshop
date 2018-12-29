package com.example.wph_order_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@MapperScan("com.example.wph_order_provider.dao")
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.example.wph_order_provider.*")
public class WphOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WphOrderProviderApplication.class, args);
    }

}

