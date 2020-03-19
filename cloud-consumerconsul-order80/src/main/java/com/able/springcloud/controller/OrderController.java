package com.able.springcloud.controller;

import com.able.springcloud.annotation.UseResponseAdvice;
import com.able.springcloud.dto.CommonResponse;
import com.able.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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


//    public static final String PAYMENT_URL = "http://localhost:8081";
    public static final String PAYMENT_URL="http://consul-provider-payment";

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
    @GetMapping("paymentconsul")
    public CommonResponse<String> paymentconsul(){
       return  restTemplate.getForObject(PAYMENT_URL+"/payment/paymentconsul",CommonResponse.class);
    }

}

