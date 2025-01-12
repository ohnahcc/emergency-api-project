package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HospitalInfo {

    @Id
    private String hpid; // 병원 ID를 Primary Key로 설정

    private String dutyname;
    private String dutyaddr;
    private String dutyemcls;
    private String dutyemclsname;
    private Double wgs84lon;
    private Double wgs84lat;
}

