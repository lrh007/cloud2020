package com.lrh.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableCircuitBreaker   //开启hystrix断路器
@EnableDiscoveryClient  //开启eureka客户端
@SpringBootApplication
public class CloudProviderHystrixPayment8004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8004Application.class, args);
    }

    /**
     * 此配置是为了服务监控而配置，和服务容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean 因为springboot默认的路径不是”/hystrix.stream“,
     * 只要在自己的项目里配置上下文的servlet就行了
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return  registrationBean;
    }

}
