package com.segosarem.web.webservices.db.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.LinkedHashSet;
import java.util.Set;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "page_setting", catalog = "segosarem_db")
public class PageSetting extends GeneralCreateModify implements Serializable {

	private int settingId;
    private String pageTitle;
    private String pageDescription;
	private String pageSeoKeywords;
    private String pageKey; 
    private Set<CustomDataGroup> customDataGroupList = new LinkedHashSet<CustomDataGroup>();

    public PageSetting() {
    }

    public PageSetting(int settingId, String pageTitle, String pageSeoKeywords, String pageKey) {
        this.settingId = settingId;
        this.pageTitle = pageTitle;
        this.pageSeoKeywords = pageSeoKeywords;
        this.pageKey = pageKey;
    }

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "setting_id", unique = true, nullable = false)
    public int getSettingId() {
        return this.settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

	@Column(name = "page_title")
    public String getPageTitle() {
        return this.pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

	@Column(name = "page_description")
    public String getPageDescription() {
        return this.pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

	@Column(name = "page_seo_keywords")
    public String getPageSeoKeywords() {
        return this.pageSeoKeywords;
    }

    public void setPageSeoKeywords(String pageSeoKeywords) {
        this.pageSeoKeywords = pageSeoKeywords;
    }

	@Column(name = "page_key", unique = true)
    public String getPageKey() {
        return this.pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey;
    }

	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "pageSetting")
    public Set<CustomDataGroup> getCustomDataGroupList() {
        return this.customDataGroupList;
    }

    public void setCustomDataGroupList(Set<CustomDataGroup> customDataGroupList) {
        this.customDataGroupList = customDataGroupList;
    }

}
