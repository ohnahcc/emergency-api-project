package com.example.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class HospitalInfoApiClient {

    private final RestTemplate restTemplate;
    private final String baseUrl = "https://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytListInfoInqire";
    private final String apiKey = "B1Gj%2FBOPhahR7ANuHmSVoupUgibJr9oei91tDxNMpVbXpa2VAWfrZWDUc1WISB1JPj1U6mzLC%2BJXA2qJN5y82w%3D%3D";

    public HospitalInfoApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchHospitalInfo(String region, int rows) {
        try {
            // 한글 값 수동 인코딩
            String encodedRegion = URLEncoder.encode(region, StandardCharsets.UTF_8.toString());

            // URI 생성
            URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .queryParam("serviceKey", apiKey)
                    .queryParam("Q0", encodedRegion)
                    .queryParam("numOfRows", rows)
                    .build(true)
                    .toUri();

            System.out.println("Generated URI: " + uri);

            // 요청 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/xml");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            // RestTemplate 호출
            ResponseEntity<String> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            System.out.println("Hospital Info XML Response: \n" + response.getBody());

            return response.getBody();
        } catch (Exception e) {
            System.err.println("Error creating URI or fetching data: " + e.getMessage());
            return null;
        }
    }
}









