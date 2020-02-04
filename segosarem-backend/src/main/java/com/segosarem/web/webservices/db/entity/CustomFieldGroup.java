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
@Table(name = "custom_field_group", catalog = "segosarem_db")
public class CustomFieldGroup extends GeneralCreateModify implements Serializable {

	private int cfGroupId;
	private String cfGroupName;
	private String cfGroupSequence;
    private String cfGroupKey;
	private Set<CustomField> customFieldList = new LinkedHashSet<CustomField>();

    public CustomFieldGroup() {
    }

    public CustomFieldGroup(int cfGroupId, String cfGroupName, String cfGroupSequence) {
        this.cfGroupId = cfGroupId;
        this.cfGroupName = cfGroupName;
        this.cfGroupSequence = cfGroupSequence;
    }

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cf_group_id", unique = true, nullable = false)
    public int getCfGroupId() {
        return this.cfGroupId;
    }

    public void setCfGroupId(int cfGroupId) {
        this.cfGroupId = cfGroupId;
    }

	@Column(name = "cf_group_name")
    public String getCfGroupName() {
        return this.cfGroupName;
    }

    public void setCfGroupName(String cfGroupName) {
        this.cfGroupName = cfGroupName;
    }

	@Column(name = "cf_group_sequence")
    public String getCfGroupSequence() {
        return this.cfGroupSequence;
    }

    public void setCfGroupSequence(String cfGroupSequence) {
        this.cfGroupSequence = cfGroupSequence;
    }

	@Column(name = "cf_group_key")
    public String getCfGroupKey() {
        return this.cfGroupKey;
    }

    public void setCfGroupKey(String cfGroupKey) {
        this.cfGroupKey = cfGroupKey;
    }
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customFieldGroup")
	public Set<CustomField> getCustomFieldList() {
		return customFieldList;
	}

	public void setCustomFieldList(Set<CustomField> customFieldList) {
		this.customFieldList = customFieldList;
	}
}
