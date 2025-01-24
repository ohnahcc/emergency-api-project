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
                        System.getenv("SPRING_DATASOURCE_JDBC_URL"), // 첫 번째 DB URL
                        System.getenv("SPRING_DATASOURCE_USERNAME"), // 첫 번째 DB 사용자
                        System.getenv("SPRING_DATASOURCE_PASSWORD")  // 첫 번째 DB 비밀번호
                )
                .locations("classpath:db/migration")
                .baselineOnMigrate(true) // 기존 데이터베이스 초기화를 허용
                .cleanDisabled(true)     // Flyway clean 방지
                .load();
    }

    @Bean
    public Flyway secondaryFlyway() {
        // 두 번째 데이터베이스 Flyway 설정
        return Flyway.configure()
                .dataSource(
                        System.getenv("SPRING_SECOND_DATASOURCE_JDBC_URL"), // 두 번째 DB URL
                        System.getenv("SPRING_SECOND_DATASOURCE_USERNAME"), // 두 번째 DB 사용자
                        System.getenv("SPRING_SECOND_DATASOURCE_PASSWORD")  // 두 번째 DB 비밀번호
                )
                .locations("classpath:db/secondary_migration")
                .baselineOnMigrate(true) // 기존 데이터베이스 초기화를 허용
                .cleanDisabled(true)     // Flyway clean 방지
                .load();
    }

    @Bean
    public void migrateDatabases() {
        // 두 Flyway Bean을 가져와 마이그레이션 수행
        primaryFlyway().migrate();
        System.out.println("Primary database migration completed!");

        secondaryFlyway().migrate();
        System.out.println("Secondary database migration completed!");
    }
}

