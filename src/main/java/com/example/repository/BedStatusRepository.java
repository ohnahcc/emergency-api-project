package com.example.repository;

import com.example.entity.BedStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedStatusRepository extends JpaRepository<BedStatus, String> {
}

