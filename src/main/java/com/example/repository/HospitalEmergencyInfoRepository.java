package com.example.repository;


import com.example.entity.HospitalEmergencyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HospitalEmergencyInfoRepository extends JpaRepository<HospitalEmergencyInfo, Long> {
    Optional<HospitalEmergencyInfo> findByInfoId(Long hospitalId);
    @Modifying
    @Query(value = "INSERT INTO hospital_emergency_info (" +
            "info_id, dutyaddr, dutyemcls, dutyemclsname, wgs84lon, wgs84lat) " +
            "VALUES (:infoId, :dutyAddr, :dutyEmcls, :dutyEmclsName, :wgs84Lon, :wgs84Lat) " +
            "ON CONFLICT (info_id) DO UPDATE SET " +
            "dutyaddr = EXCLUDED.dutyaddr, " +
            "dutyemcls = EXCLUDED.dutyemcls, " +
            "dutyemclsname = EXCLUDED.dutyemclsname, " +
            "wgs84lon = EXCLUDED.wgs84lon, " +
            "wgs84lat = EXCLUDED.wgs84lat",
            nativeQuery = true)
    void saveOrUpdate(@Param("infoId") Long infoId,
                      @Param("dutyAddr") String dutyAddr,
                      @Param("dutyEmcls") String dutyEmcls,
                      @Param("dutyEmclsName") String dutyEmclsName,
                      @Param("wgs84Lon") Double wgs84Lon,
                      @Param("wgs84Lat") Double wgs84Lat);

}

