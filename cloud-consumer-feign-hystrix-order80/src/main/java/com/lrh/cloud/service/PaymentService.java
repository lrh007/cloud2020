package com.lrh.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 使用feign客户端负载均衡，接口+注解
 */
@FeignClient(name = "cloud-payment-hystrix-server",fallback = PaymentFallbackService.class)
@Component
public interface PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id);
    /**
     * 超时访问
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable Integer id);
}
