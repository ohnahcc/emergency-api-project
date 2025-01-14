package com.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalInfoResponse {
    private Header header;
    private Body body;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Header {
        @JacksonXmlProperty(localName = "resultCode")
        private String resultCode;

        @JacksonXmlProperty(localName = "resultMsg")
        private String resultMsg;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Body {
        @JacksonXmlElementWrapper(localName = "items")
        @JacksonXmlProperty(localName = "item")
        private List<Item> items;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Item {
            @JacksonXmlProperty(localName = "hpid")
            private String hpid;

            @JacksonXmlProperty(localName = "dutyName")
            private String dutyName;

            @JacksonXmlProperty(localName = "dutyAddr")
            private String dutyAddr;

            @JacksonXmlProperty(localName = "dutyEmcls")
            private String dutyEmcls;

            @JacksonXmlProperty(localName = "dutyEmclsName")
            private String dutyEmclsName;

            @JacksonXmlProperty(localName = "wgs84Lon")
            private Double wgs84Lon;

            @JacksonXmlProperty(localName = "wgs84Lat")
            private Double wgs84Lat;
        }
    }
}


