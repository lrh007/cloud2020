package com.lrh.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义ribbon负载均衡算法
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
