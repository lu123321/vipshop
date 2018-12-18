package com.example.wph_pay_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WphPayProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WphPayProviderApplication.class, args);
    }

}

