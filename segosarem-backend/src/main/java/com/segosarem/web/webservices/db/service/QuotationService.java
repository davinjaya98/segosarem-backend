package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.quotation.QuotationBean;

public interface QuotationService {
    
    public GeneralWsResponseBean getAllQuotation();
    public GeneralWsResponseBean getQuotationById(Integer id);
    public GeneralWsResponseBean addQuotation(QuotationBean requestBean);
}