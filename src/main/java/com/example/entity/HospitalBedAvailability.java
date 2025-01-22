package com.example.entity;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "hospital_bed_availability_local")
public class HospitalBedAvailability {

    @Id
    @Column(name = "hospital_id")
    private String hospitalId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "hospital_id", referencedColumnName = "hpid", nullable = false)
    private Hospitals hospital;

    @Column(name = "hvec")
    private Integer hvec;  // 응급실 일반 병상 수

    @Column(name = "hvoc")
    private Integer hvoc;  // 수술실 병상 수

    @Column(name = "hvcc")
    private Integer hvcc;  // 신경과 중환자실 병상 수

    @Column(name = "hvncc")
    private Integer hvncc; // 신생아 중환자실 병상 수

    @Column(name = "hvccc")
    private Integer hvccc; // 흉부외과 중환자실 병상 수

    @Column(name = "hvicc")
    private Integer hvicc; // 일반 중환자실 병상 수

    @Column(name = "hvgc")
    private Integer hvgc;  // 일반 입원실 병상 수

    @Column(name = "hv2")
    private Integer hv2;   // 내과 중환자실 병상 수

    @Column(name = "hv3")
    private Integer hv3;   // 외과 중환자실 병상 수

    @Column(name = "hv4")
    private Integer hv4;   // 정형외과 입원실 병상 수

    @Column(name = "hv5")
    private Boolean hv5;   // 신경과 입원실 가용 여부

    @Column(name = "hv6")
    private Integer hv6;   // 신경외과 중환자실 병상 수

    @Column(name = "hv7")
    private Boolean hv7;   // 약물 중환자실 가용 여부

    @Column(name = "hv8")
    private Integer hv8;   // 화상 중환자실 병상 수

    @Column(name = "hv9")
    private Integer hv9;   // 외상 중환자실 병상 수

    @Column(name = "hv10")
    private Boolean hv10;  // 소아용 VENTI 가용 여부

    @Column(name = "hv11")
    private Boolean hv11;  // 인큐베이터 가용 여부

    @Column(name = "hv13")
    private Integer hv13;  // 격리진료구역 음격리병상

    @Column(name = "hv14")
    private Integer hv14;  // 격리진료구역 일반격리병상

    @Column(name = "hv15")
    private Integer hv15;  // 소아 음압격리

    @Column(name = "hv16")
    private Integer hv16;  // 소아 일반격리

    @Column(name = "hv17")
    private Integer hv17;  // 음압격리 중환자실(응급전용)

    @Column(name = "hv18")
    private Integer hv18;  // 일반격리 중환자실(응급전용)

    @Column(name = "hv19")
    private Integer hv19;  // 음압격리 입원실(응급전용)

    @Column(name = "hv21")
    private Integer hv21;  // 일반격리 입원실(응급전용)

    @Column(name = "hv22")
    private Integer hv22;  // 감염병 전담병상 중환자실

    @Column(name = "hv23")
    private Integer hv23;  // 감염병 전담병상 중환자실 내 음압격리병상

    @Column(name = "hv24")
    private Integer hv24;  // 감염 중증 병상

    @Column(name = "hv25")
    private Integer hv25;  // 감염 준-중증 병상

    @Column(name = "hv26")
    private Integer hv26;  // 감염 중등증 병상

    @Column(name = "hv27")
    private Integer hv27;  // 코호트 격리 병상

    @Column(name = "hv28")
    private Integer hv28;  // 소아 병상

    @Column(name = "hv29")
    private Integer hv29;  // 응급실 음압 격리 병상

    @Column(name = "hv30")
    private Integer hv30;  // 응급실 일반 격리 병상

    @Column(name = "hv31")
    private Integer hv31;  // 중환자실(응급전용)

    @Column(name = "hv32")
    private Integer hv32;  // 소아 중환자실

    @Column(name = "hv33")
    private Integer hv33;  // 소아 중환자실(응급전용)

    @Column(name = "hv34")
    private Integer hv34;  // 심장내과 중환자실

    @Column(name = "hv35")
    private Integer hv35;  // 음압격리 중환자실

    @Column(name = "hv36")
    private Integer hv36;  // 입원실(응급전용)

    @Column(name = "hv37")
    private Integer hv37;  // 소아 입원실(응급전용)

    @Column(name = "hv38")
    private Integer hv38;  // 외상 전용 입원실

    @Column(name = "hv39")
    private Integer hv39;  // 외상 전용 수술실

    @Column(name = "hv40")
    private Integer hv40;  // 정신과 폐쇄 병동

    @Column(name = "hv41")
    private Integer hv41;  // 음압격리 입원실

    @Column(name = "hv42")
    private Boolean hv42;  // 분만실 가용 여부

    @Column(name = "hv43")
    private Boolean hv43;  // 화상 전용 처치실 가용 여부

    @Column(name = "hvctayn")
    private Boolean hvctayn;      // CT 가용 여부

    @Column(name = "hvmriayn")
    private Boolean hvmriayn;     // MRI 가용 여부

    @Column(name = "hvangioayn")
    private Boolean hvangioayn;   // 혈관촬영기 가용 여부

    @Column(name = "hvventiayn")
    private Boolean hvventiayn;   // 인공호흡기 가용 여부

    @Column(name = "hvventisoayn")
    private Boolean hvventisoayn; // 조산아용 인공호흡기 가용 여부

    @Column(name = "hvincuayn")
    private Boolean hvincuayn;    // 인큐베이터 가용 여부

    @Column(name = "hvcrrtayn")
    private Boolean hvcrrtayn;    // CRRT 가용 여부

    @Column(name = "hvecmoayn")
    private Boolean hvecmoayn;    // ECMO 가용 여부

    @Column(name = "hvoxyayn")
    private Boolean hvoxyayn;     // 고압산소치료기 가용 여부

    @Column(name = "hvhypoayn")
    private Boolean hvhypoayn;    // 중심체온조절유도기 가용 여부

    @Column(name = "hvamyn")
    private Boolean hvamyn;       // 구급차 가용 여부

    @Column(name = "hvs01")
    private Integer hvs01; // 일반 병상 기준

    @Column(name = "hvs03")
    private Integer hvs03; // 응급실 음압 격리 병상 기준

    @Column(name = "hvs04")
    private Integer hvs04; // 응급실 일반 격리 병상 기준

    @Column(name = "hvs05")
    private Integer hvs05; // 응급전용 중환자실 기준

    @Column(name = "hvs06")
    private Integer hvs06; // 내과 중환자실 기준

    @Column(name = "hvs07")
    private Integer hvs07; // 외과 중환자실 기준

    @Column(name = "hvs08")
    private Integer hvs08; // 신생아 중환자실 기준

    @Column(name = "hvs09")
    private Integer hvs09; // 소아 중환자실 기준

    @Column(name = "hvs10")
    private Integer hvs10; // 응급전용 소아중환자실 기준

    @Column(name = "hvs11")
    private Integer hvs11; // 신경과 중환자실 기준

    @Column(name = "hvs12")
    private Integer hvs12; // 신경외과 중환자실 기준

    @Column(name = "hvs13")
    private Integer hvs13; // 화상 중환자실 기준

    @Column(name = "hvs14")
    private Integer hvs14; // 외상 중환자실 기준

    @Column(name = "hvs15")
    private Integer hvs15; // 심장내과 중환자실 기준

    @Column(name = "hvs16")
    private Integer hvs16; // 흉부외과 중환자실 기준

    @Column(name = "hvs17")
    private Integer hvs17; // 일반 중환자실 기준

    @Column(name = "hvs18")
    private Integer hvs18; // 음압격리 중환자실 기준

    @Column(name = "hvs19")
    private Integer hvs19; // 응급전용 입원실 기준

    @Column(name = "hvs20")
    private Integer hvs20; // 응급전용 소아입원실 기준

    @Column(name = "hvs21")
    private Integer hvs21; // 외상전용 입원실 기준

    @Column(name = "hvs22")
    private Integer hvs22; // 수술실 기준

    @Column(name = "hvs23")
    private Integer hvs23; // 외상전용 수술실 기준

    @Column(name = "hvs25")
    private Integer hvs25; // 음압격리 입원실 기준

    @Column(name = "hvs46")
    private Integer hvs46; // 격리진료구역 음압 격리 병상 기준

    @Column(name = "hvs47")
    private Integer hvs47; // 격리진료구역 일반 격리 병상 기준

    @Column(name = "hvs48")
    private Integer hvs48; // 소아 음압 격리 기준

    @Column(name = "hvs49")
    private Integer hvs49; // 소아 일반 격리 기준

    @Column(name = "hvs50")
    private Integer hvs50; // 응급전용 중환자실 음압 격리 기준

    @Column(name = "hvs51")
    private Integer hvs51; // 응급전용 중환자실 일반 격리 기준

    @Column(name = "hvs52")
    private Integer hvs52; // 응급전용 입원실 음압 격리 기준

    @Column(name = "hvs53")
    private Integer hvs53; // 응급전용 입원실 일반 격리 기준

    @Column(name = "hvs54")
    private Integer hvs54; // 감염병 전담병상 중환자실 기준

    @Column(name = "hvs55")
    private Integer hvs55; // 감염병 전담병상 중환자실 내 음압 격리 기준

    @Column(name = "hvs56")
    private Integer hvs56; // 감염 중증 병상 기준

    @Column(name = "hvs57")
    private Integer hvs57; // 감염 준-중증 병상 기준

    @Column(name = "hvs58")
    private Integer hvs58; // 감염 중등증 병상 기준

    @Column(name = "hvs59")
    private Integer hvs59; // 코호트 격리 기준

    @Column(name = "hvidate")
    private String hvidate; // 병상 정보 업데이트 시간

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now(); // 데이터 수정 시간

}





