package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentCommonService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
