package com.able.springcloud.api;

import com.able.springcloud.dto.CommonResponse;
import com.able.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jipeng
 * @date 2020-03-20 11:26
 * @description
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("payment/get/{id}")
    CommonResponse<Payment> getPaymentById(@PathVariable("id") Long id);
}
