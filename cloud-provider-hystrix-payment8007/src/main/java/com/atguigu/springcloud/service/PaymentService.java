package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class PaymentService {

    public String ok(){
        return "线程："+Thread.currentThread().getName()+"  "+"ok: "+ UUID.randomUUID().toString();
    }


    @HystrixCommand(fallbackMethod = "errorFallBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String error(Long id,Integer time){
     //   int i = 1/0;
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程："+Thread.currentThread().getName()+"error execute "+UUID.randomUUID().toString()+"id:"+id;
    }

    public String errorFallBack(Long id,Integer time){
        return Thread.currentThread().getName()+ "系统累了，请稍候重试"+UUID.randomUUID().toString()+"id:"+id;
    }


}
