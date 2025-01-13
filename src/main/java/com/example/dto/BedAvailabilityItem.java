package com.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BedAvailabilityItem {

    @JacksonXmlProperty(localName = "hpid")
    private String hpid;

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

    @JacksonXmlProperty(localName = "hvidate")
    private String hvidate; // 입력일시

    // Getters and Setters
    public String getHpid() {
        return hpid;
    }

    public void setHpid(String hpid) {
        this.hpid = hpid;
    }

    public Integer getHvec() {
        return hvec;
    }

    public void setHvec(Integer hvec) {
        this.hvec = hvec;
    }

    public Integer getHvoc() {
        return hvoc;
    }

    public void setHvoc(Integer hvoc) {
        this.hvoc = hvoc;
    }

    public Integer getHvcc() {
        return hvcc;
    }

    public void setHvcc(Integer hvcc) {
        this.hvcc = hvcc;
    }

    public Integer getHvncc() {
        return hvncc;
    }

    public void setHvncc(Integer hvncc) {
        this.hvncc = hvncc;
    }

    public Integer getHvccc() {
        return hvccc;
    }

    public void setHvccc(Integer hvccc) {
        this.hvccc = hvccc;
    }

    public Integer getHvicc() {
        return hvicc;
    }

    public void setHvicc(Integer hvicc) {
        this.hvicc = hvicc;
    }

    public Integer getHvgc() {
        return hvgc;
    }

    public void setHvgc(Integer hvgc) {
        this.hvgc = hvgc;
    }

    public String getHvidate() {
        return hvidate;
    }

    public void setHvidate(String hvidate) {
        this.hvidate = hvidate;
    }
}



