package com.atguigu.springcloud.controller;

import com.atguigu.lb.LoadBalance;
import com.atguigu.lb.MyLB;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private final String PAYMENT_URL ="http://localhost:8001";
    private final String EUREKA_PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalance loadBalance;
    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){

       // return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        return restTemplate.postForObject(EUREKA_PAYMENT_URL+"/payment/create",payment,CommonResult.class);

    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
       // return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        return restTemplate.getForObject(EUREKA_PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

    }

    @GetMapping(value = "/consumer/payment/lb")
    public CommonResult getLb(){

        ServiceInstance serviceInstance = loadBalance.getServiceInstance(discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE"));
        if(serviceInstance == null){
            return new CommonResult(444,"error",null);
        }
        String invokeUrl = serviceInstance.getUri()+"/payment/get/11";
        return restTemplate.getForObject(invokeUrl,CommonResult.class);

    }
}
