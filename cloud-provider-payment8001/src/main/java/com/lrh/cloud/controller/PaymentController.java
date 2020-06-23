package com.lrh.cloud.controller;

import com.lrh.cloud.beans.CommonResult;
import com.lrh.cloud.beans.Payment;
import com.lrh.cloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Resource(name = "paymentServiceImpl")
    public PaymentService paymentService;

    @Value("${server.port}")
    public String serverPort;

    /**
     * 添加数据
     * @param payment
     * @return
     */
    @PostMapping("/payment/addPayment")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment) {
        int i = paymentService.addPayment(payment);
        logger.info("添加结果：{}",i);

        if(i==0){
            return new CommonResult<>(444,"8001-插入数据库失败",null);
        }else{
            return new CommonResult<>(200,"8001-插入数据库成功",payment);
        }
    }

    /**
     * 查询数据
     * @param id
     * @return
     */
    @GetMapping("/payment/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Integer id){
        Payment payment = paymentService.getPayment(id);
        logger.info("查询结果：{}",payment);
        if(payment == null){
            return new CommonResult<>(444,"8001-没有对应记录，查询ID："+id,null);
        }else{
            return new CommonResult<>(200,"8001-查询成功",payment);
        }
    }

    /**
     * 测试自定义负载均衡算法
     * @return
     */
    @GetMapping("/payment/lb")
    public String getServerPort(){
        return serverPort;
    }

    /**
     * 测试feign超时控制
     * @return
     */
    @GetMapping("/payment/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
