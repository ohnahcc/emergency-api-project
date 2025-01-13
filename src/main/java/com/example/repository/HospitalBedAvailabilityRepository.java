package com.example.repository;

import com.example.entity.HospitalBedAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalBedAvailabilityRepository extends JpaRepository<HospitalBedAvailability, Long> {
}

