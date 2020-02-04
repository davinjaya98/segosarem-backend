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
@Table(name = "custom_data_group", catalog = "segosarem_db")
public class CustomDataGroup extends GeneralCreateModify implements Serializable {

	private int cdGroupId;
	private String cdGroupName;
	private String cdGroupDescription;
    private String cdGroupKey;
    private Set<CustomData> customDataList = new LinkedHashSet<CustomData>();
    
    public CustomDataGroup() {
    }

    public CustomDataGroup(int cdGroupId, String cdGroupName, String cdGroupDescription, String cdGroupKey, Set<CustomData> customDataList) {
        this.cdGroupId = cdGroupId;
        this.cdGroupName = cdGroupName;
        this.cdGroupDescription = cdGroupDescription;
        this.cdGroupKey = cdGroupKey;
        this.customDataList = customDataList;
    }

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cd_group_id", unique = true, nullable = false)
    public int getCdGroupId() {
        return this.cdGroupId;
    }

    public void setCdGroupId(int cdGroupId) {
        this.cdGroupId = cdGroupId;
    }

	@Column(name = "cd_group_name")
    public String getCdGroupName() {
        return this.cdGroupName;
    }

    public void setCdGroupName(String cdGroupName) {
        this.cdGroupName = cdGroupName;
    }

	@Column(name = "cd_group_description")
    public String getCdGroupDescription() {
        return this.cdGroupDescription;
    }

    public void setCdGroupDescription(String cdGroupDescription) {
        this.cdGroupDescription = cdGroupDescription;
    }

	@Column(name = "cd_group_key")
    public String getCdGroupKey() {
        return this.cdGroupKey;
    }

    public void setCdGroupKey(String cdGroupKey) {
        this.cdGroupKey = cdGroupKey;
    }

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customDataGroup")
    public Set<CustomData> getCustomDataList() {
        return this.customDataList;
    }

    public void setCustomDataList(Set<CustomData> customDataList) {
        this.customDataList = customDataList;
    }
}
