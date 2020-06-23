package com.lrh.cloud.controller;

import com.lrh.cloud.beans.CommonResult;
import com.lrh.cloud.beans.Payment;
import com.lrh.cloud.lb.MyLoadBnlancerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public RestTemplate restTemplate;
    //通过http地址调用服务
//    private static final String URL_PREFIX = "http://localhost:8001";
    //通过zookeeper调用服务，这里只写服务名即可
//    private static final String URL_PREFIX = "cloud-payment-server";
    //通过eureka调用服务
    private static final String URL_PREFIX = "http://CLOUD-PAYMENT-SERVER";

    @Autowired
    public MyLoadBnlancerImpl loadBnlancer;
    @Autowired
    public DiscoveryClient discoveryClient;

    /**@Autowired
    private DiscoveryClient discoveryClient;

    //通过zookeeper服务器发现指定服务名称对应的服务提供者信息
    public String getUrlPrefix() {
        List<ServiceInstance> list = discoveryClient.getInstances(URL_PREFIX);
        if (list != null && list.size() > 0 ) {
          return list.get(0).getUri().toString();
        }
        return null;
    }*/

    /**
     * 添加数据
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/addPayment")
    public CommonResult<Payment> addPayment(Payment payment) {
        return restTemplate.postForObject(URL_PREFIX+"/payment/addPayment",payment,CommonResult.class);
    }

    /**
     * 查询数据
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Integer id){
        return restTemplate.getForObject(URL_PREFIX+"/payment/getPayment/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/payment/lb")
    public String getServerPort(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        if(instances.size()>0){
            ServiceInstance instances1 = loadBnlancer.instances(instances);
            return instances1.getUri().toString();
        }
        return "error";
    }
}
