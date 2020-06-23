package com.lrh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker //开启hystrix断路器
@EnableFeignClients //开启使用openFeign功能
@EnableEurekaClient //开启eureka
@SpringBootApplication
public class CloudConsumerFeignHystrixOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignHystrixOrder80.class,args);
    }
}
