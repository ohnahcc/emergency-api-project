package com.example.entity;

import javax.persistence.*;

import com.example.entity.Hospitals;
import lombok.Data;

@Entity
@Data
public class HospitalEmergencyInfo {

    @Id
    @Column(name = "info_id")
    private Long infoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "info_id", referencedColumnName = "id")
    private Hospitals hospital;

    @Column(name = "dutyaddr", nullable = false)
    private String dutyAddr; // 병원 주소

    @Column(name = "dutyemcls", nullable = false)
    private String dutyEmcls; // 응급 의료 분류

    @Column(name = "dutyemclsname", nullable = false)
    private String dutyEmclsName; // 응급 의료 분류 이름

    @Column(name = "wgs84lon", nullable = false)
    private Double wgs84Lon; // 경도

    @Column(name = "wgs84lat", nullable = false)
    private Double wgs84Lat; // 위도
}




