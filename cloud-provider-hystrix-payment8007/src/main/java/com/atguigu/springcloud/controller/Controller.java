package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Controller {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/hystrix/ok")
    public String ok(){
        return paymentService.ok();
    }

    @GetMapping(value = "/payment/hystrix/error/{id}")
    public String error(@PathVariable("id")Long id){
        return paymentService.error(id,0);
    }

    @GetMapping(value = "/payment/hystrix/circuit/breaker/{id}")
    public String circuitBreaker(@PathVariable("id") Long id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
