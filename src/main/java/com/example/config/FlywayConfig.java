package com.example.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway primaryFlyway() {
        // 첫 번째 데이터베이스 Flyway 설정
        return Flyway.configure()
                .dataSource(
                        "jdbc:postgresql://postgres-db1:5432/emergency_api", // 첫 번째 DB URL
                        "api_user", // 첫 번째 DB 사용자
                        "1234"      // 첫 번째 DB 비밀번호
                )
                .locations("classpath:db/migration")
                .baselineOnMigrate(true) // 기존 데이터베이스 초기화를 허용
                .cleanDisabled(true)     // Flyway clean 방지
                .load();
    }




    @Bean
    public void migrateDatabases() {
        //  Flyway Bean을 가져와 마이그레이션 수행
        primaryFlyway().migrate();
        System.out.println("Primary database migration completed!");

    }
}

