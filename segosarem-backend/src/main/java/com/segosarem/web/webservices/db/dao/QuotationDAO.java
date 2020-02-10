package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.Quotation;

public interface QuotationDAO {
	
	public void save(Quotation entity);

	public List<Quotation> getAllQuotation();
	public Quotation getQuotationById(Integer id, Boolean searchActive);
	public Quotation getQuotationByKey(String key, Boolean searchActive);

    //This can be used to update status to active, deactivated, or deleted
	//public void update(Quotation entity);
    //This one effectively removed it from db
	//public void delete(Quotation entity);
}