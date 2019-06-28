package com.amitkurud.iam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IamKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(IamKafkaConsumer.class);
    private static final String TOPIC = "topic_iam";

    @KafkaListener(topics = "topic_iam", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
