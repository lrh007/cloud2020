package com.lrh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaServer7003Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7003Application.class, args);
    }

}
