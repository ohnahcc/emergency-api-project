package com.example;

import com.example.service.ApiTestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 트랜잭션 관리를 활성화
@EnableScheduling // 스케줄링 활성화
public class MainApplication implements CommandLineRunner {

    private final ApiTestService apiTestService;

    /**
     * 생성자 주입 방식으로 ApiTestService 의존성 주입
     *
     * @param apiTestService API 데이터를 처리하는 서비스
     */
    public MainApplication(ApiTestService apiTestService) {
        this.apiTestService = apiTestService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    /**
     * 애플리케이션 시작 시 API 데이터를 호출하고 처리하는 메서드
     *
     * @param args 커맨드라인 인자
     * @throws Exception 예외 처리
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting API Data Processing...");
        try {
            apiTestService.testApiCalls(); // API 데이터 처리 호출
            System.out.println("API Data Processing Completed Successfully.");
        } catch (Exception e) {
            System.err.println("Error during API Data Processing: " + e.getMessage());
        }
    }
}






