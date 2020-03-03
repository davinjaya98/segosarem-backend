package com.segosarem.web.webservices.bean.customdata;

import java.util.List;
import java.util.Map;

public class CustomDataBean {

    //For response
    private Integer cdId;
    private List<Map<String, Object>> cdValuePair;

    private String cdName;
    private Integer cdType;
    private String cdSequence;
    private String cdKey;

    private Integer cdGroupId;
    

    public CustomDataBean() {
    }

    public CustomDataBean(Integer cdId, List<Map<String,Object>> cdValuePair, String cdName, Integer cdType, String cdSequence, String cdKey, Integer cdGroupId) {
        this.cdId = cdId;
        this.cdValuePair = cdValuePair;
        this.cdName = cdName;
        this.cdType = cdType;
        this.cdSequence = cdSequence;
        this.cdKey = cdKey;
        this.cdGroupId = cdGroupId;
    }

    public Integer getCdId() {
        return this.cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }

    public List<Map<String,Object>> getCdValuePair() {
        return this.cdValuePair;
    }

    public void setCdValuePair(List<Map<String,Object>> cdValuePair) {
        this.cdValuePair = cdValuePair;
    }

    public String getCdName() {
        return this.cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    public Integer getCdType() {
        return this.cdType;
    }

    public void setCdType(Integer cdType) {
        this.cdType = cdType;
    }

    public String getCdSequence() {
        return this.cdSequence;
    }

    public void setCdSequence(String cdSequence) {
        this.cdSequence = cdSequence;
    }

    public String getCdKey() {
        return this.cdKey;
    }

    public void setCdKey(String cdKey) {
        this.cdKey = cdKey;
    }

    public Integer getCdGroupId() {
        return this.cdGroupId;
    }

    public void setCdGroupId(Integer cdGroupId) {
        this.cdGroupId = cdGroupId;
    }
}