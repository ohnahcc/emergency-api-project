package com.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class BedStatusResponse {
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
        private List<BedItem> items;
    }

    @Data
    public static class BedItem {
        private String hpid;
        private String hvidate;
        private int hvec;
        private int hvcc;
        private int hvncc;
        private int hvccc;
        private int hvicc;
        private int hvgc;
        private String dutyname;
        private String dutyTel3;
    }
}

