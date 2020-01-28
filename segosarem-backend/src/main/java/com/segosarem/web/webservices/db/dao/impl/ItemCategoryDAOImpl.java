package com.paparadaminteractive.artic.webservices.db.dao.impl;

import java.util.List;

import com.paparadaminteractive.artic.constant.SystemConstant;
import com.paparadaminteractive.artic.webservices.db.dao.ItemCategoryDAO;
import com.paparadaminteractive.artic.webservices.db.entity.ItemCategory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemCategoryDAOImpl implements ItemCategoryDAO {

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
	public void save(ItemCategory entity) {

		getHibernateTemplate().persist(entity);
	}

	@Override
	public void delete(ItemCategory entity) {

		getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(ItemCategory entity) {

		getHibernateTemplate().update(entity);
	}

	@Override
	public List<ItemCategory> getItemCategoryList() {

		return (List<ItemCategory>) getSession().createQuery("from ItemCategory ic where ic.status= '"+SystemConstant.ACTIVE+"' ").list();
	}

	@Override
	public ItemCategory getItemCategoryById(Integer itemCategoryId) {

		List<ItemCategory> entityList = getSession().createQuery("from ItemCategory ic where ic.itemCategoryId = " + itemCategoryId+" AND ic.status='"+SystemConstant.ACTIVE+"'").list();

		if(entityList != null && !entityList.isEmpty()) {
			return entityList.get(0);
		}

		return null;
	}

}