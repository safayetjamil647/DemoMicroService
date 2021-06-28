package com.dipanjal.example.microservices.ApiGateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

import java.util.function.Function;

/**
 * @author dipanjal
 * @since 6/28/2021
 */

public class RouteDefinitions {

    private RouteDefinitions(){}

    public static final Function<PredicateSpec, Buildable<Route>> ROUTE_GET;
    public static final Function<PredicateSpec, Buildable<Route>> ROUTE_CURRENCY_EXCHANGE;
    public static final Function<PredicateSpec, Buildable<Route>> ROUTE_CURRENCY_CONVERSION;
    public static final Function<PredicateSpec, Buildable<Route>> MAPPED_ROUTE_CURRENCY_CONVERSION_NEW;


    static {
        ROUTE_GET = p -> p.path("/get")
                .filters(f -> f
                        .addRequestHeader("My-Header", "MyHeaderValue")
                        .addRequestParameter("My-Param", "MyParamValue"))
                .uri("http://httpbin.org:80");

        ROUTE_CURRENCY_EXCHANGE = p -> p.path("/currency-exchange/**")
                .uri("lb://currency-exchange");

        ROUTE_CURRENCY_CONVERSION = p -> p.path("/currency-conversion/**")
                .uri("lb://currency-conversion");

        MAPPED_ROUTE_CURRENCY_CONVERSION_NEW = p -> p.path("/currency-conversion-new/**")
                .filters(f -> f.rewritePath(
                        "/currency-conversion-new/(?<segment>.*)",
                        "/currency-conversion/${segment}"))
                .uri("lb://currency-conversion");
    }

}
