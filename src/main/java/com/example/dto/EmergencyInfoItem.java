package com.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmergencyInfoItem {

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

    public String getDutyAddr() {
        return dutyAddr;
    }

    public void setDutyAddr(String dutyAddr) {
        this.dutyAddr = dutyAddr;
    }

    public String getDutyEmcls() {
        return dutyEmcls;
    }

    public void setDutyEmcls(String dutyEmcls) {
        this.dutyEmcls = dutyEmcls;
    }

    public String getDutyEmclsName() {
        return dutyEmclsName;
    }

    public void setDutyEmclsName(String dutyEmclsName) {
        this.dutyEmclsName = dutyEmclsName;
    }

    public Double getWgs84Lon() {
        return wgs84Lon;
    }

    public void setWgs84Lon(Double wgs84Lon) {
        this.wgs84Lon = wgs84Lon;
    }

    public Double getWgs84Lat() {
        return wgs84Lat;
    }

    public void setWgs84Lat(Double wgs84Lat) {
        this.wgs84Lat = wgs84Lat;
    }
}
