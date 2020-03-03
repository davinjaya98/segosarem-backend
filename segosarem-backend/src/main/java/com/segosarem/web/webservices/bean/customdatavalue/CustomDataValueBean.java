package com.segosarem.web.webservices.bean.customdatavalue;

public class CustomDataValueBean {

    //For response
    private Integer cdValueId;
    
    //Get as base64
    private String cdValue;
    
    private Integer cdsId;

    public CustomDataValueBean() {
    }

    public CustomDataValueBean(Integer cdValueId, String cdValue, Integer cdsId) {
        this.cdValueId = cdValueId;
        this.cdValue = cdValue;
        this.cdsId = cdsId;
    }

    public Integer getCdValueId() {
        return this.cdValueId;
    }

    public void setCdValueId(Integer cdValueId) {
        this.cdValueId = cdValueId;
    }

    public String getCdValue() {
        return this.cdValue;
    }

    public void setCdValue(String cdValue) {
        this.cdValue = cdValue;
    }

    public Integer getCdsId() {
        return this.cdsId;
    }

    public void setCdsId(Integer cdsId) {
        this.cdsId = cdsId;
    }
}