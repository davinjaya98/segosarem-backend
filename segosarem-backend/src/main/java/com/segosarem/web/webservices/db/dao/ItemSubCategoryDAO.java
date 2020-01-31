package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.ItemSubCategory;

public interface ItemSubCategoryDAO {
	
	public void save(ItemSubCategory entity);
	public void delete(ItemSubCategory entity);
	public void update(ItemSubCategory entity);
	public ItemSubCategory getItemSubCategoryById(Integer itemSubCategoryId);
	public List<ItemSubCategory> getItemSubCategoryList(Integer itemCategoryId);
}