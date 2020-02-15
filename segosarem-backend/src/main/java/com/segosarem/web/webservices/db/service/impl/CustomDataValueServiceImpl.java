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
import com.segosarem.web.webservices.db.dao.CustomDataValueDAO;
import com.segosarem.web.webservices.db.entity.CustomDataValue;
import com.segosarem.web.webservices.db.service.CustomDataValueService;
import com.segosarem.web.webservices.bean.DeleteEntityReqBean;
//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.customdatavalue.CustomDataValueBean;

@Transactional
@Service("CustomDataValueService")
public class CustomDataValueServiceImpl implements CustomDataValueService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomDataValueDAO customDataValueDAO;

    @Override
    public GeneralWsResponseBean getAllCustomDataValue() {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            List<CustomDataValue> entityList = customDataValueDAO.getAllCustomDataValue();

            if(entityList != null && !entityList.isEmpty()) {
                List<CustomDataValueBean> beanList = new ArrayList<CustomDataValueBean>();
                for(CustomDataValue entity : entityList) {
                    CustomDataValueBean bean = new DozerBeanMapper().map(entity, CustomDataValueBean.class);

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
    public GeneralWsResponseBean getCustomDataValueById(Integer id) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            CustomDataValue entity = customDataValueDAO.getCustomDataValueById(id, true);

            if(entity != null) {
                CustomDataValueBean bean = new DozerBeanMapper().map(entity, CustomDataValueBean.class);

                responseBean.setResponseObject(bean);
                responseBean = setResponseToSuccess(responseBean);
            }

        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean addCustomDataValue(CustomDataValueBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            CustomDataValue entity = new DozerBeanMapper().map(requestBean, CustomDataValue.class);
            entity.setCreateDt(new Date());
            entity.setStatus(SystemConstant.ACTIVE);

            customDataValueDAO.save(entity);

            responseBean = setResponseToSuccess(responseBean);
        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean updateCustomDataValue(CustomDataValueBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            CustomDataValue entity = customDataValueDAO.getCustomDataValueById(requestBean.getCdValueId(), false);

            if(entity != null) {
                // entity = new DozerBeanMapper().map(requestBean, CustomDataValue.class);
                entity.setCdValue(requestBean.getCdValue());
                entity.setCdValueType(requestBean.getCdValueType());
                entity.setCdValueSequence(requestBean.getCdValueSequence());
                entity.setCustomData(requestBean.getCustomData());
                entity.setParentValue(requestBean.getParentValue());
                entity.setChildValueList(requestBean.getChildValueList());
                entity.setModifyDt(new Date());
    
                customDataValueDAO.update(entity);
                
                responseBean = setResponseToSuccess(responseBean);
            }
        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean deleteCustomDataValue(DeleteEntityReqBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            CustomDataValue entity = customDataValueDAO.getCustomDataValueById(requestBean.getEntityId(), false);

            if(entity != null) {
                customDataValueDAO.delete(entity);
                
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