package com.example.service;

import com.example.api.BedStatusApiClient;
import com.example.api.HospitalInfoApiClient;
import com.example.dto.BedStatusResponse;
import com.example.dto.HospitalInfoResponse;
import com.example.entity.BedStatus;
import com.example.entity.HospitalInfo;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class ApiTestService {
    private final BedStatusApiClient bedStatusApiClient;
    private final HospitalInfoApiClient hospitalInfoApiClient;
    private final BedStatusService bedStatusService;
    private final HospitalInfoService hospitalInfoService;
    private final XmlMapper xmlMapper;

    public ApiTestService(BedStatusApiClient bedStatusApiClient,
                          HospitalInfoApiClient hospitalInfoApiClient,
                          BedStatusService bedStatusService,
                          HospitalInfoService hospitalInfoService,
                          XmlMapper xmlMapper) {
        this.bedStatusApiClient = bedStatusApiClient;
        this.hospitalInfoApiClient = hospitalInfoApiClient;
        this.bedStatusService = bedStatusService;
        this.hospitalInfoService = hospitalInfoService;
        this.xmlMapper = xmlMapper;
    }

    public void testApiCalls() {
        List<String> districts = List.of("강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구",
                "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구",
                "용산구", "은평구", "종로구", "중구", "중랑구");
        for (String district : districts) {
            try {
                String responseXml = bedStatusApiClient.fetchBedStatus("서울특별시", district);
                List<BedStatus> bedStatusList = parseBedStatus(responseXml);
                for (BedStatus bedStatus : bedStatusList) {
                    bedStatusService.save(bedStatus);
                }
            } catch (Exception e) {
                System.err.println("Error parsing BedStatus for district " + district + ": " + e.getMessage());
            }
        }

        try {
            String responseXml = hospitalInfoApiClient.fetchHospitalInfo("서울특별시", 100);
            List<HospitalInfo> hospitalInfoList = parseHospitalInfo(responseXml);
            for (HospitalInfo hospitalInfo : hospitalInfoList) {
                hospitalInfoService.save(hospitalInfo);
            }
        } catch (Exception e) {
            System.err.println("Error parsing HospitalInfo: " + e.getMessage());
        }
    }

    private List<BedStatus> parseBedStatus(String xml) {
        try {
            BedStatusResponse response = xmlMapper.readValue(xml, BedStatusResponse.class);
            List<BedStatusResponse.Body.Item> items = response.getBody().getItems();

            return items.stream().map(item -> {
                BedStatus bedStatus = new BedStatus();
                bedStatus.setHpid(item.getHpid());
                bedStatus.setHvidate(item.getHvidate());
                bedStatus.setHvec(item.getHvec());
                bedStatus.setHvcc(item.getHvcc());
                bedStatus.setHvncc(item.getHvncc());
                bedStatus.setHvccc(item.getHvccc());
                bedStatus.setHvicc(item.getHvicc());
                bedStatus.setHvgc(item.getHvgc());
                bedStatus.setDutyName(item.getDutyName());
                bedStatus.setDutyTel3(item.getDutyTel3());
                return bedStatus;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse BedStatus XML", e);
        }
    }

    private List<HospitalInfo> parseHospitalInfo(String xml) {
        try {
            HospitalInfoResponse response = xmlMapper.readValue(xml, HospitalInfoResponse.class);
            List<HospitalInfoResponse.Body.Item> items = response.getBody().getItems();

            return items.stream().map(item -> {
                HospitalInfo hospitalInfo = new HospitalInfo();
                hospitalInfo.setHpid(item.getHpid());
                hospitalInfo.setDutyName(item.getDutyName());
                hospitalInfo.setDutyAddr(item.getDutyAddr());
                hospitalInfo.setDutyEmcls(item.getDutyEmcls());
                hospitalInfo.setDutyEmclsName(item.getDutyEmclsName());
                hospitalInfo.setWgs84Lon(item.getWgs84Lon());
                hospitalInfo.setWgs84Lat(item.getWgs84Lat());
                return hospitalInfo;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse HospitalInfo XML", e);
        }
    }
}













