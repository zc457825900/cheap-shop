package com.perfect.cheapshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CheapShopCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheapShopCommonApplication.class, args);
    }

}
