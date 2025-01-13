package com.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalItem {

    @JacksonXmlProperty(localName = "hpid")
    private String hpid;

    @JacksonXmlProperty(localName = "dutyName")
    private String dutyName;

    @JacksonXmlProperty(localName = "dutyTel3")
    private String dutyTel3;

    public String getHpid() {
        return hpid;
    }

    public void setHpid(String hpid) {
        this.hpid = hpid;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getDutyTel3() {
        return dutyTel3;
    }

    public void setDutyTel3(String dutyTel3) {
        this.dutyTel3 = dutyTel3;
    }
}
