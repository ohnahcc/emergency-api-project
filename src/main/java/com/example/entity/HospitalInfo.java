package com.example.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class HospitalInfo {

    @Id
    @Column(name = "hpid")
    private String hpid;

    @Column(name = "dutyname")
    private String dutyName;

    @Column(name = "dutyaddr")
    private String dutyAddr;

    @Column(name = "dutyemcls")
    private String dutyEmcls;

    @Column(name = "dutyemclsname")
    private String dutyEmclsName;

    @Column(name = "wgs84lon")
    private Double wgs84Lon;

    @Column(name = "wgs84lat")
    private Double wgs84Lat;
}

