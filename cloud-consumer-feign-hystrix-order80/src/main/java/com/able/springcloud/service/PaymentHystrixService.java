package com.able.springcloud.service;

import com.able.springcloud.dto.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @param
 * @author jipeng
 * @date 2020-03-20 18:02
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-SERVICE",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("payment/hystrix/ok/{id}")
     CommonResponse<String> paymentInfoOK(@PathVariable("id") Integer id);
    @GetMapping("payment/hystrix/timeout/{id}")
    CommonResponse<String> paymentInfo_TimeOut(@PathVariable("id") Integer id);
}

