package com.lrh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //发现consul注册中心
@SpringBootApplication
public class CloudProviderconsulPayment8003Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderconsulPayment8003Application.class, args);
    }

}
