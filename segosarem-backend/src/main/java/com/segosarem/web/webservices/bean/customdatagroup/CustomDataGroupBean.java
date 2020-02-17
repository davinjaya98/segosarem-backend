package com.segosarem.web.webservices.bean.customdatagroup;

import com.segosarem.web.webservices.bean.customdata.CustomDataBean;
import com.segosarem.web.webservices.bean.pagesetting.PageSettingBean;
import java.util.List;
import java.util.ArrayList;

public class CustomDataGroupBean {

	private int cdGroupId;
	private String cdGroupName;
	private String cdGroupDescription;
    private List<CustomDataBean> customDataList = new ArrayList<CustomDataBean>();
    private PageSettingBean pageSetting;
    
    public CustomDataGroupBean() {
    }

    public CustomDataGroupBean(int cdGroupId, String cdGroupName, String cdGroupDescription, List<CustomDataBean> customDataList, PageSettingBean pageSetting) {
        this.cdGroupId = cdGroupId;
        this.cdGroupName = cdGroupName;
        this.cdGroupDescription = cdGroupDescription;
        this.customDataList = customDataList;
        this.pageSetting = pageSetting;
    }

    public int getCdGroupId() {
        return this.cdGroupId;
    }

    public void setCdGroupId(int cdGroupId) {
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

    public List<CustomDataBean> getCustomDataList() {
        return this.customDataList;
    }

    public void setCustomDataList(List<CustomDataBean> customDataList) {
        this.customDataList = customDataList;
    }
	
    public PageSettingBean getPageSetting() {
        return this.pageSetting;
    }

    public void setPageSetting(PageSettingBean pageSetting) {
        this.pageSetting = pageSetting;
    }
}
