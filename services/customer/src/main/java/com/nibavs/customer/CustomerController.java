package com.nibavs.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    @GetMapping
    public String getCustomers() {
        return "Customers";
    }

    @PostMapping
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        customerService.registerCustomer(customerRegistrationRequest);
        log.info("New customer registration: {}", customerRegistrationRequest);
        return ResponseEntity.ok("Customer created");
    }
}
