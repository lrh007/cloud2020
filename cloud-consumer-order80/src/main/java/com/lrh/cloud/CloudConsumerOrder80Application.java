package com.lrh.cloud;

import com.lrh.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


//CLOUD-PAYMENT-SERVER 这个微服务使用指定的负载均衡算法
@RibbonClient(name ="CLOUD-PAYMENT-SERVER",configuration = MySelfRule.class)
@EnableEurekaClient
//@EnableDiscoveryClient ////该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@SpringBootApplication
public class CloudConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80Application.class, args);
    }

}
