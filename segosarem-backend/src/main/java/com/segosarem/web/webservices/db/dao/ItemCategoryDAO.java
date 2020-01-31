package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.ItemCategory;

public interface ItemCategoryDAO {
	
	public void save(ItemCategory entity);
	public void delete(ItemCategory entity);
	public void update(ItemCategory entity);
	public List<ItemCategory> getItemCategoryList();
	public ItemCategory getItemCategoryById(Integer itemCategoryId);
}