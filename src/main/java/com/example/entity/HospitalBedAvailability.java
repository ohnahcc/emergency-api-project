package com.example.entity;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class HospitalBedAvailability {

    @Id
    private Long hospitalId; // 외래 키 (Primary Key)

    @Column(nullable = false, unique = true)
    private String hpid; // 병원 고유 ID (추가됨)

    private Integer hvec; // 응급실 일반 병상
    private Integer hvoc; // 수술실
    private Integer hvcc; // 신경과 중환자실
    private Integer hvncc; // 신생아 중환자실
    private Integer hvccc; // 흉부외과 중환자실
    private Integer hvicc; // 일반 중환자실
    private Integer hvgc; // 일반 입원실

    private String hvidate; // 입력일시

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}


