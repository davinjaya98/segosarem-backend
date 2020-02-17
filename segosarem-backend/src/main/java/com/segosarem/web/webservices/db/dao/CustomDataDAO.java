package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.CustomData;

public interface CustomDataDAO {
	
	public void save(CustomData entity);
    //This can be used to update status to active, deactivated, or deleted
	public void update(CustomData entity);
    //This one effectively removed it from db
	public void delete(CustomData entity);

	public List<CustomData> getAllCustomData();
	public CustomData getCustomDataById(Integer id, Boolean searchActive);
}