package com.nibavs.apigw;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class UriConfiguration {
    private String customersUri = "lb://CUSTOMER";
}
