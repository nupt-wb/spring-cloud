package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
@FeignClient(value = "CLOUd-pROVIDER-SERVICE-HYSTRIX")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/hystrix/ok")
    public String ok();

    @GetMapping(value = "/payment/hystrix/error/{id}")
    public String error(@PathVariable("id") Long id);


}
