package com.segosarem.web.webservices.db.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_category", catalog = "segosarem_db")
public class ItemCategory extends GeneralCreateModify implements Serializable {

	private int itemCategoryId;
	private String itemCategoryName;

	public ItemCategory() {
	}

	/**
	 * @return the itemCategoryId
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_category_id", unique = true, nullable = false)
	public int getItemCategoryId() {
		return itemCategoryId;
	}
	/**
	 * @param itemCategoryId the itemCategoryId to set
	 */
	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
    }

	/**
	 * @return the itemCategoryName
	 */
	@Column(name = "item_category_name")
	public String getItemCategoryName() {
		return itemCategoryName;
	}
	/**
	 * @param itemCategoryName the itemCategoryName to set
	 */
	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

}
