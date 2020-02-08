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
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "custom_data_value", catalog = "segosarem_db")
public class CustomDataValue extends GeneralCreateModify implements Serializable {

	private int cdValueId;
    //This is in byte[]
    private byte[] cdValue;
    //0 - Multifield parent
    //1 - Textfield / Path Field (For Images)
    //2 - Boolean
    private Integer cdValueType;
    private Integer cdValueLevel;

    //Usable for Array and Multifield only
    //0 - no sequence
    private Integer cdValueSequence;

    private CustomData customData;
    
    //Recursive for Multifield Type
    private CustomDataValue parentValue;
    private Set<CustomDataValue> childValueList = new LinkedHashSet<CustomDataValue>();

    public CustomDataValue() {
    }

    public CustomDataValue(int cdValueId, byte[] cdValue, CustomData customData) {
        this.cdValueId = cdValueId;
        this.cdValue = cdValue;
        this.customData = customData;
    }

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cd_value_id", unique = true, nullable = false)
    public int getCdValueId() {
        return this.cdValueId;
    }

    public void setCdValueId(int cdValueId) {
        this.cdValueId = cdValueId;
    }

    @Type(type = "org.hibernate.type.BlobType")
    @Lob
    @Column(name = "cd_value")
    public byte[] getCdValue() {
        return this.cdValue;
    }

    public void setCdValue(byte[] cdValue) {
        this.cdValue = cdValue;
    }

	@Column(name = "cd_value_type")
    public Integer getCdValueType() {
        return this.cdValueType;
    }

    public void setCdValueType(Integer cdValueType) {
        this.cdValueType = cdValueType;
    }

	@Column(name = "cd_value_level")
    public Integer getCdValueLevel() {
        return this.cdValueLevel;
    }

    public void setCdValueLevel(Integer cdValueLevel) {
        this.cdValueLevel = cdValueLevel;
    }

	@Column(name = "cd_value_sequence")
    public Integer getCdValueSequence() {
        return this.cdValueSequence;
    }

    public void setCdValueSequence(Integer cdValueSequence) {
        this.cdValueSequence = cdValueSequence;
    }
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_id")
    public CustomData getCustomData() {
        return this.customData;
    }

    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    //Recursive for Multifield Type
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
    public CustomDataValue getParentValue() {
        return this.parentValue;
    }

    public void setParentValue(CustomDataValue parentValue) {
        this.parentValue = parentValue;
    }

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentValue")
    public Set<CustomDataValue> getChildValueList() {
        return this.childValueList;
    }

    public void setChildValueList(Set<CustomDataValue> childValueList) {
        this.childValueList = childValueList;
    }
}