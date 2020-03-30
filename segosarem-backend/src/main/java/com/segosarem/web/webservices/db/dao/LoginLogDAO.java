package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.LoginLog;

public interface LoginLogDAO {
	
	public void save(LoginLog entity);

	public List<LoginLog> getAllLogSortedByLatest();
	public LoginLog getLatestLog();
}