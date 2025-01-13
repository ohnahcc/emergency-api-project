package com.example.service;

import com.example.api.BedStatusApiClient;
import com.example.api.HospitalInfoApiClient;
import com.example.dto.ApiResponse;
import com.example.dto.BedAvailabilityItem;
import com.example.dto.EmergencyInfoItem;
import com.example.dto.HospitalItem;
import com.example.entity.Hospitals;
import com.example.entity.HospitalBedAvailability;
import com.example.entity.HospitalEmergencyInfo;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiTestService {

    private final BedStatusApiClient bedStatusApiClient;
    private final HospitalInfoApiClient hospitalInfoApiClient;
    private final HospitalsService hospitalsService;
    private final HospitalBedAvailabilityService bedAvailabilityService;
    private final HospitalEmergencyInfoService emergencyInfoService;

    public ApiTestService(BedStatusApiClient bedStatusApiClient,
                          HospitalInfoApiClient hospitalInfoApiClient,
                          HospitalsService hospitalsService,
                          HospitalBedAvailabilityService bedAvailabilityService,
                          HospitalEmergencyInfoService emergencyInfoService) {
        this.bedStatusApiClient = bedStatusApiClient;
        this.hospitalInfoApiClient = hospitalInfoApiClient;
        this.hospitalsService = hospitalsService;
        this.bedAvailabilityService = bedAvailabilityService;
        this.emergencyInfoService = emergencyInfoService;
    }

    public void testApiCalls() {
        // 병상 정보 호출
        List<String> districts = List.of("강남구", "서초구", "송파구");
        String stage1 = "서울특별시";

        for (String district : districts) {
            try {
                System.out.println("Fetching Bed Status for: " + district);
                String bedStatusResponse = bedStatusApiClient.fetchBedStatus(stage1, district);

                // XML 선언부 제거
                String cleanBedStatusResponse = removeXmlDeclaration(bedStatusResponse);

                // 병원 및 병상 데이터 파싱
                List<Hospitals> hospitals = parseHospitals(cleanBedStatusResponse);
                List<HospitalBedAvailability> bedAvailabilities = parseBedAvailability(cleanBedStatusResponse);

                // 병원 및 병상 데이터 저장
                for (Hospitals hospital : hospitals) {
                    Hospitals savedHospital = hospitalsService.save(hospital);
                    for (HospitalBedAvailability bed : bedAvailabilities) {
                        if (bed.getHpid().equals(savedHospital.getHpid())) {
                            bed.setHospitalId(savedHospital.getId());
                            bedAvailabilityService.save(bed);
                        }
                    }
                }

                Thread.sleep(1000); // 1초 대기
            } catch (Exception e) {
                System.err.println("Error fetching Bed Status for " + district + ": " + e.getMessage());
            }
        }

        // 병원 정보 호출
        try {
            System.out.println("Fetching Hospital Info for region: 서울특별시");
            String hospitalInfoResponse = hospitalInfoApiClient.fetchHospitalInfo("서울특별시", 100);

            // XML 선언부 제거
            String cleanHospitalInfoResponse = removeXmlDeclaration(hospitalInfoResponse);

            // 응급실 데이터 파싱 및 저장
            List<HospitalEmergencyInfo> emergencyInfos = parseEmergencyInfo(cleanHospitalInfoResponse);
            for (HospitalEmergencyInfo emergencyInfo : emergencyInfos) {
                emergencyInfoService.save(emergencyInfo);
            }
        } catch (Exception e) {
            System.err.println("Error fetching Hospital Info: " + e.getMessage());
        }
    }

    // XML 선언부 제거 메서드
    private String removeXmlDeclaration(String xml) {
        if (xml.startsWith("<?xml")) {
            int startIndex = xml.indexOf("?>") + 2; // 선언부 끝 이후
            return xml.substring(startIndex).trim(); // 선언부 제거 후 반환
        }
        return xml; // 선언부가 없으면 원본 반환
    }

    private List<Hospitals> parseHospitals(String xmlResponse) {
        List<Hospitals> hospitals = new ArrayList<>();
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // TypeReference를 사용해 제네릭 타입 정보 전달
            ApiResponse<HospitalItem> apiResponse = xmlMapper.readValue(
                    xmlResponse,
                    new com.fasterxml.jackson.core.type.TypeReference<ApiResponse<HospitalItem>>() {}
            );

            for (HospitalItem item : apiResponse.getBody().getItems()) {
                Hospitals hospital = new Hospitals();
                hospital.setHpid(item.getHpid());
                hospital.setDutyname(item.getDutyName());
                hospital.setDutyTel3(item.getDutyTel3());
                hospitals.add(hospital);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hospitals;
    }


    private List<HospitalBedAvailability> parseBedAvailability(String xmlResponse) {
        List<HospitalBedAvailability> bedAvailabilities = new ArrayList<>();
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // TypeReference를 사용해 제네릭 타입 정보 전달
            ApiResponse<BedAvailabilityItem> apiResponse = xmlMapper.readValue(
                    xmlResponse,
                    new com.fasterxml.jackson.core.type.TypeReference<ApiResponse<BedAvailabilityItem>>() {}
            );

            for (BedAvailabilityItem item : apiResponse.getBody().getItems()) {
                HospitalBedAvailability bed = new HospitalBedAvailability();
                bed.setHpid(item.getHpid());
                bed.setHvidate(item.getHvidate());
                bed.setHvec(item.getHvec());
                bed.setHvoc(item.getHvoc());
                bed.setHvcc(item.getHvcc());
                bed.setHvncc(item.getHvncc());
                bed.setHvccc(item.getHvccc());
                bed.setHvicc(item.getHvicc());
                bed.setHvgc(item.getHvgc());

                bedAvailabilities.add(bed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bedAvailabilities;
    }


    private List<HospitalEmergencyInfo> parseEmergencyInfo(String xmlResponse) {
        List<HospitalEmergencyInfo> emergencyInfos = new ArrayList<>();
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // TypeReference를 사용해 제네릭 타입 정보 전달
            ApiResponse<EmergencyInfoItem> apiResponse = xmlMapper.readValue(
                    xmlResponse,
                    new com.fasterxml.jackson.core.type.TypeReference<ApiResponse<EmergencyInfoItem>>() {}
            );

            for (EmergencyInfoItem item : apiResponse.getBody().getItems()) {
                HospitalEmergencyInfo info = new HospitalEmergencyInfo();
                info.setDutyAddr(item.getDutyAddr());
                info.setDutyEmcls(item.getDutyEmcls());
                info.setDutyEmclsName(item.getDutyEmclsName());
                info.setWgs84Lon(item.getWgs84Lon());
                info.setWgs84Lat(item.getWgs84Lat());
                emergencyInfos.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emergencyInfos;
    }

}







