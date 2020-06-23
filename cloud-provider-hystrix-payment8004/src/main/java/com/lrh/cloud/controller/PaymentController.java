package com.lrh.cloud.controller;

import com.lrh.cloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    public PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    /**
     * 正常访问
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        String result = paymentService.paymentInfo_OK(id);
        logger.info("result: {}",result);
        return result;
    }
    /**
     * 超时访问
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        logger.info("result: {}",result);
        return result;
    }
    /*下面是服务熔断*/

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
