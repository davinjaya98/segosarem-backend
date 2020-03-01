package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.CustomDataSetting;

public interface CustomDataSettingDAO {
	
	public void save(CustomDataSetting entity);
    //This can be used to update status to active, deactivated, or deleted
	public void update(CustomDataSetting entity);
    //This one effectively removed it from db
	public void delete(CustomDataSetting entity);

	public List<CustomDataSetting> getAllCustomDataSetting();
	public CustomDataSetting getCustomDataSettingById(Integer id, Boolean searchActive);
}