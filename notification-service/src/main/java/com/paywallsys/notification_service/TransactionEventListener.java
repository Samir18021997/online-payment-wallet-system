package com.paywallsys.notification_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionEventListener {

    @KafkaListener(topics = "transaction-topic", groupId = "notification-group")
    public void listen(String message) {
        // Process the incoming message
        System.out.println("Received message: " + message);
        System.out.println("Notification sent to user.");

        // Here you can add logic to handle the transaction event
        // For example, you might want to parse the message and update a database or send a notification
    }
}
