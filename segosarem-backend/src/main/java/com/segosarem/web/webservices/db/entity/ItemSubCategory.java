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
@Table(name = "item_sub_category", catalog = "segosarem_db")
public class ItemSubCategory extends GeneralCreateModify implements Serializable {

	private int itemSubCategoryId;
	private String itemSubCategoryName;
	private ItemCategory itemCategory;

	public ItemSubCategory() {
	}

	/**
	 * @return the itemSubCategoryId
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_sub_category_id", unique = true, nullable = false)
	public int getItemSubCategoryId() {
		return itemSubCategoryId;
	}
	/**
	 * @param itemSubCategoryId the itemSubCategoryId to set
	 */
	public void setItemSubCategoryId(int itemSubCategoryId) {
		this.itemSubCategoryId = itemSubCategoryId;
    }

	/**
	 * @return the itemSubCategoryName
	 */
	@Column(name = "name")
	public String getItemSubCategoryName() {
		return itemSubCategoryName;
	}
	/**
	 * @param itemSubCategoryName the itemSubCategoryName to set
	 */
	public void setItemSubCategoryName(String itemSubCategoryName) {
		this.itemSubCategoryName = itemSubCategoryName;
	}

	/**
	 * @return the itemCategory
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_category_id")
	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	/**
	 * @param itemCategory the itemCategory to set
	 */
	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

}
