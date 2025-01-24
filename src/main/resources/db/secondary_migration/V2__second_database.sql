CREATE TABLE hospital_bed_availability (
        hpid  TEXT PRIMARY KEY,
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
        operation_rate INT,
        hvidate        TEXT, -- 입력일시
        updated_at     TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE hospital_bed_operation_rate (
        hpid  TEXT PRIMARY KEY,
        hv5           BOOLEAN, -- 신경과 입원실
        hv7           BOOLEAN, -- 약물 중환자실
        hv10          BOOLEAN, -- 소아용 VENTI 가용여부
        hv11          BOOLEAN, -- 인큐베이터 가용여부
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
        hvec_rate INT, -- 응급실 일반 병상 가동률
        hv29_rate INT, -- 응급실 음압 격리 병상 가동률
        hv30_rate INT, -- 응급실 일반 격리 병상 가동률
        hv31_rate INT, -- 응급전용 중환자실 가동률
        hv2_rate INT, -- 내과 중환자실 가동률
        hv3_rate INT, -- 외과 중환자실 가동률
        hvncc_rate INT, -- 신생아 중환자실 가동률
        hv32_rate INT, -- 소아 중환자실 가동률
        hv33_rate INT, -- 응급전용 소아중환자실 가동률
        hvcc_rate INT, -- 신경과 중환자실 가동률
        hv6_rate INT, -- 신경외과 중환자실 가동률
        hv8_rate INT, -- 화상 중환자실 가동률
        hv9_rate INT, -- 외상 중환자실 가동률
        hv34_rate INT, -- 심장내과 중환자실 가동률
        hvccc_rate INT, -- 흉부외과 중환자실 가동률
        hvicc_rate INT, -- 일반 중환자실 가동률
        hv35_rate INT, -- 음압격리 중환자실 가동률
        hv19_rate INT, -- 응급전용 입원실 가동률
        hv37_rate INT, -- 응급전용 소아입원실 가동률
        hv38_rate INT, -- 외상전용 입원실 가동률
        hvoc_rate INT, -- 수술실 가동률
        hv39_rate INT, -- 외상전용 수술실 가동률
        hv41_rate INT, -- 음압격리 입원실 가동률
        hv13_rate INT, -- 격리진료구역 음압 격리 병상 가동률
        hv14_rate INT, -- 격리진료구역 일반 격리 병상 가동률
        hv15_rate INT, -- 소아 음압 격리 병상 가동률
        hv16_rate INT, -- 소아 일반 격리 병상 가동률
        hv17_rate INT, -- 응급전용 중환자실 음압 격리 병상 가동률
        hv18_rate INT, -- 응급전용 중환자실 일반 격리 병상 가동률
        hv21_rate INT, -- 응급전용 입원실 일반 격리 병상 가동률
        hv22_rate INT, -- 감염병 전담병상 중환자실 가동률
        hv23_rate INT, -- 감염병 전담병상 중환자실 내 음압 격리 병상 가동률
        hv24_rate INT, -- 감염 중증 병상 가동률
        hv25_rate INT, -- 감염 준-중증 병상 가동률
        hv26_rate INT, -- 감염 중등증 병상 가동률
        hv27_rate INT,  -- 코호트 격리 병상 가동률
        hvidate        TEXT, -- 입력일시
        updated_at     TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);