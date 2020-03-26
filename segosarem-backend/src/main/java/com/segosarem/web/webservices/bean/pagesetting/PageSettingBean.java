package com.segosarem.web.webservices.bean.pagesetting;

import java.util.List;

import com.segosarem.web.webservices.bean.customdatagroup.CustomDataGroupBean;

public class PageSettingBean {
    
	//For Response
	private Integer settingId;

    private String pageTitle;
	private String pageSeoKeywords;
    private String pageKey;

	//For Response
    private List<CustomDataGroupBean> customDataGroupList;
    
    public PageSettingBean() {
    }

    public PageSettingBean(Integer settingId, String pageTitle, String pageSeoKeywords, String pageKey, List<CustomDataGroupBean> customDataGroupList) {
        this.settingId = settingId;
        this.pageTitle = pageTitle;
        this.pageSeoKeywords = pageSeoKeywords;
        this.pageKey = pageKey;
        this.customDataGroupList = customDataGroupList;
    }

    public Integer getSettingId() {
        return this.settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public String getPageTitle() {
        return this.pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageSeoKeywords() {
        return this.pageSeoKeywords;
    }

    public void setPageSeoKeywords(String pageSeoKeywords) {
        this.pageSeoKeywords = pageSeoKeywords;
    }

    public String getPageKey() {
        return this.pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey;
    }

    public List<CustomDataGroupBean> getCustomDataGroupList() {
        return this.customDataGroupList;
    }

    public void setCustomDataGroupList(List<CustomDataGroupBean> customDataGroupList) {
        this.customDataGroupList = customDataGroupList;
    }
}