package com.nibavs.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
        String customerUri = uriConfiguration.getCustomersUri();

        return builder.routes()
                .route(r -> r
                        .path("/api/v1/customers/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("customerCircuitBreaker")
                                .setFallbackUri("forward:/fallback")))
                        .uri(customerUri))
                .build();
    }


}


