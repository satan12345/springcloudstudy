package com.able.springcloud.controller;

import com.able.springcloud.dto.CommonResponse;
import com.able.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-20 11:57
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public CommonResponse<String> paymentInfo_OK(@PathVariable("id") Integer id) {
        CommonResponse<String> result = paymentHystrixService.paymentInfoOK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    @HystrixCommand
    public  CommonResponse<String> paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
//        int age = 10/0;
        CommonResponse<String> result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
    public CommonResponse<String> paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        CommonResponse commonResponse=CommonResponse
                .getSuccessWithResultInstance("我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o");
        return commonResponse;
    }

    // 下面是全局fallback方法
    public CommonResponse<String> payment_Global_FallbackMethod()
    {
        CommonResponse commonResponse=CommonResponse
                .getSuccessWithResultInstance("Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~");
        return commonResponse;

    }
}
