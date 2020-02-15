package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.CustomDataValue;

public interface CustomDataValueDAO {
	
	public void save(CustomDataValue entity);
    //This can be used to update status to active, deactivated, or deleted
	public void update(CustomDataValue entity);
    //This one effectively removed it from db
	public void delete(CustomDataValue entity);

	public List<CustomDataValue> getAllCustomDataValue();
	public CustomDataValue getCustomDataValueById(Integer id, Boolean searchActive);
}