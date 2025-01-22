package com.example.service;

import com.example.entity.HospitalBedAvailability;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendHospitalData(HospitalBedAvailability data) {
        kafkaTemplate.send("hospital-bed-availability", data.getHospitalId(), data);
    }
}

