package com.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchedulerService {

    private final ApiTestService apiTestService;

    /**
     * 1. 일주일마다 Hospital 및 HospitalEmergencyInfo 업데이트 (매주 월요일 자정 실행)
     */
    @Scheduled(cron = "0 0 0 * * MON")
//    @Scheduled(cron = "*/30 * * * * *")
    public void updateHospitalAndEmergencyInfo() {
        log.info("Starting weekly update for hospitals and emergency info...");
        try {
            apiTestService.processHospitalInfo();
            log.info("Weekly update completed.");
        } catch (Exception e) {
            log.error("Error during weekly update: {}", e.getMessage(), e);
        }
    }

    /**
     * 2. 5분마다 HospitalBedAvailability 업데이트
     */
    @Scheduled(cron = "0 */5 * * * *")
    public void updateBedAvailability() {
        log.info("Starting 5-minute update for hospital bed availability...");
        try {
            apiTestService.processBedStatus();
            log.info("5-minute update completed.");
        } catch (Exception e) {
            log.error("Error during 5-minute update: {}", e.getMessage(), e);
        }
    }

    // 새로운 스케줄 작업 추가
    @Scheduled(cron = "0 */5 * * * *")
    public void calculateAndStoreUtilizationRates() {
        log.info("Starting hospital bed utilization rate calculation...");
        try {
            apiTestService.calculateAndStoreUtilizationRatesInSecondDB();
            log.info("Hospital bed utilization rate calculation completed.");
        } catch (Exception e) {
            log.error("Error during hospital bed utilization rate calculation: {}", e.getMessage(), e);
        }
    }

    // 새로운 스케줄 작업 추가
    @Scheduled(cron = "0 */5 * * * *")
    public void calculateUtilizationRates() {
        log.info("Starting hospital bed utilization rate calculation...");
        try {
            apiTestService.calculateUtilizationRatesInSecondDB();
            log.info("Hospital bed utilization rate calculation completed.");
        } catch (Exception e) {
            log.error("Error during hospital bed utilization rate calculation: {}", e.getMessage(), e);
        }
    }



}

