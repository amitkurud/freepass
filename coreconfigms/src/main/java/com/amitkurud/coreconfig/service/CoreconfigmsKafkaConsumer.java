package com.amitkurud.coreconfig.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CoreconfigmsKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(CoreconfigmsKafkaConsumer.class);
    private static final String TOPIC = "topic_coreconfigms";

    @KafkaListener(topics = "topic_coreconfigms", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
