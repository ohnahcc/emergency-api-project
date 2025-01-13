package com.example.service;

import com.example.entity.Hospitals;
import com.example.repository.HospitalsRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalsService {
    private final HospitalsRepository repository;

    public HospitalsService(HospitalsRepository repository) {
        this.repository = repository;
    }

    public Hospitals save(Hospitals hospital) {
        return repository.save(hospital);
    }

    public Hospitals findByHpid(String hpid) {
        return repository.findByHpid(hpid);
    }
}

