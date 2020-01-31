package com.segosarem.web.webservices.bean;

public class ItemCategoryBean {
    
	private int itemCategoryId;
	private String itemCategoryName;
	private Character status;

	public int getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}
}