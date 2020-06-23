package com.lrh.cloud.service;

import com.lrh.cloud.beans.CommonResult;
import com.lrh.cloud.beans.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * feign 客户端负载均衡，接口+注解
 */
@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVER")
public interface PaymentFeignService {

    /**
     * 添加数据
     * @param payment
     * @return
     */
    @GetMapping("/payment/addPayment")
    public CommonResult<Payment> addPayment(Payment payment);

    /**
     * 查询数据
     * @param id
     * @return
     */
    @GetMapping("/payment/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Integer id);
    /**
     * 测试feign超时控制
     * @return
     */
    @GetMapping("/payment/timeout")
    public String timeout();
}
