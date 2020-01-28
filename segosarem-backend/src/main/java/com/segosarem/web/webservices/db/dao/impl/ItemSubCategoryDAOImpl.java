package com.paparadaminteractive.artic.webservices.db.dao.impl;

import java.util.List;

import com.paparadaminteractive.artic.webservices.db.dao.ItemSubCategoryDAO;
import com.paparadaminteractive.artic.webservices.db.entity.ItemSubCategory;

import com.paparadaminteractive.artic.constant.SystemConstant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemSubCategoryDAOImpl implements ItemSubCategoryDAO {

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
	public void save(ItemSubCategory entity) {

		getHibernateTemplate().persist(entity);
	}

	@Override
	public void delete(ItemSubCategory entity) {

		getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(ItemSubCategory entity) {

		getHibernateTemplate().update(entity);
	}

	@Override
	public ItemSubCategory getItemSubCategoryById(Integer itemSubCategoryId) {

		List<ItemSubCategory> entityList = getSession().createQuery("from ItemSubCategory isc where isc.itemSubCategoryId = " + itemSubCategoryId+" AND isc.status='"+SystemConstant.ACTIVE+"'").list();

		if(entityList != null && !entityList.isEmpty()) {
			return entityList.get(0);
		}

		return null;
	}

	@Override
	public List<ItemSubCategory> getItemSubCategoryList(Integer itemCategoryId){
		String query = "select isc from ItemSubCategory isc";
		
		if(itemCategoryId!=null){
			query +=  " left join isc.itemCategory ic where ic.itemCategoryId = " + itemCategoryId+ " AND isc.status='"+SystemConstant.ACTIVE+"'";
		}

		return (List<ItemSubCategory>) getSession().createQuery(query).list();
	}
}