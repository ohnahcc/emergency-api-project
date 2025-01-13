package com.example.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class HospitalEmergencyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId; // 기본 키 (Primary Key)

    @Column(nullable = false)
    private String dutyAddr; // 병원 주소

    @Column(nullable = false)
    private String dutyEmcls; // 응급의료기관 분류 코드 (e.g., G001, G006)

    @Column(nullable = false)
    private String dutyEmclsName; // 응급의료기관 분류명 (e.g., 권역응급의료센터)

    @Column(nullable = false)
    private Double wgs84Lon; // 경도

    @Column(nullable = false)
    private Double wgs84Lat; // 위도
}

