package com.able.springcloud.config;

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
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

