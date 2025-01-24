CREATE TABLE hospitals (
    hpid        TEXT   PRIMARY KEY,
    dutyName    TEXT   NOT NULL,
    dutyTel3    TEXT,
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE hospital_bed_availability_local (
    hospital_id  TEXT PRIMARY KEY,
    CONSTRAINT fk_hospital
      FOREIGN KEY (hospital_id)
      REFERENCES hospitals(hpid)
      ON DELETE CASCADE,
    hvec           INT, -- 응급실 일반 병상
    hvoc           INT, -- 수술실
    hvcc           INT, -- 신경과 중환자실
    hvncc          INT, -- 신생아 중환자실
    hvccc          INT, -- 흉부외과 중환자실
    hvicc          INT, -- 일반 중환자실
    hvgc           INT, -- 일반 입원실
    hv2           INT, -- 내과 중환자실
    hv3           INT, -- 외과 중환자실
    hv4           INT, -- 정형외과 입원실
    hv5           BOOLEAN, -- 신경과 입원실
    hv6           INT, -- 신경외과 중환자실
    hv7           BOOLEAN, -- 약물 중환자실
    hv8           INT, -- 화상 중환자실
    hv9           INT, -- 외상 중환자실
    hv10          BOOLEAN, -- 소아용 VENTI 가용여부
    hv11          BOOLEAN, -- 인큐베이터 가용여부
    hv13          INT, -- 격리진료구역 음격리병상
    hv14          INT, -- 격리진료구역 일반격리병상
    hv15          INT, -- 소아음압격리
    hv16          INT, -- 소아일반격리
    hv17          INT, -- 음압격리 중환자실(응급전용)
    hv18          INT, -- 일반격리 중환자실(응급전용)
    hv19          INT, -- 음압격리 입원실(응급전용)
    hv21          INT, -- 일반격리 입원실(응급전용)
    hv22          INT, -- 감염병 전담병상 중환자실
    hv23          INT, -- 감염병 전담병상 중환자실 내 음압격리병상
    hv24          INT, -- 감염 중증 병상
    hv25          INT, -- 감염 준-중증 병상
    hv26          INT, -- 감염 중등증 병상
    hv27          INT, -- 코호트 격리
    hv28          INT, -- 소아
    hv29          INT, -- 응급실 음압 격리 병상
    hv30          INT, -- 응급실 일반 격리 병상
    hv31          INT, -- 중환자실(응급전용)
    hv32          INT, -- 소아 중환자실
    hv33          INT, -- 소아 중환자실(응급전용)
    hv34          INT, -- 심장내과 중환자실
    hv35          INT, -- 음압격리 중환자실
    hv36          INT, -- 입원실(응급전용)
    hv37          INT, -- 소아 입원실(응급전용)
    hv38          INT, -- 외상전용 입원실
    hv39          INT, -- 외상전용 수술실
    hv40          INT, -- 정신과 폐쇄병동
    hv41          INT, -- 음압격리 입원실
    hv42          BOOLEAN, -- 분만실
    hv43          BOOLEAN, -- 화상전용처치실
    hvctayn        BOOLEAN, -- CT 가용여부
    hvmriayn       BOOLEAN, -- MRI 가용여부
    hvangioayn     BOOLEAN, -- 혈관촬영기 가용여부
    hvventiayn     BOOLEAN, -- 인공호흡기 가용여부
    hvventisoayn   BOOLEAN, -- 조산아가용 인공호흡기 가용여부
    hvincuayn      BOOLEAN, -- 인큐베이터 가용여부
    hvcrrtayn      BOOLEAN, -- CRRT 가용여부
    hvecmoayn      BOOLEAN, -- ECMO 가용여부
    hvoxyayn       BOOLEAN, -- 고압산소치료기 가용여부
    hvhypoayn      BOOLEAN, -- 중심체온조절유도기 가용여부
    hvamyn         BOOLEAN, -- 구급차 가용여부
    hvs01 INT, -- 일반 병상 기준
    hvs03 INT, -- 응급실 음압 격리 병상 기준
    hvs04 INT, -- 응급실 일반 격리 병상 기준
    hvs05 INT, -- 응급전용 중환자실 기준
    hvs06 INT, -- 내과 중환자실 기준
    hvs07 INT, -- 외과 중환자실 기준
    hvs08 INT, -- 신생아 중환자실 기준
    hvs09 INT, -- 소아 중환자실 기준
    hvs10 INT, -- 응급전용 소아중환자실 기준
    hvs11 INT, -- 신경과 중환자실 기준
    hvs12 INT, -- 신경외과 중환자실 기준
    hvs13 INT, -- 화상 중환자실 기준
    hvs14 INT, -- 외상 중환자실 기준
    hvs15 INT, -- 심장내과 중환자실 기준
    hvs16 INT, -- 흉부외과 중환자실 기준
    hvs17 INT, -- 일반 중환자실 기준
    hvs18 INT, -- 음압격리 중환자실 기준
    hvs19 INT, -- 응급전용 입원실 기준
    hvs20 INT, -- 응급전용 소아입원실 기준
    hvs21 INT, -- 외상전용 입원실 기준
    hvs22 INT, -- 수술실 기준
    hvs23 INT, -- 외상전용 수술실 기준
    hvs25 INT, -- 음압격리 입원실 기준
    hvs46 INT, -- 격리진료구역 음압 격리 병상 기준
    hvs47 INT, -- 격리진료구역 일반 격리 병상 기준
    hvs48 INT, -- 소아 음압 격리 기준
    hvs49 INT, -- 소아 일반 격리 기준
    hvs50 INT, -- 응급전용 중환자실 음압 격리 기준
    hvs51 INT, -- 응급전용 중환자실 일반 격리 기준
    hvs52 INT, -- 응급전용 입원실 음압 격리 기준
    hvs53 INT, -- 응급전용 입원실 일반 격리 기준
    hvs54 INT, -- 감염병 전담병상 중환자실 기준
    hvs55 INT, -- 감염병 전담병상 중환자실 내 음압 격리 기준
    hvs56 INT, -- 감염 중증 병상 기준
    hvs57 INT, -- 감염 준-중증 병상 기준
    hvs58 INT, -- 감염 중등증 병상 기준
    hvs59 INT, -- 코호트 격리 기준
    hvidate        TEXT, -- 입력일시
    updated_at     TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE hospital_emergency_info (
    info_id TEXT PRIMARY KEY,
    CONSTRAINT fk_hospital2
      FOREIGN KEY (info_id)
      REFERENCES hospitals(hpid)
      ON DELETE CASCADE,
    dutyAddr        TEXT NOT NULL,
    dutyEmcls       TEXT NOT NULL
                    CHECK (dutyEmcls IN ('G001','G006','G007','G009')),
    dutyEmclsName   TEXT NOT NULL,
    wgs84Lon        DOUBLE PRECISION NOT NULL,
    wgs84Lat        DOUBLE PRECISION NOT NULL
);