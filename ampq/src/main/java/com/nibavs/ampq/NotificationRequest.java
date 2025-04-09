package com.nibavs.ampq;

public record NotificationRequest(Long customerId, String customerEmail, String message) {}
