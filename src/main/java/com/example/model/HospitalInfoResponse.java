package com.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class HospitalInfoResponse {
    private Header header;
    private Body body;

    @Data
    public static class Header {
        @JacksonXmlProperty(localName = "resultCode")
        private String resultCode;

        @JacksonXmlProperty(localName = "resultMsg")
        private String resultMsg;
    }

    @Data
    public static class Body {
        @JacksonXmlElementWrapper(localName = "items")
        @JacksonXmlProperty(localName = "item")
        private List<HospitalItem> items;
    }

    @Data
    public static class HospitalItem {
        private String hpid;
        private String dutyAddr;
        private String dutyEmcls;
        private String dutyEmclsName;
        private String wgs84Lon;
        private String wgs84Lat;
    }
}

