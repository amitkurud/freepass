package com.amitkurud.coreconfig.web.rest;

import com.amitkurud.coreconfig.service.CoreconfigmsKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/coreconfigms-kafka")
public class CoreconfigmsKafkaResource {

    private final Logger log = LoggerFactory.getLogger(CoreconfigmsKafkaResource.class);

    private CoreconfigmsKafkaProducer kafkaProducer;

    public CoreconfigmsKafkaResource(CoreconfigmsKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
