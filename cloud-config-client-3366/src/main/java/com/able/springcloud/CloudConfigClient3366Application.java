package com.able.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConfigClient3366Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3366Application.class, args);
    }

}
