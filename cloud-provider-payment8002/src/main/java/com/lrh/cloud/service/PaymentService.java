package com.lrh.cloud.service;

import com.lrh.cloud.beans.Payment;

public interface PaymentService {
    /**
     * 添加数据
     * @param payment
     * @return
     */
    int addPayment(Payment payment);

    /**
     * 查询数据
     * @param id
     * @return
     */
    Payment getPayment(Integer id);
}
