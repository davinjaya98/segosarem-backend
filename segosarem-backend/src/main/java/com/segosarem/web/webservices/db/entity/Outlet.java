package com.segosarem.web.webservices.db.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outlet", catalog = "segosarem_db")
public class Outlet extends GeneralCreateModify implements Serializable {

	private int outletId;
	private String outletName;
	private String outletDescription;
    private Integer outletSequence;
    private String outletImageUrl;

    public Outlet() {
    }

    public Outlet(int outletId, String outletName, String outletDescription, Integer outletSequence, String outletImageUrl) {
        this.outletId = outletId;
        this.outletName = outletName;
        this.outletDescription = outletDescription;
        this.outletSequence = outletSequence;
        this.outletImageUrl = outletImageUrl;
    }

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "outlet_id", unique = true, nullable = false)
    public int getOutletId() {
        return this.outletId;
    }

    public void setOutletId(int outletId) {
        this.outletId = outletId;
    }

	@Column(name = "outlet_name")
    public String getOutletName() {
        return this.outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

	@Column(name = "outlet_description")
    public String getOutletDescription() {
        return this.outletDescription;
    }

    public void setOutletDescription(String outletDescription) {
        this.outletDescription = outletDescription;
    }

	@Column(name = "outlet_sequence")
    public Integer getOutletSequence() {
        return this.outletSequence;
    }

    public void setOutletSequence(Integer outletSequence) {
        this.outletSequence = outletSequence;
    }

	@Column(name = "outlet_image_url")
    public String getOutletImageUrl() {
        return this.outletImageUrl;
    }

    public void setOutletImageUrl(String outletImageUrl) {
        this.outletImageUrl = outletImageUrl;
    }

}
