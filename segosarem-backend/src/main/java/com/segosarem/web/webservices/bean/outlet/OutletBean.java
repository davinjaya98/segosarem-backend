package com.segosarem.web.webservices.bean.outlet;

public class OutletBean {
    
	//For Response
	private Integer outletId;
	
	private String outletName;
	private String outletDescription;
	private Integer outletSequence;
	
	//For Response
	private String outletImageUrl;

	public Integer getOutletId() {
		return this.outletId;
	}

	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}

	public String getOutletName() {
		return this.outletName;
	}

	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

	public String getOutletDescription() {
		return this.outletDescription;
	}

	public void setOutletDescription(String outletDescription) {
		this.outletDescription = outletDescription;
	}

	public Integer getOutletSequence() {
		return this.outletSequence;
	}

	public void setOutletSequence(Integer outletSequence) {
		this.outletSequence = outletSequence;
	}

	public String getOutletImageUrl() {
		return this.outletImageUrl;
	}

	public void setOutletImageUrl(String outletImageUrl) {
		this.outletImageUrl = outletImageUrl;
	}

}