package com.paywallsys.transaction_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionEventPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "transaction-topic";

    public void publish(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Published event to Kafka: " + message);
    }
}
