package com.example.service;

import com.example.api.BedStatusApiClient;
import com.example.api.HospitalInfoApiClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiTestService {
    private final BedStatusApiClient bedStatusApiClient;
    private final HospitalInfoApiClient hospitalInfoApiClient;

    public ApiTestService(BedStatusApiClient bedStatusApiClient, HospitalInfoApiClient hospitalInfoApiClient) {
        this.bedStatusApiClient = bedStatusApiClient;
        this.hospitalInfoApiClient = hospitalInfoApiClient;
    }

    public void testApiCalls() {
        // 병상 정보 호출
        List<String> districts = List.of("강남구", "서초구", "송파구");
        String stage1 = "서울특별시";

        for (String district : districts) {
            try {
                System.out.println("Fetching Bed Status for: " + district);
                String bedStatusResponse = bedStatusApiClient.fetchBedStatus(stage1, district);
                System.out.println("Bed Status Response for " + district + ":\n" + bedStatusResponse);

                // 호출 간 대기 시간 추가
                Thread.sleep(1000); // 1초 대기
            } catch (Exception e) {
                System.err.println("Error fetching Bed Status for " + district + ": " + e.getMessage());
            }
        }

        // 병원 정보 호출
        try {
            System.out.println("Fetching Hospital Info for region: 서울특별시");
            String hospitalInfoResponse = hospitalInfoApiClient.fetchHospitalInfo("서울특별시", 100);
            System.out.println("Hospital Info Response:\n" + hospitalInfoResponse);
        } catch (Exception e) {
            System.err.println("Error fetching Hospital Info: " + e.getMessage());
        }
    }
}




