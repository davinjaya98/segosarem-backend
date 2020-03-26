package com.segosarem.web.webservices.bean.customdatagroup;

import java.util.List;

import com.segosarem.web.webservices.bean.customdata.CustomDataBean;

public class CustomDataGroupBean {

	private Integer cdGroupId;
	private String cdGroupName;
	private String cdGroupDescription;

    private int pageSettingId;

	//For Response
    private List<CustomDataBean> customDataList;
    
    public CustomDataGroupBean() {
    }

    public CustomDataGroupBean(Integer cdGroupId, String cdGroupName, String cdGroupDescription, int pageSettingId, List<CustomDataBean> customDataList) {
        this.cdGroupId = cdGroupId;
        this.cdGroupName = cdGroupName;
        this.cdGroupDescription = cdGroupDescription;
        this.pageSettingId = pageSettingId;
        this.customDataList = customDataList;
    }

    public Integer getCdGroupId() {
        return this.cdGroupId;
    }

    public void setCdGroupId(Integer cdGroupId) {
        this.cdGroupId = cdGroupId;
    }

    public String getCdGroupName() {
        return this.cdGroupName;
    }

    public void setCdGroupName(String cdGroupName) {
        this.cdGroupName = cdGroupName;
    }

    public String getCdGroupDescription() {
        return this.cdGroupDescription;
    }

    public void setCdGroupDescription(String cdGroupDescription) {
        this.cdGroupDescription = cdGroupDescription;
    }

    public int getPageSettingId() {
        return this.pageSettingId;
    }

    public void setPageSettingId(int pageSettingId) {
        this.pageSettingId = pageSettingId;
    }

    public List<CustomDataBean> getCustomDataList() {
        return this.customDataList;
    }

    public void setCustomDataList(List<CustomDataBean> customDataList) {
        this.customDataList = customDataList;
    }
}