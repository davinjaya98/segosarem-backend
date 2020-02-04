package com.segosarem.web.webservices.bean.customfield;

public class CustomFieldBean {
    
	//For Response
    private Integer cfId;
    
    private String cfName;
    private String cfValue;
    
    //These 2 might not be needed
    private Integer cfType;
    private String cfSequence;
    //These 2 might not be needed

    public CustomFieldBean() {
    }

    public CustomFieldBean(Integer cfId, String cfName, String cfValue, Integer cfType, String cfSequence) {
        this.cfId = cfId;
        this.cfName = cfName;
        this.cfValue = cfValue;
        this.cfType = cfType;
        this.cfSequence = cfSequence;
    }

	public Integer getCfId() {
		return this.cfId;
	}

	public void setCfId(Integer cfId) {
		this.cfId = cfId;
	}

	public String getCfName() {
		return this.cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	public String getCfValue() {
		return this.cfValue;
	}

	public void setCfValue(String cfValue) {
		this.cfValue = cfValue;
	}

	public Integer getCfType() {
		return this.cfType;
	}

	public void setCfType(Integer cfType) {
		this.cfType = cfType;
	}

	public String getCfSequence() {
		return this.cfSequence;
	}

	public void setCfSequence(String cfSequence) {
		this.cfSequence = cfSequence;
	}
}