package com.segosarem.web.webservices.bean;

public class ItemSubCategoryBean {
    
	private int itemSubCategoryId;
	private String itemSubCategoryName;
	private Character status;

	public int getItemSubCategoryId() {
		return itemSubCategoryId;
	}

	public void setItemSubCategoryId(int itemSubCategoryId) {
		this.itemSubCategoryId = itemSubCategoryId;
	}

	public String getItemSubCategoryName() {
		return itemSubCategoryName;
	}

	public void setItemSubCategoryName(String itemSubCategoryName) {
		this.itemSubCategoryName = itemSubCategoryName;
	}
	
	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}
}