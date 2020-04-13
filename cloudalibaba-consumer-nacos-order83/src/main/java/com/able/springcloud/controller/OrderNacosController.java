package com.able.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @param
 * @author jipeng
 * @date 2020-04-13 10:19
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Resource
    RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;


    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }
}

