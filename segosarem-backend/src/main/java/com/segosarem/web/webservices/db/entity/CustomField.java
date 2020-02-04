package com.segosarem.web.webservices.db.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "custom_field", catalog = "segosarem_db")
public class CustomField extends GeneralCreateModify implements Serializable {

	private int cfId;
    private String cfName;
    //This is in long text
	private String cfValue;
    //These 2 might not be needed
    private Integer cfType;
    private String cfSequence;
    //These 2 might not be needed
	private CustomFieldGroup customFieldGroup;

    public CustomField() {
    }

    public CustomField(int cfId, String cfName, String cfValue, Integer cfType, String cfSequence) {
        this.cfId = cfId;
        this.cfName = cfName;
        this.cfValue = cfValue;
        this.cfType = cfType;
        this.cfSequence = cfSequence;
    }

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cf_id", unique = true, nullable = false)
    public int getCfId() {
        return this.cfId;
    }

    public void setCfId(int cfId) {
        this.cfId = cfId;
    }

	@Column(name = "cf_name")
    public String getCfName() {
        return this.cfName;
    }

    public void setCfName(String cfName) {
        this.cfName = cfName;
    }

	@Column(name = "cf_value")
	@Type(type="text") // This is to make the column definition into long text
    public String getCfValue() {
        return this.cfValue;
    }

    public void setCfValue(String cfValue) {
        this.cfValue = cfValue;
    }

	@Column(name = "cf_type")
    public Integer getCfType() {
        return this.cfType;
    }

    public void setCfType(Integer cfType) {
        this.cfType = cfType;
    }

	@Column(name = "cf_sequence")
    public String getCfSequence() {
        return this.cfSequence;
    }

    public void setCfSequence(String cfSequence) {
        this.cfSequence = cfSequence;
    }
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cf_group_id")
	public CustomFieldGroup getCustomFieldGroup() {
		return customFieldGroup;
	} 
	public void setCustomFieldGroup(CustomFieldGroup customFieldGroup) {
		this.customFieldGroup = customFieldGroup;
	}

}
