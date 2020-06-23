package com.lrh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerconsulOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerconsulOrder80Application.class, args);
    }

}
