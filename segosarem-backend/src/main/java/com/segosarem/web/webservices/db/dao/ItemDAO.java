package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.Item;

public interface ItemDAO {
	
	public void save(Item entity);
	public void delete(Item entity);
	public void update(Item entity);
	public List<Item> getItemListBySubCategoryId(Integer itemSubCategoryId);
	public Item getItemById(Integer itemId);
	public List<Item> getItemList(Integer subCategoryId, String itemName, String itemPriceMin, String itemPriceMax);
}