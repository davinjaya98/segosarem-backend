package com.segosarem.web.webservices.bean.customdatavalue;

import com.segosarem.web.webservices.bean.customdata.CustomDataBean;
import java.util.List;
import java.util.ArrayList;

public class CustomDataValueBean {

	private int cdValueId;
    private byte[] cdValue;
    private Integer cdValueType;
    private Integer cdValueLevel;
    private Integer cdValueSequence;
    private CustomDataBean customData;
    private CustomDataValueBean parentValue;
    private List<CustomDataValueBean> childValueList = new ArrayList<CustomDataValueBean>();

    public CustomDataValueBean() {
    }

    public CustomDataValueBean(int cdValueId, byte[] cdValue, Integer cdValueType, Integer cdValueLevel, Integer cdValueSequence, CustomDataBean customData) {
        this.cdValueId = cdValueId;
        this.cdValue = cdValue;
        this.cdValueType = cdValueType;
        this.cdValueLevel = cdValueLevel;
        this.cdValueSequence = cdValueSequence;
        this.customData = customData;
    }

	public int getCdValueId() {
        return this.cdValueId;
    }

    public void setCdValueId(int cdValueId) {
        this.cdValueId = cdValueId;
    }

    public byte[] getCdValue() {
        return this.cdValue;
    }

    public void setCdValue(byte[] cdValue) {
        this.cdValue = cdValue;
    }

	public Integer getCdValueType() {
        return this.cdValueType;
    }

    public void setCdValueType(Integer cdValueType) {
        this.cdValueType = cdValueType;
    }

	public Integer getCdValueLevel() {
        return this.cdValueLevel;
    }

    public void setCdValueLevel(Integer cdValueLevel) {
        this.cdValueLevel = cdValueLevel;
    }

	public Integer getCdValueSequence() {
        return this.cdValueSequence;
    }

    public void setCdValueSequence(Integer cdValueSequence) {
        this.cdValueSequence = cdValueSequence;
    }
	
	public CustomDataBean getCustomData() {
        return this.customData;
    }

    public void setCustomData(CustomDataBean customData) {
        this.customData = customData;
    }

    //Recursive for Multifield Type
	public CustomDataValueBean getParentValue() {
        return this.parentValue;
    }

    public void setParentValue(CustomDataValueBean parentValue) {
        this.parentValue = parentValue;
    }

	public List<CustomDataValueBean> getChildValueList() {
        return this.childValueList;
    }

    public void setChildValueList(List<CustomDataValueBean> childValueList) {
        this.childValueList = childValueList;
    }
}