package com.lrh.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id;
    }

    /**
     * 超时访问，使用@HystrixCommand实现服务降级,超过3秒就调用服务降级处理方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int a = 1/0;
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id;
    }

    /**
     * 服务降级处理方法
     * @param id
     * @return
     */
    private String paymentInfo_TimeOut_handler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" 系统繁忙或者运行报错，请稍后再试,id: "+id+"，/(ㄒoㄒ)/~~";
    }


/*下面是服务熔断内容*/

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数，此属性在滚动窗口中设置将使电路跳闸的最小请求数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期，此属性设置电路跳闸后拒绝请求的时间，然后允许再次尝试确定电路是否应再次闭合
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//此属性设置错误百分比，电路应在该百分比或以上跳闸，并开始对回退逻辑进行短路请求
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw  new RuntimeException("id 不能为负数");
        }
        return Thread.currentThread().getName()+",调用成功，流水号："+ UUID.randomUUID().toString();
    }

    /**
     * 熔断处理方法
     * @param id
     * @return
     */
    private String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数，请稍后再试，/(ㄒoㄒ)/~~ id: "+id;
    }


}
