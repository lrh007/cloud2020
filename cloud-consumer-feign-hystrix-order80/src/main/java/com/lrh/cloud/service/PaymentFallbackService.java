package com.lrh.cloud.service;

import org.springframework.stereotype.Component;

/**
 * 服务降级处理类，和controll分开
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService--paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService--paymentInfo_TimeOut";
    }
}
