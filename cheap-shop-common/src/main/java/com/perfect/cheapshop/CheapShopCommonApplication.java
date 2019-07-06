package com.perfect.cheapshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
//@EnableEurekaClient
public class CheapShopCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheapShopCommonApplication.class, args);
    }

}
