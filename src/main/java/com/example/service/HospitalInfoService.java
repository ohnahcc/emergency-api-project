package com.example.service;

import com.example.entity.HospitalInfo;
import com.example.repository.HospitalInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalInfoService {

    private final HospitalInfoRepository repository;

    public HospitalInfoService(HospitalInfoRepository repository) {
        this.repository = repository;
    }

    public void save(HospitalInfo hospitalInfo) {
        repository.save(hospitalInfo);
    }
}

