package com.example.repository;

import com.example.entity.HospitalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalInfoRepository extends JpaRepository<HospitalInfo, String> {
}

