package com.amitkurud.coreconfig.web.rest;

import com.amitkurud.coreconfig.CoreconfigmsApp;
import com.amitkurud.coreconfig.service.CoreconfigmsKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = CoreconfigmsApp.class)
public class CoreconfigmsKafkaResourceIT {

    @Autowired
    private CoreconfigmsKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        CoreconfigmsKafkaResource kafkaResource = new CoreconfigmsKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/coreconfigms-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
