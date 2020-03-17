package com.able.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.able.springcloud.mapper"})
public class CloudProviderPayment8004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8004Application.class, args);
    }

}
