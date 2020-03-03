package com.segosarem.web.webservices.db.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.LinkedHashSet;
import java.util.Set;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "custom_data", catalog = "segosarem_db")
public class CustomData extends GeneralCreateModify implements Serializable {

	private int cdId;
    private String cdName;
    //This is the list of value
    private Set<CustomDataValue> cdValueList = new LinkedHashSet<CustomDataValue>();
    //This is the list of setting for the custom data
    private Set<CustomDataSetting> cdSettingList = new LinkedHashSet<CustomDataSetting>();
    //This is for type
    //Can be implemented this way
    //1 - Single
    //2 - Array
    //3 - Multifield
    private Integer cdType;
    //This is for data presentation sequence
    private String cdSequence;

    private String cdKey;
    private CustomDataGroup customDataGroup;
    
    public CustomData() {
    }

    public CustomData(int cdId, String cdName, Set<CustomDataValue> cdValueList, Set<CustomDataSetting> cdSettingList, Integer cdType, String cdSequence, String cdKey, CustomDataGroup customDataGroup) {
        this.cdId = cdId;
        this.cdName = cdName;
        this.cdValueList = cdValueList;
        this.cdSettingList = cdSettingList;
        this.cdType = cdType;
        this.cdSequence = cdSequence;
        this.cdKey = cdKey;
        this.customDataGroup = customDataGroup;
    }

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cd_id", unique = true, nullable = false)
    public int getCdId() {
        return this.cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

	@Column(name = "cd_name")
    public String getCdName() {
        return this.cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customData")
    public Set<CustomDataValue> getCdValueList() {
        return this.cdValueList;
    }

    public void setCdValueList(Set<CustomDataValue> cdValueList) {
        this.cdValueList = cdValueList;
    }

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customData")
    public Set<CustomDataSetting> getCdSettingList() {
        return this.cdSettingList;
    }

    public void setCdSettingList(Set<CustomDataSetting> cdSettingList) {
        this.cdSettingList = cdSettingList;
    }

	@Column(name = "cd_type")
    public Integer getCdType() {
        return this.cdType;
    }

    public void setCdType(Integer cdType) {
        this.cdType = cdType;
    }

	@Column(name = "cd_sequence")
    public String getCdSequence() {
        return this.cdSequence;
    }

    public void setCdSequence(String cdSequence) {
        this.cdSequence = cdSequence;
    }

	@Column(name = "cd_key", unique = true)
    public String getCdKey() {
        return this.cdKey;
    }

    public void setCdKey(String cdKey) {
        this.cdKey = cdKey;
    }
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_group_id")
    public CustomDataGroup getCustomDataGroup() {
        return this.customDataGroup;
    }

    public void setCustomDataGroup(CustomDataGroup customDataGroup) {
        this.customDataGroup = customDataGroup;
    }
}