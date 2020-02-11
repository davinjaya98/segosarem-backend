package com.segosarem.web.webservices.db.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Constant
import com.segosarem.web.constant.SystemConstant;
//DB
import com.segosarem.web.webservices.db.dao.QuotationDAO;
import com.segosarem.web.webservices.db.entity.Quotation;
import com.segosarem.web.webservices.db.service.QuotationService;

//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.quotation.QuotationBean;

@Transactional
@Service("QuotationService")
public class QuotationServiceImpl implements QuotationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuotationDAO quotationDAO;

    @Override
    public GeneralWsResponseBean getAllQuotation() {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            List<Quotation> entityList = quotationDAO.getAllQuotation();

            if(entityList != null && !entityList.isEmpty()) {
                List<QuotationBean> beanList = new ArrayList<QuotationBean>();
                for(Quotation entity : entityList) {
                    QuotationBean bean = new DozerBeanMapper().map(entity, QuotationBean.class);

                    beanList.add(bean);
                }

                responseBean.setResponseObject(beanList);
                responseBean = setResponseToSuccess(responseBean);
            }

        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean getQuotationById(Integer id) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            Quotation entity = quotationDAO.getQuotationById(id, true);

            if(entity != null) {
                QuotationBean bean = new DozerBeanMapper().map(entity, QuotationBean.class);

                responseBean.setResponseObject(bean);
                responseBean = setResponseToSuccess(responseBean);
            }

        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean addQuotation(QuotationBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            Quotation entity = new DozerBeanMapper().map(requestBean, Quotation.class);
            entity.setCreateDt(new Date());
            entity.setStatus(SystemConstant.ACTIVE);

            quotationDAO.save(entity);

            responseBean = setResponseToSuccess(responseBean);
        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    private GeneralWsResponseBean generateResponseBean() {
        GeneralWsResponseBean obj = new GeneralWsResponseBean();
        obj.setReturnCode(SystemConstant.FAILED);

        return obj;
    }

    private GeneralWsResponseBean setResponseToSuccess(GeneralWsResponseBean responseBean) {
        responseBean.setReturnCode(SystemConstant.SUCCESS);

        return responseBean;
    }
}