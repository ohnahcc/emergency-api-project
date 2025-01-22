package com.example.secondrepository;

import com.example.secondentity.SecondHospitalBedAvailabilityRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface SecondHospitalBedAvailabilityRateRepository extends JpaRepository<SecondHospitalBedAvailabilityRate, String> {


    @Modifying
    @Query(value = "INSERT INTO hospital_bed_availability_rate (" +
            "hpid, hv5, hv7, hv10, hv11, hv42, hv43, hvctayn, hvmriayn, hvangioayn, hvventiayn, hvventisoayn, hvincuayn, " +
            "hvcrrtayn, hvecmoayn, hvoxyayn, hvhypoayn, hvamyn, hvec_rate, hv29_rate, hv30_rate, hv31_rate, hv2_rate, hv3_rate, " +
            "hvncc_rate, hv32_rate, hv33_rate, hvcc_rate, hv6_rate, hv8_rate, hv9_rate, hv34_rate, hvccc_rate, hvicc_rate, " +
            "hv35_rate, hv19_rate, hv37_rate, hv38_rate, hvoc_rate, hv39_rate, hv41_rate, hv13_rate, hv14_rate, hv15_rate, " +
            "hv16_rate, hv17_rate, hv18_rate, hv21_rate, hv22_rate, hv23_rate, hv24_rate, hv25_rate, hv26_rate, hv27_rate, " +
            "hvidate, updated_at) " +
            "VALUES (" +
            ":hpid, :hv5, :hv7, :hv10, :hv11, :hv42, :hv43, :hvctayn, :hvmriayn, :hvangioayn, :hvventiayn, :hvventisoayn, :hvincuayn, " +
            ":hvcrrtayn, :hvecmoayn, :hvoxyayn, :hvhypoayn, :hvamyn, :hvec_rate, :hv29_rate, :hv30_rate, :hv31_rate, :hv2_rate, :hv3_rate, " +
            ":hvncc_rate, :hv32_rate, :hv33_rate, :hvcc_rate, :hv6_rate, :hv8_rate, :hv9_rate, :hv34_rate, :hvccc_rate, :hvicc_rate, " +
            ":hv35_rate, :hv19_rate, :hv37_rate, :hv38_rate, :hvoc_rate, :hv39_rate, :hv41_rate, :hv13_rate, :hv14_rate, :hv15_rate, " +
            ":hv16_rate, :hv17_rate, :hv18_rate, :hv21_rate, :hv22_rate, :hv23_rate, :hv24_rate, :hv25_rate, :hv26_rate, :hv27_rate, " +
            ":hvidate, :updatedAt) " +
            "ON CONFLICT (hpid) DO UPDATE SET " +
            "hv5 = EXCLUDED.hv5, hv7 = EXCLUDED.hv7, " +
            "hv10 = EXCLUDED.hv10, hv11 = EXCLUDED.hv11, " +
            "hv42 = EXCLUDED.hv42, hv43 = EXCLUDED.hv43, hvctayn = EXCLUDED.hvctayn, hvmriayn = EXCLUDED.hvmriayn, " +
            "hvangioayn = EXCLUDED.hvangioayn, hvventiayn = EXCLUDED.hvventiayn, hvventisoayn = EXCLUDED.hvventisoayn, " +
            "hvincuayn = EXCLUDED.hvincuayn, hvcrrtayn = EXCLUDED.hvcrrtayn, hvecmoayn = EXCLUDED.hvecmoayn, " +
            "hvoxyayn = EXCLUDED.hvoxyayn, hvhypoayn = EXCLUDED.hvhypoayn, hvamyn = EXCLUDED.hvamyn, " +
            "hvec_rate = EXCLUDED.hvec_rate, hv29_rate = EXCLUDED.hv29_rate, hv30_rate = EXCLUDED.hv30_rate, hv31_rate = EXCLUDED.hv31_rate, " +
            "hv2_rate = EXCLUDED.hv2_rate, hv3_rate = EXCLUDED.hv3_rate, hvncc_rate = EXCLUDED.hvncc_rate, hv32_rate = EXCLUDED.hv32_rate, " +
            "hv33_rate = EXCLUDED.hv33_rate, hvcc_rate = EXCLUDED.hvcc_rate, hv6_rate = EXCLUDED.hv6_rate, hv8_rate = EXCLUDED.hv8_rate, " +
            "hv9_rate = EXCLUDED.hv9_rate, hv34_rate = EXCLUDED.hv34_rate, hvccc_rate = EXCLUDED.hvccc_rate, hvicc_rate = EXCLUDED.hvicc_rate, " +
            "hv35_rate = EXCLUDED.hv35_rate, hv19_rate = EXCLUDED.hv19_rate, hv37_rate = EXCLUDED.hv37_rate, hv38_rate = EXCLUDED.hv38_rate, " +
            "hvoc_rate = EXCLUDED.hvoc_rate, hv39_rate = EXCLUDED.hv39_rate, hv41_rate = EXCLUDED.hv41_rate, hv13_rate = EXCLUDED.hv13_rate, " +
            "hv14_rate = EXCLUDED.hv14_rate, hv15_rate = EXCLUDED.hv15_rate, hv16_rate = EXCLUDED.hv16_rate, hv17_rate = EXCLUDED.hv17_rate, " +
            "hv18_rate = EXCLUDED.hv18_rate, hv21_rate = EXCLUDED.hv21_rate, hv22_rate = EXCLUDED.hv22_rate, hv23_rate = EXCLUDED.hv23_rate, " +
            "hv24_rate = EXCLUDED.hv24_rate, hv25_rate = EXCLUDED.hv25_rate, hv26_rate = EXCLUDED.hv26_rate, hv27_rate = EXCLUDED.hv27_rate, " +
            "hvidate = EXCLUDED.hvidate, updated_at = NOW()",
            nativeQuery = true)
    void saveOrUpdate(
            @Param("hpid") String hpid,

            @Param("hv5") Boolean hv5,
            @Param("hv7") Boolean hv7,
            @Param("hv10") Boolean hv10,
            @Param("hv11") Boolean hv11,
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
            @Param("hvec_rate") Integer hvec_rate,
            @Param("hv29_rate") Integer hv29_rate,
            @Param("hv30_rate") Integer hv30_rate,
            @Param("hv31_rate") Integer hv31_rate,
            @Param("hv2_rate") Integer hv2_rate,
            @Param("hv3_rate") Integer hv3_rate,
            @Param("hvncc_rate") Integer hvncc_rate,
            @Param("hv32_rate") Integer hv32_rate,
            @Param("hv33_rate") Integer hv33_rate,
            @Param("hvcc_rate") Integer hvcc_rate,
            @Param("hv6_rate") Integer hv6_rate,
            @Param("hv8_rate") Integer hv8_rate,
            @Param("hv9_rate") Integer hv9_rate,
            @Param("hv34_rate") Integer hv34_rate,
            @Param("hvccc_rate") Integer hvccc_rate,
            @Param("hvicc_rate") Integer hvicc_rate,
            @Param("hv35_rate") Integer hv35_rate,
            @Param("hv19_rate") Integer hv19_rate,
            @Param("hv37_rate") Integer hv37_rate,
            @Param("hv38_rate") Integer hv38_rate,
            @Param("hvoc_rate") Integer hvoc_rate,
            @Param("hv39_rate") Integer hv39_rate,
            @Param("hv41_rate") Integer hv41_rate,
            @Param("hv13_rate") Integer hv13_rate,
            @Param("hv14_rate") Integer hv14_rate,
            @Param("hv15_rate") Integer hv15_rate,
            @Param("hv16_rate") Integer hv16_rate,
            @Param("hv17_rate") Integer hv17_rate,
            @Param("hv18_rate") Integer hv18_rate,
            @Param("hv21_rate") Integer hv21_rate,
            @Param("hv22_rate") Integer hv22_rate,
            @Param("hv23_rate") Integer hv23_rate,
            @Param("hv24_rate") Integer hv24_rate,
            @Param("hv25_rate") Integer hv25_rate,
            @Param("hv26_rate") Integer hv26_rate,
            @Param("hv27_rate") Integer hv27_rate,
            @Param("hvidate") String hvidate,
            @Param("updatedAt") LocalDateTime updatedAt
    );



}
