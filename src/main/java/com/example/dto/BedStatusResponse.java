package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BedStatusResponse {
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

            @JacksonXmlProperty(localName = "hvidate")
            @JsonFormat(pattern = "yyyyMMddHHmmss")
            private LocalDateTime hvidate;

            @JacksonXmlProperty(localName = "hvec")
            private Integer hvec;

            @JacksonXmlProperty(localName = "hvcc")
            private Integer hvcc;

            @JacksonXmlProperty(localName = "hvncc")
            private Integer hvncc;

            @JacksonXmlProperty(localName = "hvccc")
            private Integer hvccc;

            @JacksonXmlProperty(localName = "hvicc")
            private Integer hvicc;

            @JacksonXmlProperty(localName = "hvgc")
            private Integer hvgc;

            @JacksonXmlProperty(localName = "dutyName")
            private String dutyName;

            @JacksonXmlProperty(localName = "dutyTel3")
            private String dutyTel3;
        }
    }
}


