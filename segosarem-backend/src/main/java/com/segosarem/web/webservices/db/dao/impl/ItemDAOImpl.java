package com.paparadaminteractive.artic.webservices.db.dao.impl;

import java.util.List;

import com.paparadaminteractive.artic.webservices.db.dao.ItemDAO;
import com.paparadaminteractive.artic.webservices.db.entity.Item;
import com.paparadaminteractive.artic.constant.SystemConstant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl implements ItemDAO {

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
	public void save(Item entity) {

		getHibernateTemplate().persist(entity);
	}

	@Override
	public void delete(Item entity) {

		getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(Item entity) {

		getHibernateTemplate().update(entity);
	}

	@Override
	public List<Item> getItemListBySubCategoryId(Integer itemSubCategoryId) {

		return (List<Item>) getSession().createQuery("select i from Item i left join i.itemSubCategory isc where ic.itemSubCategoryId = " + itemSubCategoryId+" AND i.status='"+SystemConstant.ACTIVE+"'").list();
	}

	@Override
	public Item getItemById(Integer itemId) {

		List<Item> entityList = getSession().createQuery("from Item i where i.itemId = " + itemId+" AND i.status='"+SystemConstant.ACTIVE+"'").list();

		if(entityList != null && !entityList.isEmpty()) {
			return entityList.get(0);
		}

		return null;
	}

	@Override
	public List<Item> getItemList(Integer subCategoryId, String itemName, String itemPriceMin, String itemPriceMax){
		String query = "select i from Item i left join i.itemSubCategory isc where 1 = 1 ";
		if(subCategoryId != null){
			query += "AND isc.itemSubCategoryId = " + subCategoryId + " ";
		}
		if(itemName!=null){
			query += "AND i.itemName LIKE '%" + itemName + "%' ";
		}
		if(itemPriceMin!=null  && itemPriceMax!=null){
			query += "AND i.itemPrice BETWEEN " + itemPriceMin + " AND " + itemPriceMax + " ";
		}
		else if(itemPriceMin!=null){
			query += "AND i.itemPrice >= " + itemPriceMin + " ";
		}
		else if(itemPriceMax!=null){
			query += "AND i.itemPrice <= " + itemPriceMax + " ";
		}

		query += " AND i.status='"+SystemConstant.ACTIVE+"'";

		return (List<Item>) getSession().createQuery(query).list();
	}
}