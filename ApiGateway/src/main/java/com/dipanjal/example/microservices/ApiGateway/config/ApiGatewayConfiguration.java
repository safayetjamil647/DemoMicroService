package com.dipanjal.example.microservices.ApiGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dipanjal
 * @since 6/28/2021
 */

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(RouteDefinitions.ROUTE_GET)
                .route(RouteDefinitions.ROUTE_CURRENCY_EXCHANGE)
                .route(RouteDefinitions.ROUTE_CURRENCY_CONVERSION)
//                .route(RouteDefinitions.MAPPED_ROUTE_CURRENCY_CONVERSION_NEW)
                .build();
    }
}
