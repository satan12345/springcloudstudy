package com.able.springcloud.service;

import com.able.springcloud.dto.CommonResponse;
import org.springframework.stereotype.Component;

/**
 * @auther zzyy
 * @create 2020-02-20 18:22
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService
{
    @Override
    public CommonResponse<String> paymentInfoOK(Integer id) {
        String msg="-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
        return CommonResponse.getSuccessWithResultInstance(msg);
    }

    @Override
    public CommonResponse<String> paymentInfo_TimeOut(Integer id) {
        String msg="-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";

        return CommonResponse.getSuccessWithResultInstance(msg);
    }

//    @Override
//    public String paymentInfo_OK(Integer id)
//    {
//        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
//    }
//
//    @Override
//    public String paymentInfo_TimeOut(Integer id)
//    {
//        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
//    }
}
