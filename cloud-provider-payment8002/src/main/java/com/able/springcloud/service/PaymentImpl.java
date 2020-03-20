package com.able.springcloud.service;

import com.able.springcloud.entities.Payment;
import com.able.springcloud.mapper.PaymentMapper;
import com.able.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @param
 * @author jipeng
 * @date 2020-03-12 18:17
 */
@Service
public class PaymentImpl implements PaymentService {
    @Resource
    PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {
        int i = paymentMapper.insertSelective(payment);
        return i;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}

