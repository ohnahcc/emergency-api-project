package com.example.secondentity;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "hospital_bed_operation_rate")
public class SecondHospitalBedAvailabilityRate {

    @Id
    @Column(name = "hpid")
    private String hpid;


    @Column(name = "hvec_rate")
    private Integer hvec_rate;
    @Column(name = "hv29_rate")
    private Integer hv29_rate;
    @Column(name = "hv30_rate")
    private Integer hv30_rate;
    @Column(name = "hv31_rate")
    private Integer hv31_rate;
    @Column(name = "hv2_rate")
    private Integer hv2_rate;
    @Column(name = "hv3_rate")
    private Integer hv3_rate;
    @Column(name = "hvncc_rate")
    private Integer hvncc_rate;
    @Column(name = "hv32_rate")
    private Integer hv32_rate;
    @Column(name = "hv33_rate")
    private Integer hv33_rate;
    @Column(name = "hvcc_rate")
    private Integer hvcc_rate;
    @Column(name = "hv6_rate")
    private Integer hv6_rate;
    @Column(name = "hv8_rate")
    private Integer hv8_rate;
    @Column(name = "hv9_rate")
    private Integer hv9_rate;
    @Column(name = "hv34_rate")
    private Integer hv34_rate;
    @Column(name = "hvccc_rate")
    private Integer hvccc_rate;
    @Column(name = "hvicc_rate")
    private Integer hvicc_rate;
    @Column(name = "hv35_rate")
    private Integer hv35_rate;
    @Column(name = "hv19_rate")
    private Integer hv19_rate;
    @Column(name = "hv37_rate")
    private Integer hv37_rate;
    @Column(name = "hv38_rate")
    private Integer hv38_rate;
    @Column(name = "hvoc_rate")
    private Integer hvoc_rate;
    @Column(name = "hv39_rate")
    private Integer hv39_rate;
    @Column(name = "hv41_rate")
    private Integer hv41_rate;
    @Column(name = "hv13_rate")
    private Integer hv13_rate;
    @Column(name = "hv14_rate")
    private Integer hv14_rate;
    @Column(name = "hv15_rate")
    private Integer hv15_rate;
    @Column(name = "hv16_rate")
    private Integer hv16_rate;
    @Column(name = "hv17_rate")
    private Integer hv17_rate;
    @Column(name = "hv18_rate")
    private Integer hv18_rate;
    @Column(name = "hv21_rate")
    private Integer hv21_rate;
    @Column(name = "hv22_rate")
    private Integer hv22_rate;
    @Column(name = "hv23_rate")
    private Integer hv23_rate;
    @Column(name = "hv24_rate")
    private Integer hv24_rate;
    @Column(name = "hv25_rate")
    private Integer hv25_rate;
    @Column(name = "hv26_rate")
    private Integer hv26_rate;
    @Column(name = "hv27_rate")
    private Integer hv27_rate;

    @Column(name = "hvidate")
    private String hvidate; // 병상 정보 업데이트 시간

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now(); // 데이터 수정 시간
}
