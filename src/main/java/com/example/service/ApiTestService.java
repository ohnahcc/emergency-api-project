package com.example.service;

import com.example.api.BedStatusApiClient;
import com.example.api.HospitalInfoApiClient;
import com.example.dto.BedStatusResponse;
import com.example.dto.HospitalInfoResponse;
import com.example.entity.Hospitals;
import com.example.repository.HospitalBedAvailabilityRepository;
import com.example.repository.HospitalEmergencyInfoRepository;
import com.example.repository.HospitalsRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

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
    private final XmlMapper xmlMapper;

    public ApiTestService(BedStatusApiClient bedStatusApiClient,
                          HospitalInfoApiClient hospitalInfoApiClient,
                          HospitalsRepository hospitalRepository,
                          HospitalBedAvailabilityRepository bedAvailabilityRepository,
                          HospitalEmergencyInfoRepository emergencyInfoRepository,
                          XmlMapper xmlMapper) {
        this.bedStatusApiClient = bedStatusApiClient;
        this.hospitalInfoApiClient = hospitalInfoApiClient;
        this.hospitalRepository = hospitalRepository;
        this.bedAvailabilityRepository = bedAvailabilityRepository;
        this.emergencyInfoRepository = emergencyInfoRepository;
        this.xmlMapper = xmlMapper;
    }

    public void testApiCalls() {
        log.info("Starting API Data Processing...");
        processHospitalInfo();
        processBedStatus();
        log.info("API Data Processing Completed.");
    }

    @Transactional
    public void processHospitalInfo() {
        try {
            String responseXml = hospitalInfoApiClient.fetchHospitalInfo("서울특별시", 100);
            List<HospitalInfoResponse.Body.Item> items = parseResponse(responseXml, HospitalInfoResponse.class);
            log.info("Parsed {} items from Hospital Info API", items.size());

            for (HospitalInfoResponse.Body.Item item : items) {
                Hospitals hospital = saveOrUpdateHospital(item.getHpid(), item.getDutyName(), null);
                saveEmergencyInfo(hospital, item);
            }
        } catch (IOException | IllegalArgumentException e) {
            log.error("Error processing Hospital Info: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to process Hospital Info", e);
        }
    }

    @Transactional
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
                hospital.getId(),
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
                item.getHvidate() != null ? item.getHvidate().toString() : null,
                LocalDateTime.now()
        );
    }

    private void saveEmergencyInfo(Hospitals hospital, HospitalInfoResponse.Body.Item item) {
        emergencyInfoRepository.saveOrUpdate(
                hospital.getId(),
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
}
























