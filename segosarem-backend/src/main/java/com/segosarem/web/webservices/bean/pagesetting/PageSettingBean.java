package com.segosarem.web.webservices.bean.pagesetting;

public class PageSettingBean {
    
	//For Response
	private Integer settingId;

    private String pageTitle;
	private String pageSeoKeywords;
    private String pageKey;
    
    private Character status;

	public PageSettingBean() {}

	public PageSettingBean(Integer settingId, String pageTitle, String pageSeoKeywords, String pageKey, Character status) {
		this.settingId = settingId;
		this.pageTitle = pageTitle;
		this.pageSeoKeywords = pageSeoKeywords;
        this.pageKey = pageKey;
        this.status = status;
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
	
    public Character getStatus() {
        return this.status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}