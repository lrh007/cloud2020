package com.lrh.cloud.controller;

import com.lrh.cloud.beans.CommonResult;
import com.lrh.cloud.beans.Payment;
import com.lrh.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {



    @Autowired
    public PaymentFeignService paymentFeignService;

    /**
     * 添加数据
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/addPayment")
    public CommonResult<Payment> addPayment(Payment payment) {
        return paymentFeignService.addPayment(payment);
    }

    /**
     * 查询数据
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Integer id){
        return paymentFeignService.getPayment(id);
    }

    /**
     * 测试feign超时控制
     * @return
     */
    @GetMapping("/consumer/payment/timeout")
    public String timeout(){
        return paymentFeignService.timeout();
    }
}
