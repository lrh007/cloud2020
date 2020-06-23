package com.lrh.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced //添加ribbon客户端负载均衡,这个注解一定不能少，否则发现不了服务，会报异常
    public RestTemplate restTemplate(){
       return new RestTemplate();
    }
}
