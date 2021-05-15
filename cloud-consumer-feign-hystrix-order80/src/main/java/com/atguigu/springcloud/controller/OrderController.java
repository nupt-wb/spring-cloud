package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class OrderController {

//    @Resource
//    private PaymentFeignService paymentFeignService;

//    @GetMapping(value = "/consumer/payment/hystrix/ok")
//    public String ok(){
//        return paymentFeignService.ok();
//    }
//
////    @HystrixCommand(fallbackMethod = "",commandProperties = {
////            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "9800")
////    })
//    @GetMapping(value = "/consumer/payment/hystrix/error/{id}")
//    public String error(@PathVariable("id") Long id){
//        int i =1/0;
//        return paymentFeignService.error(id);
//    }

    public String errorFallBack(Long id){
        return Thread.currentThread().getName()+"调用支付服务异常，请稍候重试"+ UUID.randomUUID().toString()+"  id:"+id;
    }

    public String commonFallBack(Long id){
        return "this is common error fall back ";
    }
}
