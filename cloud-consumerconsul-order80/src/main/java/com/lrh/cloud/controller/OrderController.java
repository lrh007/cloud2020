package com.lrh.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://cloud-payment-server";

    @GetMapping("/consumer/payment/consul")
    public String paymentConsul(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }

}
