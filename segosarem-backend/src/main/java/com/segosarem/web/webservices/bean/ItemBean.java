package com.paparadaminteractive.artic.webservices.bean;

public class ItemBean {
    
	private int itemId;
	private String itemName;
	private String itemPrice;
	private String itemSKU;
	private Character status;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

    public String getItemPrice(){
        return itemPrice;
    }

    public void setItemPrice(String itemPrice){
        this.itemPrice = itemPrice;
	}
	
	public String getItemSKU(){
		return itemSKU;
	}

	public void setItemSKU(String itemSKU){
		this.itemSKU = itemSKU;
	}
	
	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}
}