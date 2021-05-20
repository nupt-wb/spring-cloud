package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentFeignService {
    @Override
    public String ok() {
        return "PaymentFallbackService ok fallback";
    }

    @Override
    public String error(Long id) {
        return "PaymentFallbackService error fallback";
    }
}
