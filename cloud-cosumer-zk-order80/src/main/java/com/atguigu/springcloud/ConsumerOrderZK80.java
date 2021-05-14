package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderZK80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderZK80.class,args);
    }
}
