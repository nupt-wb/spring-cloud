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
//@DefaultProperties(defaultFallback = "commonFallBack")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/hystrix/ok")
    public String ok(){
        return paymentFeignService.ok();
    }
//
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "800")
//    })
 //   @HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/error/{id}")
    public String error(@PathVariable("id") Long id){
        //int i =0 / 0;
        return paymentFeignService.error(id);
    }

    public String errorFallBack(Long id){
        return Thread.currentThread().getName()+"调用支付服务异常，请稍候重试"+ UUID.randomUUID().toString()+"  id:"+id;
    }

    public String commonFallBack(){
        return "this is common error fall back ";
    }



}
