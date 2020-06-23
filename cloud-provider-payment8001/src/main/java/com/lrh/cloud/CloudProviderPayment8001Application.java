package com.lrh.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //启用eureka客户端
@MapperScan
//@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@SpringBootApplication
public class CloudProviderPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8001Application.class, args);
    }

}
