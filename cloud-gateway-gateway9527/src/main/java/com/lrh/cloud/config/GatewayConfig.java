package com.lrh.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由的编码配置，不推荐
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置了一个id为route-name的路由规则，
     * 当访问地址http://localhost:9527/guonei 时会自动转发到地址： http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_lrh",
                r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
