package com.example.repository;

import com.example.entity.HospitalEmergencyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalEmergencyInfoRepository extends JpaRepository<HospitalEmergencyInfo, Long> {
}

