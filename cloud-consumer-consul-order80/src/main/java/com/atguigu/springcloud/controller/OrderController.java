package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private String INVOKE_URL="http://cloud-provider-service-consul";


    @GetMapping(value = "/consumer/payment/consul")
    public String get(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }

}
