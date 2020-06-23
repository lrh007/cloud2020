package com.lrh.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现自定义的负载均衡算法，还可以实现AbstractLoadBalancerRule 的choose()方法
 */
@Component
public class MyLoadBnlancerImpl implements LoadBalancer {


    public AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAndIncrement(int serverCount){
        int next = 0;
        int current = 0;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        return (next % serverCount);
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement(serviceInstances.size());
        return serviceInstances.get(index);
    }
}
