package com.able.springcloud.controller;

import com.able.springcloud.annotation.UseResponseAdvice;
import com.able.springcloud.entities.Payment;
import com.able.springcloud.service.PaymentService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @param
 * @author jipeng
 * @date 2020-03-12 18:29
 */
@RestController
@Slf4j
@UseResponseAdvice
@RequestMapping("payment")
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Resource
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    int port;

    @PostMapping(value = "create")
    public String create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果影响的条数：{}", result);

        return "数据插入成功";
    }

    @GetMapping(value = "get/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        payment.setPort(port);
        log.info("getPaymentById 哈哈还 根据id={} 查询到的数据为:{}",id,payment);
        return payment;
    }
    @GetMapping("paymentconsul")
    public String paymentconsul(){
        return "springcloud with consul:"+port+ "\t"+ UUID.randomUUID().toString();
    }

    @GetMapping("discovery")
    public List<ServiceInstance> discovery(){
        List<ServiceInstance> result= Lists.newArrayList();
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            result.addAll(discoveryClient.getInstances(service));
        }
        return result;
    }

}

