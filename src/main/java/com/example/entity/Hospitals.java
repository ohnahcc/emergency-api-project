package com.example.entity;

import javax.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "hospitals")
public class Hospitals {
    @Id
    @Column(name = "hpid", nullable = false, unique = true) // 기본 키 설정
    private String hpid; // 병원 ID

    @Column(name = "dutyname", nullable = false)
    private String dutyName; // 병원 이름

    @Column(name = "dutytel3")
    private String dutyTel3; // 응급실 전화번호

    @Column(name = "created_at", nullable = false, updatable = false) // 생성 시에만 설정, 수정 불가
    private LocalDateTime createdAt = LocalDateTime.now(); // 레코드 생성 시간
}




