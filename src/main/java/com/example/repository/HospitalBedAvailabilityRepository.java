package com.example.repository;

import com.example.entity.HospitalBedAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalBedAvailabilityRepository extends JpaRepository<HospitalBedAvailability, Long> {
    Optional<HospitalBedAvailability> findByHospitalId(String hospitalId);

    @Modifying
    @Query(value = "INSERT INTO hospital_bed_availability_local (" +
            "hospital_id, hvec, hvoc, hvcc, hvncc, hvccc, hvicc, hvgc, hv2, hv3, hv4, hv5, hv6, hv7, " +
            "hv8, hv9, hv10, hv11, hv13, hv14, hv15, hv16, hv17, hv18, hv19, hv21, hv22, hv23, hv24, " +
            "hv25, hv26, hv27, hv28, hv29, hv30, hv31, hv32, hv33, hv34, hv35, hv36, hv37, hv38, hv39, " +
            "hv40, hv41, hv42, hv43, hvctayn, hvmriayn, hvangioayn, hvventiayn, hvventisoayn, hvincuayn, " +
            "hvcrrtayn, hvecmoayn, hvoxyayn, hvhypoayn, hvamyn, hvs01, hvs03, hvs04, hvs05, hvs06, hvs07, hvs08, hvs09, hvs10, hvs11, hvs12, hvs13, hvs14, hvs15, hvs16, hvs17, hvs18, hvs19, hvs20, hvs21, hvs22, hvs23, hvs25, hvs46, hvs47, hvs48, hvs49, hvs50, hvs51, hvs52, hvs53, hvs54, hvs55, hvs56, hvs57, hvs58, hvs59, hvidate, updated_at) " +
            "VALUES (" +
            ":hospitalId, :hvec, :hvoc, :hvcc, :hvncc, :hvccc, :hvicc, :hvgc, :hv2, :hv3, :hv4, :hv5, :hv6, :hv7, " +
            ":hv8, :hv9, :hv10, :hv11, :hv13, :hv14, :hv15, :hv16, :hv17, :hv18, :hv19, :hv21, :hv22, :hv23, :hv24, " +
            ":hv25, :hv26, :hv27, :hv28, :hv29, :hv30, :hv31, :hv32, :hv33, :hv34, :hv35, :hv36, :hv37, :hv38, :hv39, " +
            ":hv40, :hv41, :hv42, :hv43, :hvctayn, :hvmriayn, :hvangioayn, :hvventiayn, :hvventisoayn, :hvincuayn, " +
            ":hvcrrtayn, :hvecmoayn, :hvoxyayn, :hvhypoayn, :hvamyn, :hvs01, :hvs03, :hvs04, :hvs05, :hvs06, :hvs07, :hvs08, :hvs09, :hvs10, :hvs11, :hvs12, :hvs13, :hvs14, :hvs15, :hvs16, :hvs17, :hvs18, :hvs19, :hvs20, :hvs21, :hvs22, :hvs23, :hvs25, :hvs46, :hvs47, :hvs48, :hvs49, :hvs50, :hvs51, :hvs52, :hvs53, :hvs54, :hvs55, :hvs56, :hvs57, :hvs58, :hvs59, :hvidate, :updatedAt) " +
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
            "hv42 = EXCLUDED.hv42, hv43 = EXCLUDED.hv43, hvctayn = EXCLUDED.hvctayn, hvmriayn = EXCLUDED.hvmriayn, " +
            "hvangioayn = EXCLUDED.hvangioayn, hvventiayn = EXCLUDED.hvventiayn, hvventisoayn = EXCLUDED.hvventisoayn, " +
            "hvincuayn = EXCLUDED.hvincuayn, hvcrrtayn = EXCLUDED.hvcrrtayn, hvecmoayn = EXCLUDED.hvecmoayn, " +
            "hvoxyayn = EXCLUDED.hvoxyayn, hvhypoayn = EXCLUDED.hvhypoayn, hvamyn = EXCLUDED.hvamyn, " +
            "hvs01 = EXCLUDED.hvs01, hvs03 = EXCLUDED.hvs03, hvs04 = EXCLUDED.hvs04, hvs05 = EXCLUDED.hvs05, hvs06 = EXCLUDED.hvs06, hvs07 = EXCLUDED.hvs07, hvs08 = EXCLUDED.hvs08, hvs09 = EXCLUDED.hvs09, hvs10 = EXCLUDED.hvs10, hvs11 = EXCLUDED.hvs11, hvs12 = EXCLUDED.hvs12, hvs13 = EXCLUDED.hvs13, hvs14 = EXCLUDED.hvs14, hvs15 = EXCLUDED.hvs15, hvs16 = EXCLUDED.hvs16, hvs17 = EXCLUDED.hvs17, hvs18 = EXCLUDED.hvs18, hvs19 = EXCLUDED.hvs19, hvs20 = EXCLUDED.hvs20, hvs21 = EXCLUDED.hvs21, hvs22 = EXCLUDED.hvs22, hvs23 = EXCLUDED.hvs23, hvs25 = EXCLUDED.hvs25, hvs46 = EXCLUDED.hvs46, hvs47 = EXCLUDED.hvs47, hvs48 = EXCLUDED.hvs48, hvs49 = EXCLUDED.hvs49, hvs50 = EXCLUDED.hvs50, hvs51 = EXCLUDED.hvs51, hvs52 = EXCLUDED.hvs52, hvs53 = EXCLUDED.hvs53, hvs54 = EXCLUDED.hvs54, hvs55 = EXCLUDED.hvs55, hvs56 = EXCLUDED.hvs56, hvs57 = EXCLUDED.hvs57, hvs58 = EXCLUDED.hvs58, hvs59 = EXCLUDED.hvs59, hvidate = EXCLUDED.hvidate, updated_at = NOW()",
            nativeQuery = true)
    void saveOrUpdate(
            @Param("hospitalId") String hospitalId,
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
            @Param("hvctayn") Boolean hvctayn,
            @Param("hvmriayn") Boolean hvmriayn,
            @Param("hvangioayn") Boolean hvangioayn,
            @Param("hvventiayn") Boolean hvventiayn,
            @Param("hvventisoayn") Boolean hvventisoayn,
            @Param("hvincuayn") Boolean hvincuayn,
            @Param("hvcrrtayn") Boolean hvcrrtayn,
            @Param("hvecmoayn") Boolean hvecmoayn,
            @Param("hvoxyayn") Boolean hvoxyayn,
            @Param("hvhypoayn") Boolean hvhypoayn,
            @Param("hvamyn") Boolean hvamyn,
            @Param("hvs01") Integer hvs01,
            @Param("hvs03") Integer hvs03,
            @Param("hvs04") Integer hvs04,
            @Param("hvs05") Integer hvs05,
            @Param("hvs06") Integer hvs06,
            @Param("hvs07") Integer hvs07,
            @Param("hvs08") Integer hvs08,
            @Param("hvs09") Integer hvs09,
            @Param("hvs10") Integer hvs10,
            @Param("hvs11") Integer hvs11,
            @Param("hvs12") Integer hvs12,
            @Param("hvs13") Integer hvs13,
            @Param("hvs14") Integer hvs14,
            @Param("hvs15") Integer hvs15,
            @Param("hvs16") Integer hvs16,
            @Param("hvs17") Integer hvs17,
            @Param("hvs18") Integer hvs18,
            @Param("hvs19") Integer hvs19,
            @Param("hvs20") Integer hvs20,
            @Param("hvs21") Integer hvs21,
            @Param("hvs22") Integer hvs22,
            @Param("hvs23") Integer hvs23,
            @Param("hvs25") Integer hvs25,
            @Param("hvs46") Integer hvs46,
            @Param("hvs47") Integer hvs47,
            @Param("hvs48") Integer hvs48,
            @Param("hvs49") Integer hvs49,
            @Param("hvs50") Integer hvs50,
            @Param("hvs51") Integer hvs51,
            @Param("hvs52") Integer hvs52,
            @Param("hvs53") Integer hvs53,
            @Param("hvs54") Integer hvs54,
            @Param("hvs55") Integer hvs55,
            @Param("hvs56") Integer hvs56,
            @Param("hvs57") Integer hvs57,
            @Param("hvs58") Integer hvs58,
            @Param("hvs59") Integer hvs59,
            @Param("hvidate") String hvidate,
            @Param("updatedAt") LocalDateTime updatedAt
    );



}

