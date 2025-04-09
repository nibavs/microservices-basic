package com.nibavs.apigw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ApiGatewayController {
    @GetMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("Customer service is unavailable. Try again later.");
    }

    @PostMapping("/fallback")
    public Mono<String> fallbackPost() {
        return Mono.just("Customer service is unavailable. Try again later.");
    }
}
