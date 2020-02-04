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
import javax.persistence.ManyToOne;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "custom_data_value", catalog = "segosarem_db")
public class CustomDataValue extends GeneralCreateModify implements Serializable {

	private int cdValueId;
    //This is in byte[]
    private byte[] cdValue;
    private CustomData customData;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_id")
    public CustomData getCustomData() {
        return this.customData;
    }

    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

}