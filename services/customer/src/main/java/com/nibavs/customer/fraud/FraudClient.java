package com.nibavs.customer.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FRAUD", path = "api/v1/fraud-check", fallback = FraudClientFallback.class)
@Primary // not sure about thiss
public interface FraudClient {
    @GetMapping("/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId);
}
