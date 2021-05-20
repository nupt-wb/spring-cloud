package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
@FeignClient(value = "CLOUd-pROVIDER-SERVICE-HYSTRIX",fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping(value = "/payment/hystrix/ok")
    public String ok();

    @GetMapping(value = "/payment/hystrix/error/{id}")
    public String error(@PathVariable("id") Long id);


}
