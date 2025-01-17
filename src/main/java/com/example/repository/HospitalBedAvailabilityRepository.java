package com.example.repository;

import com.example.entity.HospitalBedAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface HospitalBedAvailabilityRepository extends JpaRepository<HospitalBedAvailability, Long> {
    Optional<HospitalBedAvailability> findByHospitalId(Long hospitalId);

    @Modifying
    @Query(value = "INSERT INTO hospital_bed_availability (" +
            "hospital_id, hvec, hvoc, hvcc, hvncc, hvccc, hvicc, hvgc, hv2, hv3, hv4, hv5, hv6, hv7, " +
            "hv8, hv9, hv10, hv11, hv13, hv14, hv15, hv16, hv17, hv18, hv19, hv21, hv22, hv23, hv24, " +
            "hv25, hv26, hv27, hv28, hv29, hv30, hv31, hv32, hv33, hv34, hv35, hv36, hv37, hv38, hv39, " +
            "hv40, hv41, hv42, hv43, hvidate, updated_at) " +
            "VALUES (" +
            ":hospitalId, :hvec, :hvoc, :hvcc, :hvncc, :hvccc, :hvicc, :hvgc, :hv2, :hv3, :hv4, :hv5, :hv6, :hv7, " +
            ":hv8, :hv9, :hv10, :hv11, :hv13, :hv14, :hv15, :hv16, :hv17, :hv18, :hv19, :hv21, :hv22, :hv23, :hv24, " +
            ":hv25, :hv26, :hv27, :hv28, :hv29, :hv30, :hv31, :hv32, :hv33, :hv34, :hv35, :hv36, :hv37, :hv38, :hv39, " +
            ":hv40, :hv41, :hv42, :hv43, :hvidate, :updatedAt) " +
            "ON CONFLICT (hospital_id) DO UPDATE SET " +
            "hvec = EXCLUDED.hvec, hvoc = EXCLUDED.hvoc, hvcc = EXCLUDED.hvcc, hvncc = EXCLUDED.hvncc, hvccc = EXCLUDED.hvccc, " +
            "hvicc = EXCLUDED.hvicc, hvgc = EXCLUDED.hvgc, hv2 = EXCLUDED.hv2, hv3 = EXCLUDED.hv3, hv4 = EXCLUDED.hv4, " +
            "hv5 = EXCLUDED.hv5, hv6 = EXCLUDED.hv6, hv7 = EXCLUDED.hv7, hv8 = EXCLUDED.hv8, hv9 = EXCLUDED.hv9, " +
            "hv10 = EXCLUDED.hv10, hv11 = EXCLUDED.hv11, hv13 = EXCLUDED.hv13, hv14 = EXCLUDED.hv14, hv15 = EXCLUDED.hv15, " +
            "hv16 = EXCLUDED.hv16, hv17 = EXCLUDED.hv17, hv18 = EXCLUDED.hv18, hv19 = EXCLUDED.hv19, hv21 = EXCLUDED.hv21, " +
            "hv22 = EXCLUDED.hv22, hv23 = EXCLUDED.hv23, hv24 = EXCLUDED.hv24, hv25 = EXCLUDED.hv25, hv26 = EXCLUDED.hv26, " +
            "hv27 = EXCLUDED.hv27, hv28 = EXCLUDED.hv28, hv29 = EXCLUDED.hv29, hv30 = EXCLUDED.hv30, hv31 = EXCLUDED.hv31, " +
            "hv32 = EXCLUDED.hv32, hv33 = EXCLUDED.hv33, hv34 = EXCLUDED.hv34, hv35 = EXCLUDED.hv35, hv36 = EXCLUDED.hv36, " +
            "hv37 = EXCLUDED.hv37, hv38 = EXCLUDED.hv38, hv39 = EXCLUDED.hv39, hv40 = EXCLUDED.hv40, hv41 = EXCLUDED.hv41, " +
            "hv42 = EXCLUDED.hv42, hv43 = EXCLUDED.hv43, hvidate = EXCLUDED.hvidate, updated_at = NOW()",
            nativeQuery = true)
    void saveOrUpdate(
            @Param("hospitalId") Long hospitalId,
            @Param("hvec") Integer hvec,
            @Param("hvoc") Integer hvoc,
            @Param("hvcc") Integer hvcc,
            @Param("hvncc") Integer hvncc,
            @Param("hvccc") Integer hvccc,
            @Param("hvicc") Integer hvicc,
            @Param("hvgc") Integer hvgc,
            @Param("hv2") Integer hv2,
            @Param("hv3") Integer hv3,
            @Param("hv4") Integer hv4,
            @Param("hv5") Boolean hv5,
            @Param("hv6") Integer hv6,
            @Param("hv7") Boolean hv7,
            @Param("hv8") Integer hv8,
            @Param("hv9") Integer hv9,
            @Param("hv10") Boolean hv10,
            @Param("hv11") Boolean hv11,
            @Param("hv13") Integer hv13,
            @Param("hv14") Integer hv14,
            @Param("hv15") Integer hv15,
            @Param("hv16") Integer hv16,
            @Param("hv17") Integer hv17,
            @Param("hv18") Integer hv18,
            @Param("hv19") Integer hv19,
            @Param("hv21") Integer hv21,
            @Param("hv22") Integer hv22,
            @Param("hv23") Integer hv23,
            @Param("hv24") Integer hv24,
            @Param("hv25") Integer hv25,
            @Param("hv26") Integer hv26,
            @Param("hv27") Integer hv27,
            @Param("hv28") Integer hv28,
            @Param("hv29") Integer hv29,
            @Param("hv30") Integer hv30,
            @Param("hv31") Integer hv31,
            @Param("hv32") Integer hv32,
            @Param("hv33") Integer hv33,
            @Param("hv34") Integer hv34,
            @Param("hv35") Integer hv35,
            @Param("hv36") Integer hv36,
            @Param("hv37") Integer hv37,
            @Param("hv38") Integer hv38,
            @Param("hv39") Integer hv39,
            @Param("hv40") Integer hv40,
            @Param("hv41") Integer hv41,
            @Param("hv42") Boolean hv42,
            @Param("hv43") Boolean hv43,
            @Param("hvidate") String hvidate,
            @Param("updatedAt") LocalDateTime updatedAt
    );

}

