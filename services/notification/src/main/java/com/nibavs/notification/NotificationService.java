package com.nibavs.notification;

import com.nibavs.ampq.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest) {
        notificationRepository.save(Notification.builder()
                .toCustomerId(notificationRequest.customerId())
                .toCustomerEmail(notificationRequest.customerEmail())
                .sender("Nibavs")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build());
    }
}
