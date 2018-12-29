package com.example.wph_shoping_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.example.wph_shoping_provider.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class WphShopingProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WphShopingProviderApplication.class, args);
    }
}

