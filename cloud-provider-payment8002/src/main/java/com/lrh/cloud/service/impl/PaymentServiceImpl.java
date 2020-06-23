package com.lrh.cloud.service.impl;

import com.lrh.cloud.beans.Payment;
import com.lrh.cloud.mapper.PaymentMapper02;
import com.lrh.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("paymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper02 paymentMapper;

    @Override
    public int addPayment(Payment payment) {
        return paymentMapper.addPayment(payment);
    }

    @Override
    public Payment getPayment(Integer id) {
        return paymentMapper.getPayment(id);
    }
}
