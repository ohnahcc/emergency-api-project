package com.example.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * RestTemplate 빈 설정
     * RestTemplate은 HTTP 요청 및 응답 처리를 위한 Spring 제공 유틸리티입니다.
     *
     * @param builder RestTemplateBuilder를 통해 RestTemplate을 생성합니다.
     * @return RestTemplate 인스턴스
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * XmlMapper 빈 설정
     * XmlMapper는 Jackson 라이브러리에서 XML 데이터를 매핑하기 위한 클래스입니다.
     * JavaTimeModule을 등록하여 날짜와 시간 형식을 지원하고,
     * 타임스탬프 비활성화를 통해 읽기 쉬운 형식으로 처리합니다.
     *
     * @return XmlMapper 인스턴스
     */
    @Bean
    public XmlMapper xmlMapper() {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule()); // Java 8 날짜 및 시간 지원
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // 타임스탬프 비활성화
        return xmlMapper;
    }
}

