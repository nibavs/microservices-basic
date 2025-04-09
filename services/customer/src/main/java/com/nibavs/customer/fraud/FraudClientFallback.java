package com.nibavs.customer.fraud;

import org.springframework.stereotype.Component;

@Component
public class FraudClientFallback implements FraudClient {
    @Override
    public FraudCheckResponse isFraudster(Long customerId) {
        return new FraudCheckResponse(false);
    }
}
