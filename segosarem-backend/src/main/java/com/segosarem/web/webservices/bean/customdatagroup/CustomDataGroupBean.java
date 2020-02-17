package com.segosarem.web.webservices.bean.customdatagroup;

import com.segosarem.web.webservices.bean.customdata.CustomDataBean;
import java.util.List;
import java.util.ArrayList;

public class CustomDataGroupBean {

	private Integer cdGroupId;
	private String cdGroupName;
	private String cdGroupDescription;
    private List<CustomDataBean> customDataBeanList = new ArrayList<CustomDataBean>();

    private int pageSettingId;
    
    public CustomDataGroupBean() {
    }

    public CustomDataGroupBean(Integer cdGroupId, String cdGroupName, String cdGroupDescription, List<CustomDataBean> customDataBeanList, int pageSettingId) {
        this.cdGroupId = cdGroupId;
        this.cdGroupName = cdGroupName;
        this.cdGroupDescription = cdGroupDescription;
        this.customDataBeanList = customDataBeanList;
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

    public List<CustomDataBean> getCustomDataBeanList() {
        return this.customDataBeanList;
    }

    public void setCustomDataBeanList(List<CustomDataBean> customDataBeanList) {
        this.customDataBeanList = customDataBeanList;
    }
	
    public int getPageSettingId() {
        return this.pageSettingId;
    }

    public void setPageSettingId(int pageSettingId) {
        this.pageSettingId = pageSettingId;
    }
}
