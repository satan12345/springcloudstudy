package com.able.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class CloudZuul9526Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuul9526Application.class, args);
    }

}
