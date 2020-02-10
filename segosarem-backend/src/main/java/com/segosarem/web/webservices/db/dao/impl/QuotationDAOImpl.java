package com.segosarem.web.webservices.db.dao.impl;

import java.util.List;

import com.segosarem.web.constant.SystemConstant;
import com.segosarem.web.webservices.db.dao.QuotationDAO;
import com.segosarem.web.webservices.db.entity.Quotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuotationDAOImpl implements QuotationDAO {

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
	public void save(Quotation entity) {

		getHibernateTemplate().persist(entity);
	}

	/*@Override
	public void delete(Quotation entity) {

		getHibernateTemplate().delete(entity);
	}*/

	/*@Override
	public void update(Quotation entity) {

		getHibernateTemplate().update(entity);
	}*/

	@Override
	public List<Quotation> getAllQuotation() {

		return (List<Quotation>) getSession().createQuery("from Quotation qt where qt.status= '"+SystemConstant.ACTIVE+"' ").list();
	}

	@Override
	public Quotation getQuotationById(Integer id, Boolean searchActive) {
		String query = "from Quotation qt where qt.quotationId = " + id;

		if(searchActive) {
			query += " AND qt.status='"+SystemConstant.ACTIVE+"'";
		}

		List<Quotation> entityList = getSession().createQuery(query).list();

		if(entityList != null && !entityList.isEmpty()) {
			return entityList.get(0);
		}

		return null;
	}

	@Override
	public Quotation getQuotationByKey(String key, Boolean searchActive) {
		String query = "from Quotation qt where qt.pageKey = '" + key +"'";

		if(searchActive) {
			query += " AND qt.status='"+SystemConstant.ACTIVE+"'";
		}

		List<Quotation> entityList = getSession().createQuery(query).list();

		if(entityList != null && !entityList.isEmpty()) {
			return entityList.get(0);
		}

		return null;
	}

}