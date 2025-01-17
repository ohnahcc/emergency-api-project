package com.example.repository;

import com.example.entity.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HospitalsRepository extends JpaRepository<Hospitals, Long> {
    Optional<Hospitals> findByHpid(String hpid);

    @Modifying
    @Query(value = "INSERT INTO hospitals (" +
            "hpid, dutyName, dutyTel3, created_at) " +
            "VALUES (:hpid, :dutyName, :dutyTel3, NOW()) " +
            "ON CONFLICT (hpid) DO UPDATE SET " +
            "dutyName = EXCLUDED.dutyName, " +
            "dutyTel3 = EXCLUDED.dutyTel3",
            nativeQuery = true)
    void saveOrUpdate(
            @Param("hpid") String hpid,
            @Param("dutyName") String dutyName,
            @Param("dutyTel3") String dutyTel3
    );

}

