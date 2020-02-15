package com.segosarem.web.webservices.bean.customdatavalue;

import com.segosarem.web.webservices.bean.customdata.CustomDataBean;
import java.util.LinkedHashSet;
import java.util.Set;

public class CustomDataValueBean {

	private int cdValueId;
    //This is in byte[]
    private byte[] cdValue;
    //0 - Multifield parent
    //1 - Textfield / Path Field (For Images)
    //2 - Boolean
    private Integer cdValueType;
    private Integer cdValueLevel;

    //Usable for Array and Multifield only
    //0 - no sequence
    private Integer cdValueSequence;

    private CustomDataBean customData;
    
    //Recursive for Multifield Type
    private CustomDataValueBean parentValue;
    private Set<CustomDataValueBean> childValueList = new LinkedHashSet<CustomDataValueBean>();

    public CustomDataValueBean() {
    }

    public CustomDataValueBean(int cdValueId, byte[] cdValue, CustomDataBean customData) {
        this.cdValueId = cdValueId;
        this.cdValue = cdValue;
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

	public Set<CustomDataValueBean> getChildValueList() {
        return this.childValueList;
    }

    public void setChildValueList(Set<CustomDataValueBean> childValueList) {
        this.childValueList = childValueList;
    }
}