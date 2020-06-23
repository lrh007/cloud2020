package com.lrh.cloud.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 自定义网关过滤器
 */
@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(MyLogGateWayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("进入自定义网关日志过滤器：{}",new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            logger.info("用户名为null,非法用户，/(ㄒoㄒ)/~~");
            //返回状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 过滤器加载顺序，值越小，越先加载
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
