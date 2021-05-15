package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class PaymentHystrixMain8007 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8007.class,args);
    }
}
