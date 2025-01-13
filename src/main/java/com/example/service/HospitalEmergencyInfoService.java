package com.example.service;

import com.example.entity.HospitalEmergencyInfo;
import com.example.repository.HospitalEmergencyInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalEmergencyInfoService {
    private final HospitalEmergencyInfoRepository repository;

    public HospitalEmergencyInfoService(HospitalEmergencyInfoRepository repository) {
        this.repository = repository;
    }

    public void save(HospitalEmergencyInfo emergencyInfo) {
        repository.save(emergencyInfo);
    }
}

