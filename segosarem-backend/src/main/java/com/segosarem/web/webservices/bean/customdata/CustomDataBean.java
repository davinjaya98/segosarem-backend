package com.segosarem.web.webservices.bean.customdata;

import com.segosarem.web.webservices.bean.customdatavalue.CustomDataValueBean;
import com.segosarem.web.webservices.bean.customdatagroup.CustomDataGroupBean;
import java.util.List;
import java.util.ArrayList;

public class CustomDataBean {

	private int cdId;
    private String cdName;
    private List<CustomDataValueBean> cdValueList = new ArrayList<CustomDataValueBean>();
    private Integer cdType;
    private String cdSequence;
    private String cdKey;
    private CustomDataGroupBean customDataGroup;
    
    public CustomDataBean() {
    }

    public CustomDataBean(int cdId, String cdName, List<CustomDataValueBean> cdValueList, Integer cdType, String cdSequence, String cdKey, CustomDataGroupBean customDataGroup) {
        this.cdId = cdId;
        this.cdName = cdName;
        this.cdValueList = cdValueList;
        this.cdType = cdType;
        this.cdSequence = cdSequence;
        this.cdKey = cdKey;
        this.customDataGroup = customDataGroup;
    }

    public int getCdId() {
        return this.cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    public String getCdName() {
        return this.cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    public List<CustomDataValueBean> getCdValueList() {
        return this.cdValueList;
    }

    public void setCdValueList(List<CustomDataValueBean> cdValueList) {
        this.cdValueList = cdValueList;
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

    public CustomDataGroupBean getCustomDataGroup() {
        return this.customDataGroup;
    }

    public void setCustomDataGroup(CustomDataGroupBean customDataGroup) {
        this.customDataGroup = customDataGroup;
    }
}