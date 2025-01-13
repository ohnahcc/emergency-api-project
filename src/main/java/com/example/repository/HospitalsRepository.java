package com.example.repository;

import com.example.entity.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalsRepository extends JpaRepository<Hospitals, Long> {
    Hospitals findByHpid(String hpid);
}

