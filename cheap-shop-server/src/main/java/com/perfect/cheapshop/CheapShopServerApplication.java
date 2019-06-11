package com.perfect.cheapshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class CheapShopServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheapShopServerApplication.class, args);
    }

}
