package com.able.springcloud.service;

import com.able.springcloud.entities.Payment;

/**
 * @author jipeng
 * @date 2020-03-12 18:15
 * @description
 */
public interface PaymentService {
     int create(Payment payment);

     Payment getPaymentById(Long id);
}
