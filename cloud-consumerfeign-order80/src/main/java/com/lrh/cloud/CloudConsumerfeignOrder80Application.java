package com.lrh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //开启使用openFeign功能
@SpringBootApplication
public class CloudConsumerfeignOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerfeignOrder80Application.class, args);
    }

}
