package com.lrh.cloud.controller;

import com.lrh.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


//使用全局默认的降级处理方式，如果@HystrixCommand中没有指定对应的处理方法，那么就使用全局的降级处理方法
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
@RestController
public class OrderController {
    @Autowired
    public PaymentService paymentService;


    /**
     * 正常访问
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        return paymentService.paymentInfo_OK(id);
    }
    /**
     * 超时访问,客户端进行服务降级
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @HystrixCommand //这里没有指定使用特定的处理方法，所以使用全局的降级处理方法
    public String paymentInfo_TimeOut(@PathVariable Integer id){
        int a = 1/0;
        return paymentService.paymentInfo_TimeOut(id);
    }

    /**
     * 服务降级处理方法
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut_handler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"我是80消费者，对方系统繁忙或者运行报错，请稍后再试,id: "+id+"，/(ㄒoㄒ)/~~";
    }

    /**
     * 全局降级处理方法
     * @return
     */
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试/(ㄒoㄒ)/~~";
    }

}
