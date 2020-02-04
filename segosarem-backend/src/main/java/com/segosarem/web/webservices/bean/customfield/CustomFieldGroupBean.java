package com.segosarem.web.webservices.bean.customfield;

public class CustomFieldGroupBean {
    
	//For Response
    private Integer cfGroupId;
    
	private String cfGroupName;
	private String cfGroupSequence;
    private String cfGroupKey;
    
    public CustomFieldGroupBean() {
    }

    public CustomFieldGroupBean(Integer cfGroupId, String cfGroupName, String cfGroupSequence, String cfGroupKey) {
        this.cfGroupId = cfGroupId;
        this.cfGroupName = cfGroupName;
        this.cfGroupSequence = cfGroupSequence;
        this.cfGroupKey = cfGroupKey;
    }

	public Integer getCfGroupId() {
		return this.cfGroupId;
	}

	public void setCfGroupId(Integer cfGroupId) {
		this.cfGroupId = cfGroupId;
	}

	public String getCfGroupName() {
		return this.cfGroupName;
	}

	public void setCfGroupName(String cfGroupName) {
		this.cfGroupName = cfGroupName;
	}

	public String getCfGroupSequence() {
		return this.cfGroupSequence;
	}

	public void setCfGroupSequence(String cfGroupSequence) {
		this.cfGroupSequence = cfGroupSequence;
	}

	public String getCfGroupKey() {
		return this.cfGroupKey;
	}

	public void setCfGroupKey(String cfGroupKey) {
		this.cfGroupKey = cfGroupKey;
	}
}