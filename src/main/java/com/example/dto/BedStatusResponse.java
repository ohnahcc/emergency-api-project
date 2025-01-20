package com.example.dto;

import com.example.util.YesNoToBooleanDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

            @JacksonXmlProperty(localName = "hvoc")
            private Integer hvoc;

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

            @JacksonXmlProperty(localName = "hv2")
            private Integer hv2;

            @JacksonXmlProperty(localName = "hv3")
            private Integer hv3;

            @JacksonXmlProperty(localName = "hv4")
            private Integer hv4;

            @JacksonXmlProperty(localName = "hv5")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hv5;

            @JacksonXmlProperty(localName = "hv6")
            private Integer hv6;

            @JacksonXmlProperty(localName = "hv7")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hv7;

            @JacksonXmlProperty(localName = "hv8")
            private Integer hv8;

            @JacksonXmlProperty(localName = "hv9")
            private Integer hv9;

            @JacksonXmlProperty(localName = "hv10")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hv10;

            @JacksonXmlProperty(localName = "hv11")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hv11;

            @JacksonXmlProperty(localName = "hv13")
            private Integer hv13;

            @JacksonXmlProperty(localName = "hv14")
            private Integer hv14;

            @JacksonXmlProperty(localName = "hv15")
            private Integer hv15;

            @JacksonXmlProperty(localName = "hv16")
            private Integer hv16;

            @JacksonXmlProperty(localName = "hv17")
            private Integer hv17;

            @JacksonXmlProperty(localName = "hv18")
            private Integer hv18;

            @JacksonXmlProperty(localName = "hv19")
            private Integer hv19;

            @JacksonXmlProperty(localName = "hv21")
            private Integer hv21;

            @JacksonXmlProperty(localName = "hv22")
            private Integer hv22;

            @JacksonXmlProperty(localName = "hv23")
            private Integer hv23;

            @JacksonXmlProperty(localName = "hv24")
            private Integer hv24;

            @JacksonXmlProperty(localName = "hv25")
            private Integer hv25;

            @JacksonXmlProperty(localName = "hv26")
            private Integer hv26;

            @JacksonXmlProperty(localName = "hv27")
            private Integer hv27;

            @JacksonXmlProperty(localName = "hv28")
            private Integer hv28;

            @JacksonXmlProperty(localName = "hv29")
            private Integer hv29;

            @JacksonXmlProperty(localName = "hv30")
            private Integer hv30;

            @JacksonXmlProperty(localName = "hv31")
            private Integer hv31;

            @JacksonXmlProperty(localName = "hv32")
            private Integer hv32;

            @JacksonXmlProperty(localName = "hv33")
            private Integer hv33;

            @JacksonXmlProperty(localName = "hv34")
            private Integer hv34;

            @JacksonXmlProperty(localName = "hv35")
            private Integer hv35;

            @JacksonXmlProperty(localName = "hv36")
            private Integer hv36;

            @JacksonXmlProperty(localName = "hv37")
            private Integer hv37;

            @JacksonXmlProperty(localName = "hv38")
            private Integer hv38;

            @JacksonXmlProperty(localName = "hv39")
            private Integer hv39;

            @JacksonXmlProperty(localName = "hv40")
            private Integer hv40;

            @JacksonXmlProperty(localName = "hv41")
            private Integer hv41;

            @JacksonXmlProperty(localName = "hv42")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hv42;

            @JacksonXmlProperty(localName = "hv43")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hv43;

            @JacksonXmlProperty(localName = "hvctayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvctayn;

            @JacksonXmlProperty(localName = "hvmriayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvmriayn;

            @JacksonXmlProperty(localName = "hvangioayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvangioayn;

            @JacksonXmlProperty(localName = "hvventiayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvventiayn;

            @JacksonXmlProperty(localName = "hvventisoayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvventisoayn;

            @JacksonXmlProperty(localName = "hvincuayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvincuayn;

            @JacksonXmlProperty(localName = "hvcrrtayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvcrrtayn;

            @JacksonXmlProperty(localName = "hvecmoayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvecmoayn;

            @JacksonXmlProperty(localName = "hvoxyayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvoxyayn;

            @JacksonXmlProperty(localName = "hvhypoayn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvhypoayn;

            @JacksonXmlProperty(localName = "hvamyn")
            @JsonDeserialize(using = YesNoToBooleanDeserializer.class)
            private Boolean hvamyn;

            @JacksonXmlProperty(localName = "dutyName")
            private String dutyName;

            @JacksonXmlProperty(localName = "dutyTel3")
            private String dutyTel3;

            @JacksonXmlProperty(localName = "hvs01")
            private Integer hvs01; // 일반 병상 기준

        }
    }
}





