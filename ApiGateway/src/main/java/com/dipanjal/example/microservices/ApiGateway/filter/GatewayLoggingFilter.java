package com.dipanjal.example.microservices.ApiGateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author dipanjal
 * @since 6/28/2021
 */

@Slf4j
@Component
public class GatewayLoggingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Path of the request received -> {}", exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
