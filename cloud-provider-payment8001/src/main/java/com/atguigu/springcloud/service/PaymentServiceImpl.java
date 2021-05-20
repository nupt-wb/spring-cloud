package com.atguigu.springcloud.service;


import com.atguigu.springcloud.dao.Payment8001Dao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements Payment8001Service{

    @Resource
    private Payment8001Dao payment8001Dao;

    @Override
    public int create(Payment payment) {
        return payment8001Dao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return payment8001Dao.getPaymentById(id);
    }
}
