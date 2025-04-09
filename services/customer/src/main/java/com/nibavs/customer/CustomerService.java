package com.nibavs.customer;

import com.nibavs.ampq.NotificationRequest;
import com.nibavs.ampq.RabbitMqMessageProducer;
import com.nibavs.customer.fraud.FraudCheckResponse;
import com.nibavs.customer.fraud.FraudClient;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository, FraudClient fraudClient,
                              RabbitMqMessageProducer rabbitMqMessageProducer) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();
        // todo: check if email is valid
        // todo: check if email is not taken

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, you have been registered in Microservices-basic!", customer.getFirstName())
        );

        rabbitMqMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
