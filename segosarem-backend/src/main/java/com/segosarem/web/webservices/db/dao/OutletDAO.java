package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.Outlet;

public interface OutletDAO {
	
	public void save(Outlet entity);
	public void delete(Outlet entity);
	public void update(Outlet entity);
	public List<Outlet> getOutletList();
	public Outlet getOutletById(Integer outletId);
}