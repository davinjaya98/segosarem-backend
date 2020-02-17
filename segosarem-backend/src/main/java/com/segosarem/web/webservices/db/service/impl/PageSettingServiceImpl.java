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
import com.segosarem.web.webservices.db.dao.PageSettingDAO;
import com.segosarem.web.webservices.db.entity.PageSetting;
import com.segosarem.web.webservices.db.service.PageSettingService;
import com.segosarem.web.webservices.bean.DeleteEntityReqBean;
//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.pagesetting.PageSettingBean;

@Transactional
@Service("PageSettingService")
public class PageSettingServiceImpl implements PageSettingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PageSettingDAO pageSettingDAO;

    @Override
    public GeneralWsResponseBean getAllPageSetting() {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            List<PageSetting> entityList = pageSettingDAO.getAllPageSetting();

            if(entityList != null && !entityList.isEmpty()) {
                List<PageSettingBean> beanList = new ArrayList<PageSettingBean>();
                for(PageSetting entity : entityList) {
                    PageSettingBean bean = new DozerBeanMapper().map(entity, PageSettingBean.class);

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
    public GeneralWsResponseBean getPageSettingById(Integer id) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            PageSetting entity = pageSettingDAO.getPageSettingById(id, true);

            if(entity != null) {
                PageSettingBean bean = new DozerBeanMapper().map(entity, PageSettingBean.class);

                responseBean.setResponseObject(bean);
                responseBean = setResponseToSuccess(responseBean);
            }

        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean getPageSettingByKey(String key) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            PageSetting entity = pageSettingDAO.getPageSettingByKey(key, true);

            if(entity != null) {
                PageSettingBean bean = new DozerBeanMapper().map(entity, PageSettingBean.class);

                responseBean.setResponseObject(bean);
                responseBean = setResponseToSuccess(responseBean);
            }

        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean addPageSetting(PageSettingBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            PageSetting entity = new DozerBeanMapper().map(requestBean, PageSetting.class);
            entity.setCreateDt(new Date());
            entity.setStatus(SystemConstant.ACTIVE);

            pageSettingDAO.save(entity);

            responseBean = setResponseToSuccess(responseBean);
        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean updatePageSetting(PageSettingBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            PageSetting entity = pageSettingDAO.getPageSettingById(requestBean.getSettingId(), false);

            if(entity != null) {
                // entity = new DozerBeanMapper().map(requestBean, PageSetting.class);
                entity.setPageKey(requestBean.getPageKey());
                entity.setPageSeoKeywords(requestBean.getPageSeoKeywords());
                entity.setPageTitle(requestBean.getPageTitle());
                //entity.setStatus(requestBean.getStatus());
                entity.setModifyDt(new Date());
    
                pageSettingDAO.update(entity);
                
                responseBean = setResponseToSuccess(responseBean);
            }
        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean deletePageSetting(DeleteEntityReqBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            PageSetting entity = pageSettingDAO.getPageSettingById(requestBean.getEntityId(), false);

            if(entity != null) {
                pageSettingDAO.delete(entity);
                
                responseBean = setResponseToSuccess(responseBean);
            }
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