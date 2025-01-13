package com.example.service;

import com.example.entity.HospitalBedAvailability;
import com.example.repository.HospitalBedAvailabilityRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalBedAvailabilityService {
    private final HospitalBedAvailabilityRepository repository;

    public HospitalBedAvailabilityService(HospitalBedAvailabilityRepository repository) {
        this.repository = repository;
    }

    public void save(HospitalBedAvailability availability) {
        repository.save(availability);
    }
}

