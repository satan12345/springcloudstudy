package com.able.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication

@EnableConfigServer
@EnableDiscoveryClient
public class CloudConfigCenter3344Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3344Application.class, args);
    }

}
