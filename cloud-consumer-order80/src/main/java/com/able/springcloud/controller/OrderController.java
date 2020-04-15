package com.able.springcloud.controller;

import cn.hutool.Hutool;
import cn.hutool.core.util.RandomUtil;
import com.able.springcloud.annotation.UseResponseAdvice;
import com.able.springcloud.dto.CommonResponse;
import com.able.springcloud.entities.Payment;
import com.able.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @param
 * @author jipeng
 * @date 2020-03-13 13:42
 */
@RestController
@Slf4j
@UseResponseAdvice
@RequestMapping("consumer/order")
public class OrderController {

    @Resource
    RestTemplate restTemplate;
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    LoadBalancer loadBalancer;


//    public static final String PAYMENT_URL = "http://localhost:8081";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @PostMapping("payment/create")
    public CommonResponse<Payment> create(Payment payment)
    {
        return restTemplate.postForObject(PAYMENT_URL +"/payment/create",payment,CommonResponse.class);
    }

    @GetMapping("payment/get/{id}")
    public CommonResponse<Payment> getPayment(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResponse.class);
    }
    @GetMapping("getPaymentMore/get/{id}")
    public ResponseEntity<CommonResponse> getPaymentMore(@PathVariable("id") Long id){

        ResponseEntity<CommonResponse> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResponse.class);
        forEntity.getBody();
        return forEntity;
    }
    @GetMapping("testEntitry")
    public ResponseEntity<String> testEntitry(){

        ResponseEntity<String> forEntity =new ResponseEntity<>("测试一下",HttpStatus.OK);
        return forEntity;
    }
    @GetMapping("testMyLb")
    public int testMyLb(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instances = loadBalancer.instances(serviceInstanceList);
        return instances.getPort();
    }
    // ====================> zipkin+sleuth
    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }


}

