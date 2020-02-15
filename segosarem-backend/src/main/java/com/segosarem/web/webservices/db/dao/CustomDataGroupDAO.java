package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.CustomDataGroup;

public interface CustomDataGroupDAO {
	
	public void save(CustomDataGroup entity);
    //This can be used to update status to active, deactivated, or deleted
	public void update(CustomDataGroup entity);
    //This one effectively removed it from db
	public void delete(CustomDataGroup entity);

	public List<CustomDataGroup> getAllCustomDataGroup();
	public CustomDataGroup getCustomDataGroupById(Integer id, Boolean searchActive);
}