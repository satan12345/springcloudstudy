package com.able.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaSentinelService8402Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSentinelService8402Application.class, args);
    }

}
