package com.example.service;

import com.example.entity.BedStatus;
import com.example.repository.BedStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class BedStatusService {

    private final BedStatusRepository repository;

    public BedStatusService(BedStatusRepository repository) {
        this.repository = repository;
    }

    public void save(BedStatus bedStatus) {
        repository.save(bedStatus);
    }
}

