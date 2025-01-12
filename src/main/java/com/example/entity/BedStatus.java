package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class BedStatus {

    @Id
    private String hpid; // 병원 ID를 Primary Key로 설정

    private LocalDateTime hvidate;
    private Integer hvec;
    private Integer hvcc;
    private Integer hvncc;
    private Integer hvccc;
    private Integer hvicc;
    private Integer hvgc;
    private String dutyname;
    private String dutyTel3;
}

