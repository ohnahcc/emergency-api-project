package com.example.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Value("${SPRING_DATASOURCE_JDBC_URL}")
    private String datasourceUrl;

    @Value("${SPRING_DATASOURCE_USERNAME}")
    private String datasourceUsername;

    @Value("${SPRING_DATASOURCE_PASSWORD}")
    private String datasourcePassword;

    @Bean
    public Flyway primaryFlyway() {
        // 환경변수를 통해 첫 번째 데이터베이스 Flyway 설정
        return Flyway.configure()
                .dataSource(
                        datasourceUrl,       // 환경변수로 가져온 DB URL
                        datasourceUsername,  // 환경변수로 가져온 DB 사용자
                        datasourcePassword   // 환경변수로 가져온 DB 비밀번호
                )
                .locations("classpath:db/migration")
                .baselineOnMigrate(true) // 기존 데이터베이스 초기화를 허용
                .cleanDisabled(true)     // Flyway clean 방지
                .load();
    }

    @Bean
    public void migrateDatabases() {
        // Flyway Bean을 통해 마이그레이션 수행
        primaryFlyway().migrate();
        System.out.println("Primary database migration completed!");
    }
}


