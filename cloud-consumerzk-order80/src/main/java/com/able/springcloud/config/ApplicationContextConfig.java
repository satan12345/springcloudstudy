package com.able.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @param
 * @author jipeng
 * @date 2020-03-13 13:43
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    /**
     * 使用LoadBalanced注解赋予RestTemplate负载均衡的能力
     */
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}

