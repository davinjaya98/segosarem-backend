package com.segosarem.web.webservices.bean.customdata;

import com.segosarem.web.webservices.bean.customdatavalue.CustomDataValueBean;
import com.segosarem.web.webservices.bean.customdatagroup.CustomDataGroupBean;
import java.util.Set;
import java.util.LinkedHashSet;

public class CustomDataBean {

	private int cdId;
    private String cdName;
    //This is the list of value
    private Set<CustomDataValueBean> cdValueList = new LinkedHashSet<CustomDataValueBean>();
    //This is for type
    //Can be implemented this way
    //1 - Single
    //2 - Array
    //3 - Multifield
    private Integer cdType;
    //This is for data presentation sequence
    private String cdSequence;
    private CustomDataGroupBean customDataGroup;
    
    public CustomDataBean() {
    }

    public CustomDataBean(int cdId, String cdName, Set<CustomDataValueBean> cdValueList, Integer cdType, String cdSequence, CustomDataGroupBean customDataGroup) {
        this.cdId = cdId;
        this.cdName = cdName;
        this.cdValueList = cdValueList;
        this.cdType = cdType;
        this.cdSequence = cdSequence;
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

    public Set<CustomDataValueBean> getCdValueList() {
        return this.cdValueList;
    }

    public void setCdValueList(Set<CustomDataValueBean> cdValueList) {
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

    public CustomDataGroupBean getCustomDataGroup() {
        return this.customDataGroup;
    }

    public void setCustomDataGroup(CustomDataGroupBean customDataGroup) {
        this.customDataGroup = customDataGroup;
    }
}