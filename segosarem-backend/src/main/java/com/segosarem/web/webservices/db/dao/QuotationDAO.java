package com.segosarem.web.webservices.db.dao;

import java.util.List;

import com.segosarem.web.webservices.db.entity.Quotation;

public interface QuotationDAO {
	
	public void save(Quotation entity);

	public List<Quotation> getAllQuotation();
	public Quotation getQuotationById(Integer id, Boolean searchActive);
}