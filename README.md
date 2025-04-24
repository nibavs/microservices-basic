# Microservices-basic 🗿

## Description
This project is a simple microservices-usage realization. There are three microservices: customer, fraud, notification. When customer has registered, Feign client sends HTTP request to the fraud service, this service is checking whether customer fraudster or not and sends back appropriate response. After this message about customer registration goes to the notification service via RabbitMQ message broker. Message is saved in PostgreSQL database. All of this connected with eureka server and API Gateway. Docker containers are used as well.

![Structure](./Structure.png)

## Technologies Used

- Eureka server
- Feign Client
- Spring Cloud Gateway
- Docker
- RabbitMq

## Microservices
- Customer 
- Fraud
- Notification




