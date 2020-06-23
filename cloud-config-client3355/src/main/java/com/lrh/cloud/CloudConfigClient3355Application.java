package com.lrh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudConfigClient3355Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3355Application.class, args);
    }

}
