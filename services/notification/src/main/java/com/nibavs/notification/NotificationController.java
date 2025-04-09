package com.nibavs.notification;

import com.nibavs.ampq.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notifications")
@Slf4j
public record NotificationController(NotificationService notificationService) {
    @PostMapping
    public ResponseEntity<String> sentNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("Sent notification request: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
        return ResponseEntity.ok("Notification sent");
    }
}
