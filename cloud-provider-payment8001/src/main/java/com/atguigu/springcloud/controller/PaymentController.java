package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.Payment8001Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {

    @Resource
    private Payment8001Service paymentService;


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

    @GetMapping(value = "/payment/feign/timeout")
    public String timeout(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
