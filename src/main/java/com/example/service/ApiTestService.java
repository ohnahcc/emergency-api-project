package com.example.service;

import com.example.api.BedStatusApiClient;
import com.example.api.HospitalInfoApiClient;
import com.example.dto.BedStatusResponse;
import com.example.dto.HospitalInfoResponse;
import com.example.entity.HospitalBedAvailability;
import com.example.entity.Hospitals;
import com.example.repository.HospitalBedAvailabilityRepository;
import com.example.repository.HospitalEmergencyInfoRepository;
import com.example.repository.HospitalsRepository;
import com.example.secondrepository.SecondHospitalBedAvailabilityRateRepository;
import com.example.secondrepository.SecondHospitalBedAvailabilityRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class ApiTestService {


    @PersistenceContext
    private EntityManager entityManager;

    private final BedStatusApiClient bedStatusApiClient;
    private final HospitalInfoApiClient hospitalInfoApiClient;
    private final HospitalsRepository hospitalRepository;
    private final HospitalBedAvailabilityRepository bedAvailabilityRepository;
    private final HospitalEmergencyInfoRepository emergencyInfoRepository;
    private final SecondHospitalBedAvailabilityRateRepository secondHospitalBedAvailabilityRateRepository;
    private final SecondHospitalBedAvailabilityRepository secondHospitalBedAvailabilityRepository;
    private final XmlMapper xmlMapper;

    public ApiTestService(BedStatusApiClient bedStatusApiClient,
                          HospitalInfoApiClient hospitalInfoApiClient,
                          HospitalsRepository hospitalRepository,
                          HospitalBedAvailabilityRepository bedAvailabilityRepository,
                          HospitalEmergencyInfoRepository emergencyInfoRepository,
                          SecondHospitalBedAvailabilityRateRepository secondHospitalBedAvailabilityRateRepository,
                          SecondHospitalBedAvailabilityRepository secondHospitalBedAvailabilityRepository,
                          XmlMapper xmlMapper) {
        this.bedStatusApiClient = bedStatusApiClient;
        this.hospitalInfoApiClient = hospitalInfoApiClient;
        this.hospitalRepository = hospitalRepository;
        this.bedAvailabilityRepository = bedAvailabilityRepository;
        this.emergencyInfoRepository = emergencyInfoRepository;
        this.secondHospitalBedAvailabilityRateRepository = secondHospitalBedAvailabilityRateRepository;
        this.secondHospitalBedAvailabilityRepository = secondHospitalBedAvailabilityRepository;
        this.xmlMapper = xmlMapper;
    }

    public void testApiCalls() {
        log.info("Starting API Data Processing...");
        processHospitalInfo();
        processBedStatus();
        log.info("API Data Processing Completed.");
    }

    @Transactional("primaryTransactionManager")
    public void processHospitalInfo() {
        try {
            String responseXml = hospitalInfoApiClient.fetchHospitalInfo("서울특별시", 100);
            List<HospitalInfoResponse.Body.Item> items = parseResponse(responseXml, HospitalInfoResponse.class);
            log.info("Parsed {} items from Hospital Info API", items.size());

            for (HospitalInfoResponse.Body.Item item : items) {
                Hospitals hospital = saveOrUpdateHospital(item.getHpid(), item.getDutyName(), item.getDutyTel3());
                saveEmergencyInfo(hospital, item);
            }
        } catch (IOException | IllegalArgumentException e) {
            log.error("Error processing Hospital Info: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to process Hospital Info", e);
        }
    }

    @Transactional("primaryTransactionManager")
    public void processBedStatus() {
        List<String> districts = List.of("강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구",
                "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구",
                "용산구", "은평구", "종로구", "중구", "중랑구");
        for (String district : districts) {
            try {
                log.info("Processing bed status for district: {}", district);
                String responseXml = bedStatusApiClient.fetchBedStatus("서울특별시", district);
                List<BedStatusResponse.Body.Item> items = parseResponse(responseXml, BedStatusResponse.class);

                for (BedStatusResponse.Body.Item item : items) {
                    Hospitals hospital = saveOrUpdateHospital(item.getHpid(), item.getDutyName(), item.getDutyTel3());
                    saveBedAvailability(hospital, item);
                }
            } catch (IOException | IllegalArgumentException e) {
                log.error("Error processing Bed Status for district {}: {}", district, e.getMessage(), e);
                throw new RuntimeException("Failed to process Bed Status for district " + district, e);
            }
        }
    }

    private Hospitals saveOrUpdateHospital(String hpid, String dutyName, String dutyTel3) {
        return hospitalRepository.findByHpid(hpid).orElseGet(() -> {
            Hospitals hospital = new Hospitals();
            hospital.setHpid(hpid);
            hospital.setDutyName(dutyName);
            hospital.setDutyTel3(dutyTel3);
            log.info("Saving new hospital: {}", hpid);
            return hospitalRepository.save(hospital);
        });
    }

    private void saveBedAvailability(Hospitals hospital, BedStatusResponse.Body.Item item) {
        bedAvailabilityRepository.saveOrUpdate(
                hospital.getHpid(),
                item.getHvec(),
                item.getHvoc(),
                item.getHvcc(),
                item.getHvncc(),
                item.getHvccc(),
                item.getHvicc(),
                item.getHvgc(),
                item.getHv2(),
                item.getHv3(),
                item.getHv4(),
                item.getHv5(),
                item.getHv6(),
                item.getHv7(),
                item.getHv8(),
                item.getHv9(),
                item.getHv10(),
                item.getHv11(),
                item.getHv13(),
                item.getHv14(),
                item.getHv15(),
                item.getHv16(),
                item.getHv17(),
                item.getHv18(),
                item.getHv19(),
                item.getHv21(),
                item.getHv22(),
                item.getHv23(),
                item.getHv24(),
                item.getHv25(),
                item.getHv26(),
                item.getHv27(),
                item.getHv28(),
                item.getHv29(),
                item.getHv30(),
                item.getHv31(),
                item.getHv32(),
                item.getHv33(),
                item.getHv34(),
                item.getHv35(),
                item.getHv36(),
                item.getHv37(),
                item.getHv38(),
                item.getHv39(),
                item.getHv40(),
                item.getHv41(),
                item.getHv42(),
                item.getHv43(),
                item.getHvctayn(),
                item.getHvmriayn(),
                item.getHvangioayn(),
                item.getHvventiayn(),
                item.getHvventisoayn(),
                item.getHvincuayn(),
                item.getHvcrrtayn(),
                item.getHvecmoayn(),
                item.getHvoxyayn(),
                item.getHvhypoayn(),
                item.getHvamyn(),
                item.getHvs01(),       // 일반 병상 기준
                item.getHvs03(),       // 응급실 음압 격리 병상 기준
                item.getHvs04(),       // 응급실 일반 격리 병상 기준
                item.getHvs05(),       // 응급전용 중환자실 기준
                item.getHvs06(),       // 내과 중환자실 기준
                item.getHvs07(),       // 외과 중환자실 기준
                item.getHvs08(),       // 신생아 중환자실 기준
                item.getHvs09(),       // 소아 중환자실 기준
                item.getHvs10(),       // 응급전용 소아중환자실 기준
                item.getHvs11(),       // 신경과 중환자실 기준
                item.getHvs12(),       // 신경외과 중환자실 기준
                item.getHvs13(),       // 화상 중환자실 기준
                item.getHvs14(),       // 외상 중환자실 기준
                item.getHvs15(),       // 심장내과 중환자실 기준
                item.getHvs16(),       // 흉부외과 중환자실 기준
                item.getHvs17(),       // 일반 중환자실 기준
                item.getHvs18(),       // 음압격리 중환자실 기준
                item.getHvs19(),       // 응급전용 입원실 기준
                item.getHvs20(),       // 응급전용 소아입원실 기준
                item.getHvs21(),       // 외상전용 입원실 기준
                item.getHvs22(),       // 수술실 기준
                item.getHvs23(),       // 외상전용 수술실 기준
                item.getHvs25(),       // 음압격리 입원실 기준
                item.getHvs46(),       // 격리진료구역 음압 격리 병상 기준
                item.getHvs47(),       // 격리진료구역 일반 격리 병상 기준
                item.getHvs48(),       // 소아 음압 격리 기준
                item.getHvs49(),       // 소아 일반 격리 기준
                item.getHvs50(),       // 응급전용 중환자실 음압 격리 기준
                item.getHvs51(),       // 응급전용 중환자실 일반 격리 기준
                item.getHvs52(),       // 응급전용 입원실 음압 격리 기준
                item.getHvs53(),       // 응급전용 입원실 일반 격리 기준
                item.getHvs54(),       // 감염병 전담병상 중환자실 기준
                item.getHvs55(),       // 감염병 전담병상 중환자실 내 음압 격리 기준
                item.getHvs56(),       // 감염 중증 병상 기준
                item.getHvs57(),       // 감염 준-중증 병상 기준
                item.getHvs58(),       // 감염 중등증 병상 기준
                item.getHvs59(),       // 코호트 격리 기준
                item.getHvidate() != null ? item.getHvidate().toString() : null,
                LocalDateTime.now()

        );
    }

    private void saveEmergencyInfo(Hospitals hospital, HospitalInfoResponse.Body.Item item) {
        emergencyInfoRepository.saveOrUpdate(
                hospital.getHpid(),
                item.getDutyAddr(),
                item.getDutyEmcls(),
                item.getDutyEmclsName(),
                item.getWgs84Lon(),
                item.getWgs84Lat()
        );
    }

    private <T, E> List<E> parseResponse(String xml, Class<T> responseType) throws IOException {
        T response = xmlMapper.readValue(xml, responseType);
        if (response instanceof BedStatusResponse) {
            return (List<E>) ((BedStatusResponse) response).getBody().getItems();
        } else if (response instanceof HospitalInfoResponse) {
            return (List<E>) ((HospitalInfoResponse) response).getBody().getItems();
        } else {
            throw new IllegalArgumentException("Unsupported response type");
        }
    }

    @Transactional("secondTransactionManager")
    public void calculateAndStoreUtilizationRatesInSecondDB() {
        List<HospitalBedAvailability> hospitalBeds = bedAvailabilityRepository.findAll(); // 첫 번째 DB에서 데이터 가져오기

        for (HospitalBedAvailability bed : hospitalBeds) {
            Map<String, Integer> utilizationRates = new HashMap<>();

            // 병상 데이터를 동적으로 매핑
            Map<String, Integer> totalBeds = new HashMap<>();
            totalBeds.put("hvs01", bed.getHvs01());
            totalBeds.put("hvs03", bed.getHvs03());
            totalBeds.put("hvs04", bed.getHvs04());
            totalBeds.put("hvs05", bed.getHvs05());
            totalBeds.put("hvs06", bed.getHvs06());
            totalBeds.put("hvs07", bed.getHvs07());
            totalBeds.put("hvs08", bed.getHvs08());
            totalBeds.put("hvs09", bed.getHvs09());
            totalBeds.put("hvs10", bed.getHvs10());
            totalBeds.put("hvs11", bed.getHvs11());
            totalBeds.put("hvs12", bed.getHvs12());
            totalBeds.put("hvs13", bed.getHvs13());
            totalBeds.put("hvs14", bed.getHvs14());
            totalBeds.put("hvs15", bed.getHvs15());
            totalBeds.put("hvs16", bed.getHvs16());
            totalBeds.put("hvs17", bed.getHvs17());
            totalBeds.put("hvs18", bed.getHvs18());
            totalBeds.put("hvs19", bed.getHvs19());
            totalBeds.put("hvs20", bed.getHvs20());
            totalBeds.put("hvs21", bed.getHvs21());
            totalBeds.put("hvs22", bed.getHvs22());
            totalBeds.put("hvs23", bed.getHvs23());
            totalBeds.put("hvs25", bed.getHvs25());
            totalBeds.put("hvs46", bed.getHvs46());
            totalBeds.put("hvs47", bed.getHvs47());
            totalBeds.put("hvs48", bed.getHvs48());
            totalBeds.put("hvs49", bed.getHvs49());
            totalBeds.put("hvs50", bed.getHvs50());
            totalBeds.put("hvs51", bed.getHvs51());
            totalBeds.put("hvs52", bed.getHvs52());
            totalBeds.put("hvs53", bed.getHvs53());
            totalBeds.put("hvs54", bed.getHvs54());
            totalBeds.put("hvs55", bed.getHvs55());
            totalBeds.put("hvs56", bed.getHvs56());
            totalBeds.put("hvs57", bed.getHvs57());
            totalBeds.put("hvs58", bed.getHvs58());

            Map<String, Integer> availableBeds = new HashMap<>();
            availableBeds.put("hvs01", bed.getHvec());
            availableBeds.put("hvs03", bed.getHv29());
            availableBeds.put("hvs04", bed.getHv30());
            availableBeds.put("hvs05", bed.getHv31());
            availableBeds.put("hvs06", bed.getHv2());
            availableBeds.put("hvs07", bed.getHv3());
            availableBeds.put("hvs08", bed.getHvncc());
            availableBeds.put("hvs09", bed.getHv32());
            availableBeds.put("hvs10", bed.getHv33());
            availableBeds.put("hvs11", bed.getHvcc());
            availableBeds.put("hvs12", bed.getHv6());
            availableBeds.put("hvs13", bed.getHv8());
            availableBeds.put("hvs14", bed.getHv9());
            availableBeds.put("hvs15", bed.getHv34());
            availableBeds.put("hvs16", bed.getHvccc());
            availableBeds.put("hvs17", bed.getHvicc());
            availableBeds.put("hvs18", bed.getHv35());
            availableBeds.put("hvs19", bed.getHv19());
            availableBeds.put("hvs20", bed.getHv37());
            availableBeds.put("hvs21", bed.getHv38());
            availableBeds.put("hvs22", bed.getHvoc());
            availableBeds.put("hvs23", bed.getHv39());
            availableBeds.put("hvs25", bed.getHv41());
            availableBeds.put("hvs46", bed.getHv13());
            availableBeds.put("hvs47", bed.getHv14());
            availableBeds.put("hvs48", bed.getHv15());
            availableBeds.put("hvs49", bed.getHv16());
            availableBeds.put("hvs50", bed.getHv17());
            availableBeds.put("hvs51", bed.getHv18());
            availableBeds.put("hvs52", bed.getHv21());
            availableBeds.put("hvs53", bed.getHv22());
            availableBeds.put("hvs54", bed.getHv23());
            availableBeds.put("hvs55", bed.getHv24());
            availableBeds.put("hvs56", bed.getHv25());
            availableBeds.put("hvs57", bed.getHv26());
            availableBeds.put("hvs58", bed.getHv27());

            // 동적 계산
            for (String key : totalBeds.keySet()) {
                Integer total = totalBeds.get(key);
                Integer available = availableBeds.get(key);

                if (total != null && total > 0 && available != null) {
                    int rate = (int) (((total - available) / total.floatValue()) * 100);
                    utilizationRates.put(key + "_rate", rate);
                }
            }

            // 두 번째 데이터베이스에 저장
            secondHospitalBedAvailabilityRateRepository.saveOrUpdate(
                    bed.getHospital().getHpid(),
                    bed.getHv5(),
                    bed.getHv7(),
                    bed.getHv10(),
                    bed.getHv11(),
                    bed.getHv42(),
                    bed.getHv43(),
                    bed.getHvctayn(),
                    bed.getHvmriayn(),
                    bed.getHvangioayn(),
                    bed.getHvventiayn(),
                    bed.getHvventisoayn(),
                    bed.getHvincuayn(),
                    bed.getHvcrrtayn(),
                    bed.getHvecmoayn(),
                    bed.getHvoxyayn(),
                    bed.getHvhypoayn(),
                    bed.getHvamyn(),
                    utilizationRates.get("hvs01_rate"),
                    utilizationRates.get("hvs03_rate"),
                    utilizationRates.get("hvs04_rate"),
                    utilizationRates.get("hvs05_rate"),
                    utilizationRates.get("hvs06_rate"),
                    utilizationRates.get("hvs07_rate"),
                    utilizationRates.get("hvs08_rate"),
                    utilizationRates.get("hvs09_rate"),
                    utilizationRates.get("hvs10_rate"),
                    utilizationRates.get("hvs11_rate"),
                    utilizationRates.get("hvs12_rate"),
                    utilizationRates.get("hvs13_rate"),
                    utilizationRates.get("hvs14_rate"),
                    utilizationRates.get("hvs15_rate"),
                    utilizationRates.get("hvs16_rate"),
                    utilizationRates.get("hvs17_rate"),
                    utilizationRates.get("hvs18_rate"),
                    utilizationRates.get("hvs19_rate"),
                    utilizationRates.get("hvs20_rate"),
                    utilizationRates.get("hvs21_rate"),
                    utilizationRates.get("hvs22_rate"),
                    utilizationRates.get("hvs23_rate"),
                    utilizationRates.get("hvs25_rate"),
                    utilizationRates.get("hvs46_rate"),
                    utilizationRates.get("hvs47_rate"),
                    utilizationRates.get("hvs48_rate"),
                    utilizationRates.get("hvs49_rate"),
                    utilizationRates.get("hvs50_rate"),
                    utilizationRates.get("hvs51_rate"),
                    utilizationRates.get("hvs52_rate"),
                    utilizationRates.get("hvs53_rate"),
                    utilizationRates.get("hvs54_rate"),
                    utilizationRates.get("hvs55_rate"),
                    utilizationRates.get("hvs56_rate"),
                    utilizationRates.get("hvs57_rate"),
                    utilizationRates.get("hvs58_rate"),
                    bed.getHvidate() != null ? bed.getHvidate().toString() : null,
                    LocalDateTime.now()
            );
        }
    }

    @Transactional("secondTransactionManager")
    public void calculateUtilizationRatesInSecondDB() {
        List<HospitalBedAvailability> hospitalBeds = bedAvailabilityRepository.findAll(); // 첫 번째 DB에서 데이터 가져오기

        for (HospitalBedAvailability bed : hospitalBeds) {
            if (bed.getHvs01() != null && bed.getHvs01() > 0) {
                Integer operation_rate = (int) (((bed.getHvs01() - bed.getHvec()) /bed.getHvs01().floatValue()) * 100);

                // 두 번째 데이터베이스에 저장
                secondHospitalBedAvailabilityRepository.saveOrUpdate(
                        bed.getHospital().getHpid(),
                        bed.getHvec(),
                        bed.getHvoc(),
                        bed.getHvcc(),
                        bed.getHvncc(),
                        bed.getHvccc(),
                        bed.getHvicc(),
                        bed.getHvgc(),
                        bed.getHv2(),
                        bed.getHv3(),
                        bed.getHv4(),
                        bed.getHv5(),
                        bed.getHv6(),
                        bed.getHv7(),
                        bed.getHv8(),
                        bed.getHv9(),
                        bed.getHv10(),
                        bed.getHv11(),
                        bed.getHv13(),
                        bed.getHv14(),
                        bed.getHv15(),
                        bed.getHv16(),
                        bed.getHv17(),
                        bed.getHv18(),
                        bed.getHv19(),
                        bed.getHv21(),
                        bed.getHv22(),
                        bed.getHv23(),
                        bed.getHv24(),
                        bed.getHv25(),
                        bed.getHv26(),
                        bed.getHv27(),
                        bed.getHv28(),
                        bed.getHv29(),
                        bed.getHv30(),
                        bed.getHv31(),
                        bed.getHv32(),
                        bed.getHv33(),
                        bed.getHv34(),
                        bed.getHv35(),
                        bed.getHv36(),
                        bed.getHv37(),
                        bed.getHv38(),
                        bed.getHv39(),
                        bed.getHv40(),
                        bed.getHv41(),
                        bed.getHv42(),
                        bed.getHv43(),
                        bed.getHvctayn(),
                        bed.getHvmriayn(),
                        bed.getHvangioayn(),
                        bed.getHvventiayn(),
                        bed.getHvventisoayn(),
                        bed.getHvincuayn(),
                        bed.getHvcrrtayn(),
                        bed.getHvecmoayn(),
                        bed.getHvoxyayn(),
                        bed.getHvhypoayn(),
                        bed.getHvamyn(),
                        operation_rate,       // 일반 병상 기준
                        bed.getHvidate() != null ? bed.getHvidate().toString() : null,
                        LocalDateTime.now()
                );
            }
        }
    }


}
















































