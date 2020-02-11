package com.segosarem.web.webservices.db.dao.impl;

import java.util.List;

import com.segosarem.web.constant.SystemConstant;
import com.segosarem.web.webservices.db.dao.PageSettingDAO;
import com.segosarem.web.webservices.db.entity.PageSetting;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PageSettingDAOImpl implements PageSettingDAO {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(_sessionFactory);
		return hibernateTemplate;
	}

	@Override
	public void save(PageSetting entity) {

		getHibernateTemplate().persist(entity);
	}

	@Override
	public void delete(PageSetting entity) {

		getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(PageSetting entity) {

		getHibernateTemplate().update(entity);
	}

	@Override
	public List<PageSetting> getAllPageSetting() {

		return (List<PageSetting>) getSession().createQuery("from PageSetting ps where ps.status= '"+SystemConstant.ACTIVE+"' ").list();
	}

	@Override
	public PageSetting getPageSettingById(Integer id, Boolean searchActive) {
		String query = "from PageSetting ps where ps.settingId = " + id;

		if(searchActive) {
			query += " AND ps.status='"+SystemConstant.ACTIVE+"'";
		}

		List<PageSetting> entityList = getSession().createQuery(query).list();

		if(entityList != null && !entityList.isEmpty()) {
			return entityList.get(0);
		}

		return null;
	}

	@Override
	public PageSetting getPageSettingByKey(String key, Boolean searchActive) {
		String query = "from PageSetting ps where ps.pageKey = '" + key +"'";

		if(searchActive) {
			query += " AND ps.status='"+SystemConstant.ACTIVE+"'";
		}

		List<PageSetting> entityList = getSession().createQuery(query).list();

		if(entityList != null && !entityList.isEmpty()) {
			return entityList.get(0);
		}

		return null;
	}

}