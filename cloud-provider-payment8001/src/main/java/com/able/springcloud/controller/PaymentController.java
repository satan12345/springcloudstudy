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
import java.util.concurrent.TimeUnit;

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
    @Value("${server.port}")
    int port;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("discovery")
    public List<ServiceInstance> discovery(){
        List<ServiceInstance> result= Lists.newArrayList();
        //服务清单列表
        List<String> services = discoveryClient.getServices();
        services.forEach(x->{
            List<ServiceInstance> instances = discoveryClient.getInstances(x);
            result.addAll(instances);
        });
        return result;
    }

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
    @GetMapping("timeout")
    public String timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "超时测试"+port;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }


}

