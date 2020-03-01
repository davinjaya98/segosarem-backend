package com.segosarem.web.webservices.bean.customdatasetting;

import com.segosarem.web.webservices.bean.customdatavalue.CustomDataValueBean;
import com.segosarem.web.webservices.bean.customdatagroup.CustomDataGroupBean;
import java.util.List;
import java.util.ArrayList;

public class CustomDataSettingBean {

    //For Response
    private Integer cdsId;

    private String cdsName;
    private Integer cdsType;
    // This is for data presentation sequence
    private String cdsSequence;

    private Integer cdId;

    public CustomDataSettingBean() {
    }

    public CustomDataSettingBean(Integer cdsId, String cdsName, Integer cdsType, String cdsSequence, Integer cdId) {
        this.cdsId = cdsId;
        this.cdsName = cdsName;
        this.cdsType = cdsType;
        this.cdsSequence = cdsSequence;
        this.cdId = cdId;
    }

    public Integer getCdsId() {
        return this.cdsId;
    }

    public void setCdsId(Integer cdsId) {
        this.cdsId = cdsId;
    }

    public String getCdsName() {
        return this.cdsName;
    }

    public void setCdsName(String cdsName) {
        this.cdsName = cdsName;
    }

    public Integer getCdsType() {
        return this.cdsType;
    }

    public void setCdsType(Integer cdsType) {
        this.cdsType = cdsType;
    }

    public String getCdsSequence() {
        return this.cdsSequence;
    }

    public void setCdsSequence(String cdsSequence) {
        this.cdsSequence = cdsSequence;
    }

    public Integer getCdId() {
        return this.cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }
}