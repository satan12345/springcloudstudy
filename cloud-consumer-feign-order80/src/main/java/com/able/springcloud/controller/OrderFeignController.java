package com.able.springcloud.controller;

import com.able.springcloud.annotation.UseResponseAdvice;
import com.able.springcloud.api.PaymentFeignService;
import com.able.springcloud.dto.CommonResponse;
import com.able.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @param
 * @author jipeng
 * @date 2020-03-20 11:33
 */
@RestController
@Slf4j
@UseResponseAdvice
public class OrderFeignController {

    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping(value = "/feign/consumer/payment/get/{id}")
    public CommonResponse<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResponse<Payment> result = paymentFeignService.getPaymentById(id);
        log.info("查询到的结果为:{}",result);
        return result;
    }
    @GetMapping(value = "/feign/consumer/payment/timeout")
    public CommonResponse<String> timeout(){
        return paymentFeignService.timeout();
    }

}

