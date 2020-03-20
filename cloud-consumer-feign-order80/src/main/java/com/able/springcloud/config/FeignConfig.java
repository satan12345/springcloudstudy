package com.able.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @param
 * @author jipeng
 * @date 2020-03-20 13:46
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return feign.Logger.Level.FULL;
    }

}

