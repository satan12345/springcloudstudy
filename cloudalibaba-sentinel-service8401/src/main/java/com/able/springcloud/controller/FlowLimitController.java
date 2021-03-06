package com.able.springcloud.controller;

import com.able.springcloud.annotation.UseResponseAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @author jipeng
 * @date 2020-04-15 18:46
 */
@RestController
@UseResponseAdvice
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() throws InterruptedException {

        return "test-AA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "test-BB";
    }

}

