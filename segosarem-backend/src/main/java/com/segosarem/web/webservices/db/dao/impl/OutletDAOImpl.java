package com.segosarem.web.webservices.db.dao.impl;

import java.util.List;

import com.segosarem.web.constant.SystemConstant;
import com.segosarem.web.webservices.db.dao.OutletDAO;
import com.segosarem.web.webservices.db.entity.Outlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OutletDAOImpl implements OutletDAO {

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
	public void save(Outlet entity) {

		getHibernateTemplate().persist(entity);
	}

	@Override
	public void delete(Outlet entity) {

		getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(Outlet entity) {

		getHibernateTemplate().update(entity);
	}

	@Override
	public List<Outlet> getOutletList() {

		return (List<Outlet>) getSession().createQuery("from Outlet o where o.status= '"+SystemConstant.ACTIVE+"' ").list();
	}

	@Override
	public Outlet getOutletById(Integer outletId) {

		List<Outlet> entityList = getSession().createQuery("from Outlet o where o.outletId = " + outletId+" AND o.status='"+SystemConstant.ACTIVE+"'").list();

		if(entityList != null && !entityList.isEmpty()) {
			return entityList.get(0);
		}

		return null;
	}

}