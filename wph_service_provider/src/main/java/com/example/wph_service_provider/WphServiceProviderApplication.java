package com.example.wph_service_provider;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.example.wph_service_provider.dao")
public class WphServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WphServiceProviderApplication.class, args);


    }

}

