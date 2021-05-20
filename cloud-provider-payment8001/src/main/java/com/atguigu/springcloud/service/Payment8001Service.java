package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface Payment8001Service {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
