package com.lrh.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 从配置文件中读取信息
 */
@RefreshScope //刷新配置
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    public String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return  configInfo;
    }
}
