package com.example;

import com.example.service.ApiTestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 스케줄링 활성화
public class MainApplication implements CommandLineRunner {
    private final ApiTestService apiTestService;

    // 생성자 주입
    public MainApplication(ApiTestService apiTestService) {
        this.apiTestService = apiTestService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            System.out.println("Starting API Test Calls...");
            apiTestService.testApiCalls(); // 병상 정보 및 병원 정보 호출
            System.out.println("API Test Calls Completed Successfully.");
        } catch (Exception e) {
            System.err.println("Error during API Test Calls: " + e.getMessage());
        }
    }
}





