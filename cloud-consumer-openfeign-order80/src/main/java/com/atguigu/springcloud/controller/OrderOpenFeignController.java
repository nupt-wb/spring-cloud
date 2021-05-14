package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentOpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderOpenFeignController {

    @Resource
    private PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id")Long id){
        return paymentOpenFeignService.getPayment(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String timeout(){
        return paymentOpenFeignService.timeout();
    }
}
