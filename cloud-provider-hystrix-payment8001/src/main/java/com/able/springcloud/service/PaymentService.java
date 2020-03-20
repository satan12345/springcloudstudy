package com.able.springcloud.service;

import com.able.springcloud.entities.Payment;
import com.able.springcloud.mapper.PaymentMapper;
import com.able.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @param
 * @author jipeng
 * @date 2020-03-12 18:17
 */
@Service
public class PaymentService {


    public String paymentInfoOK(Integer id) {
        String value = "线程名称:" + Thread.currentThread().getName() + "    paymentInfoOK id=" + id;
        return value;
    }

    public String paymentInfo_TimeOut(Integer id) {
        //int age = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " id:  " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时(秒): ";
    }
}

