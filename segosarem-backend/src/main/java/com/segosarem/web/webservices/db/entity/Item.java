package com.paparadaminteractive.artic.webservices.db.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item", catalog = "segosarem_db")
public class Item extends GeneralCreateModify implements Serializable {

	private int itemId;
    private String itemName;
    private String itemSKU;
    private String itemPrice;
	private ItemSubCategory itemSubCategory;

	public Item() {
	}

	/**
	 * @return the itemId
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_id", unique = true, nullable = false)
	public int getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
    }

	/**
	 * @return the itemName
	 */
	@Column(name = "item_name")
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemSKU
	 */
	@Column(name = "item_sku")
	public String getItemSKU() {
		return itemSKU;
	}
	/**
	 * @param itemSKU the itemSKU to set
	 */
	public void setItemSKU(String itemSKU) {
		this.itemSKU = itemSKU;
	}

	/**
	 * @return the itemPrice
	 */
	@Column(name = "item_price")
	public String getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the itemSubCategory
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_sub_category_id")
	public ItemSubCategory getItemSubCategory() {
		return itemSubCategory;
	}

	/**
	 * @param itemSubCategory the itemSubCategory to set
	 */
	public void setItemSubCategory(ItemSubCategory itemSubCategory) {
		this.itemSubCategory = itemSubCategory;
	}

}
