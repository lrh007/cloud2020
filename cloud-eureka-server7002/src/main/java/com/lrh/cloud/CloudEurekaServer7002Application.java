package com.lrh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaServer7002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7002Application.class, args);
    }

}
