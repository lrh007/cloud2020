package com.lrh.cloud.mapper;

import com.lrh.cloud.beans.Payment;

/**
 * 支付mapper
 */
public interface PaymentMapper02 {
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
