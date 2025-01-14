package com.example.entity;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class BedStatus {

    @Id
    @Column(name = "hpid")
    private String hpid;

    @Column(name = "hvidate")
    private LocalDateTime hvidate;

    @Column(name = "hvec")
    private Integer hvec;

    @Column(name = "hvcc")
    private Integer hvcc;

    @Column(name = "hvncc")
    private Integer hvncc;

    @Column(name = "hvccc")
    private Integer hvccc;

    @Column(name = "hvicc")
    private Integer hvicc;

    @Column(name = "hvgc")
    private Integer hvgc;

    @Column(name = "dutyname")
    private String dutyName;

    @Column(name = "dutytel3")
    private String dutyTel3;
}

