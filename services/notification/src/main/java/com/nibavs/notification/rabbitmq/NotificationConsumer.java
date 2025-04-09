package com.nibavs.notification.rabbitmq;


import com.nibavs.ampq.NotificationRequest;
import com.nibavs.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consume(NotificationRequest notificationRequest) {
        log.info("Received notification: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
