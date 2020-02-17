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
import com.segosarem.web.webservices.db.dao.CustomDataGroupDAO;
import com.segosarem.web.webservices.db.dao.CustomDataDAO;
import com.segosarem.web.webservices.db.dao.CustomDataValueDAO;
import com.segosarem.web.webservices.db.dao.PageSettingDAO;

import com.segosarem.web.webservices.db.entity.CustomData;
import com.segosarem.web.webservices.db.entity.CustomDataValue;
import com.segosarem.web.webservices.db.entity.CustomDataGroup;
import com.segosarem.web.webservices.db.entity.PageSetting;
import com.segosarem.web.webservices.db.service.CustomDataGroupService;
import com.segosarem.web.webservices.bean.DeleteEntityReqBean;
//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.customdatavalue.CustomDataValueBean;
import com.segosarem.web.webservices.bean.customdata.CustomDataBean;
import com.segosarem.web.webservices.bean.customdatagroup.CustomDataGroupBean;

@Transactional
@Service("CustomDataGroupService")
public class CustomDataGroupServiceImpl implements CustomDataGroupService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomDataGroupDAO  customDataGroupDAO;
    private CustomDataDAO       customDataDAO;
    private CustomDataValueDAO  customDataValueDAO;
    private PageSettingDAO      pageSettingDAO;

    @Override
    public GeneralWsResponseBean getAllCustomDataGroup() {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            List<CustomDataGroup> entityList = customDataGroupDAO.getAllCustomDataGroup();

            if(entityList != null && !entityList.isEmpty()) {
                List<CustomDataGroupBean> beanList = new ArrayList<CustomDataGroupBean>();
                for(CustomDataGroup entity : entityList) {
                    CustomDataGroupBean bean = new DozerBeanMapper().map(entity, CustomDataGroupBean.class);

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
    public GeneralWsResponseBean getCustomDataGroupById(Integer id) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            CustomDataGroup entity = customDataGroupDAO.getCustomDataGroupById(id, true);

            if(entity != null) {
                CustomDataGroupBean bean = new DozerBeanMapper().map(entity, CustomDataGroupBean.class);

                responseBean.setResponseObject(bean);
                responseBean = setResponseToSuccess(responseBean);
            }

        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean addCustomDataGroup(CustomDataGroupBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        // try{
            //Get the page setting first
            PageSetting pageSetting = pageSettingDAO.getPageSettingById(requestBean.getPageSettingId(), true);

            if(pageSetting != null) {
                CustomDataGroup entity = new DozerBeanMapper().map(requestBean, CustomDataGroup.class);
                entity.setPageSetting(pageSetting);

                entity.setCreateDt(new Date());
                entity.setStatus(SystemConstant.ACTIVE);
    
                customDataGroupDAO.save(entity);
    
                responseBean = setResponseToSuccess(responseBean);
            }
        // }catch(Exception e) {
        //     responseBean.setResponseObject(e.getMessage());
        // }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean updateCustomDataGroup(CustomDataGroupBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            CustomDataGroup entity = customDataGroupDAO.getCustomDataGroupById(requestBean.getCdGroupId(), false);

            if(entity != null) {
                // entity = new DozerBeanMapper().map(requestBean, CustomDataGroup.class);

                //update custom data group
                entity.setCdGroupName(requestBean.getCdGroupName());
                entity.setCdGroupDescription(requestBean.getCdGroupDescription());
                entity.setModifyDt(new Date());
    
                customDataGroupDAO.update(entity);

                // update custom data list of current custom data group
                if(requestBean.getCustomDataBeanList()!=null || !requestBean.getCustomDataBeanList().isEmpty()){
                    for (CustomDataBean CdBean : requestBean.getCustomDataBeanList()){
                        CustomData CdEntity = customDataDAO.getCustomDataById(CdBean.getCdId(), false);

                        if (CdEntity!=null){
                            CdEntity.setCdName(CdBean.getCdName());
                            CdEntity.setCdType(CdBean.getCdType());
                            CdEntity.setCdSequence(CdBean.getCdSequence());
                            CdEntity.setModifyDt(new Date());                    
                            
                            //update custom data value list of current custom data
                            if(CdBean.getCdValueList()!=null || !CdBean.getCdValueList().isEmpty()){
                                for(CustomDataValueBean CdvBean : CdBean.getCdValueList()){
                                    CustomDataValue CdvEntity = customDataValueDAO.getCustomDataValueById(CdvBean.getCdValueId(), false);

                                    if(CdvEntity!=null){
                                        CdvEntity.setCdValue(CdvBean.getCdValue());
                                        CdvEntity.setCdValueType(CdvBean.getCdValueType());
                                        CdvEntity.setCdValueLevel(CdvBean.getCdValueLevel());
                                        CdvEntity.setCdValueSequence(CdvBean.getCdValueSequence());
                                        CdvEntity.setModifyDt(new Date());
                                    }
                                }
                            }
                        }
                    }
                }

                // update page setting of current custom data group // Should not be able to update page setting
                // PageSetting PsEntity = pageSettingDAO.getPageSettingById(requestBean.getPageSettingId(), true);
                // PsEntity.setPageTitle(requestBean.getPageSetting().getPageTitle());
                // PsEntity.setPageSeoKeywords(requestBean.getPageSetting().getPageSeoKeywords());
                // PsEntity.setPageKey(requestBean.getPageSetting().getPageKey());

                // pageSettingDAO.update(PsEntity);

                responseBean = setResponseToSuccess(responseBean);
            }
        }catch(Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean deleteCustomDataGroup(DeleteEntityReqBean requestBean) {
        GeneralWsResponseBean responseBean = generateResponseBean();
        try{
            CustomDataGroup entity = customDataGroupDAO.getCustomDataGroupById(requestBean.getEntityId(), false);

            if(entity != null) {
                customDataGroupDAO.delete(entity);
                
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