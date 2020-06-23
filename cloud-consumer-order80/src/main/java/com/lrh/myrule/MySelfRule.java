package com.lrh.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon客户端负载均衡算法
 */
@Configuration
public class MySelfRule {

    /**
     * 自定义ribbon负载均衡算法
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
