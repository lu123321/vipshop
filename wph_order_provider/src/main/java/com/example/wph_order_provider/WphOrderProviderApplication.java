package com.example.wph_order_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WphOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WphOrderProviderApplication.class, args);
    }

}

