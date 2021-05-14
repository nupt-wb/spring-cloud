package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);

        if(result > 0){
            return new CommonResult(200,"数据库插入数据成功"+serverPort,result);
        }else {
            return new CommonResult(444,"数据库插入数据失败"+serverPort,result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment result = paymentService.getPaymentById(id);

        if(result != null){
            return new CommonResult(200,"数据库查询成功"+serverPort,result);
        }else {
            return new CommonResult(444,"数据库查询数据失败"+serverPort,null);
        }
    }
}
