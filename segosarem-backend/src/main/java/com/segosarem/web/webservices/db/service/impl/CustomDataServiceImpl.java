package com.segosarem.web.webservices.db.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Constant
import com.segosarem.web.constant.SystemConstant;

//DB
import com.segosarem.web.webservices.db.dao.CustomDataDAO;
import com.segosarem.web.webservices.db.dao.CustomDataGroupDAO;
import com.segosarem.web.webservices.db.dao.CustomDataValueDAO;
import com.segosarem.web.webservices.db.entity.CustomData;
import com.segosarem.web.webservices.db.entity.CustomDataGroup;
import com.segosarem.web.webservices.db.entity.CustomDataValue;
import com.segosarem.web.webservices.db.service.CommonServiceUtils;
import com.segosarem.web.webservices.db.service.CustomDataService;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;

//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.customdata.CustomDataBean;
import com.segosarem.web.webservices.bean.customdatavalue.CustomDataValueBean;

@Transactional
@Service("CustomDataService")
public class CustomDataServiceImpl implements CustomDataService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomDataDAO customDataDAO;

    @Autowired
    private CustomDataGroupDAO customDataGroupDAO;

    @Autowired
    private CustomDataValueDAO customDataValueDAO;

    @Override
    public GeneralWsResponseBean getAllCustomData() {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            List<CustomData> entityList = customDataDAO.getAllCustomData();

            if (entityList != null && !entityList.isEmpty()) {
                List<CustomDataBean> beanList = new ArrayList<CustomDataBean>();
                for (CustomData entity : entityList) {
                    CustomDataBean bean = new DozerBeanMapper().map(entity, CustomDataBean.class);

                    beanList.add(bean);
                }

                responseBean.setResponseObject(beanList);
                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }

        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean getCustomDataListByCdGroupId(Integer id) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            List<CustomData> entityList = customDataDAO.getCustomDataListByCdGroupId(id);

            if (entityList != null && !entityList.isEmpty()) {
                List<CustomDataBean> beanList = new ArrayList<CustomDataBean>();
                for (CustomData entity : entityList) {
                    CustomDataBean bean = new DozerBeanMapper().map(entity, CustomDataBean.class);
                    bean.setCdGroupId(entity.getCustomDataGroup().getCdGroupId());
                    beanList.add(bean);
                }

                responseBean.setResponseObject(beanList);
                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }

        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean getCustomDataById(Integer id) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomData entity = customDataDAO.getCustomDataById(id, true);

            if (entity != null) {
                CustomDataBean bean = new DozerBeanMapper().map(entity, CustomDataBean.class);

                responseBean.setResponseObject(bean);
                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }

        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean getCustomDataByKey(String key) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomData entity = customDataDAO.getCustomDataByKey(key, true);

            if (entity != null) {
                CustomDataBean bean = new DozerBeanMapper().map(entity, CustomDataBean.class);

                if (entity.getCdValueList() != null && !entity.getCdValueList().isEmpty()) {
                    // List<CustomDataValueKeyPairBean> cdValuePairs = new
                    // ArrayList<CustomDataValueKeyPairBean>();
                    List<Map<String, Object>> cdValuePairs = new ArrayList<Map<String, Object>>();

                    // Because only the parent 0 tagged into the CustomData Entity
                    for (CustomDataValue parentValue : entity.getCdValueList()) {
                        if (parentValue.getChildValueList() != null && !parentValue.getChildValueList().isEmpty()) {
                            Map<String, Object> cdValuePair = new LinkedHashMap<String, Object>();
                            for (CustomDataValue childValue : parentValue.getChildValueList()) {
                                cdValuePair.put(childValue.getCustomDataSetting().getCdsKey(),
                                        CommonServiceUtils.parseValue(childValue.getCdValue(),
                                                childValue.getCustomDataSetting().getCdsType()));
                            }
                            cdValuePairs.add(cdValuePair);
                        }
                    }

                    bean.setCdValuePair(cdValuePairs);
                }

                responseBean.setResponseObject(bean);
                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }

        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean addCustomData(CustomDataBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomDataGroup customDataGroup = customDataGroupDAO.getCustomDataGroupById(requestBean.getCdGroupId(),
                    true);

            if (customDataGroup != null) {
                CustomData entity = new DozerBeanMapper().map(requestBean, CustomData.class);
                entity.setCustomDataGroup(customDataGroup);

                entity.setCreateDt(new Date());
                entity.setStatus(SystemConstant.ACTIVE);

                customDataDAO.save(entity);

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean updateCustomData(CustomDataBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomData entity = customDataDAO.getCustomDataById(requestBean.getCdId(), false);

            if (entity != null) {
                // entity = new DozerBeanMapper().map(requestBean, CustomData.class);

                // update custom data
                entity.setCdName(requestBean.getCdName());
                entity.setCdType(requestBean.getCdType());
                entity.setCdSequence(requestBean.getCdSequence());
                // entity.setCustomDataGroup(requestBean.getCustomDataGroup());
                entity.setModifyDt(new Date());

                customDataDAO.update(entity);

                // update custom data value list of current custom data
                // if(requestBean.getCdValueList()!=null ||
                // !requestBean.getCdValueList().isEmpty()){
                // for(CustomDataValueBean CdvBean : requestBean.getCdValueList()){
                // CustomDataValue CdvEntity =
                // customDataValueDAO.getCustomDataValueById(CdvBean.getCdValueId(), false);

                // if(CdvEntity!=null){
                // CdvEntity.setCdValue(CdvBean.getCdValue());
                // // CdvEntity.setCdValueType(CdvBean.getCdValueType());
                // CdvEntity.setCdValueLevel(CdvBean.getCdValueLevel());
                // // CdvEntity.setCdValueSequence(CdvBean.getCdValueSequence());
                // CdvEntity.setModifyDt(new Date());
                // }
                // }
                // }

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean deleteCustomData(DeleteEntityReqBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomData entity = customDataDAO.getCustomDataById(requestBean.getEntityId(), false);

            if (entity != null) {
                customDataDAO.delete(entity);

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }
}