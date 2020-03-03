package com.segosarem.web.webservices.bean.customdatagroup;

public class CustomDataGroupBean {

	private Integer cdGroupId;
	private String cdGroupName;
	private String cdGroupDescription;

    private int pageSettingId;
    
    public CustomDataGroupBean() {
    }

    public CustomDataGroupBean(Integer cdGroupId, String cdGroupName, String cdGroupDescription, int pageSettingId) {
        this.cdGroupId = cdGroupId;
        this.cdGroupName = cdGroupName;
        this.cdGroupDescription = cdGroupDescription;
        this.pageSettingId = pageSettingId;
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
}
