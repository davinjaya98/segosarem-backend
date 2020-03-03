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
import com.segosarem.web.webservices.db.dao.CustomDataDAO;
import com.segosarem.web.webservices.db.dao.CustomDataSettingDAO;
import com.segosarem.web.webservices.db.dao.CustomDataValueDAO;
import com.segosarem.web.webservices.db.entity.CustomData;
import com.segosarem.web.webservices.db.entity.CustomDataSetting;
import com.segosarem.web.webservices.db.entity.CustomDataValue;
import com.segosarem.web.webservices.db.service.CommonServiceUtils;
import com.segosarem.web.webservices.db.service.CustomDataValueService;
import com.segosarem.web.webservices.bean.DeleteEntityReqBean;
//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.customdatavalue.AddValueWrapperBean;
import com.segosarem.web.webservices.bean.customdatavalue.CustomDataValueBean;

@Transactional
@Service("CustomDataValueService")
public class CustomDataValueServiceImpl implements CustomDataValueService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomDataDAO customDataDAO;

    @Autowired
    private CustomDataSettingDAO customDataSettingDAO;

    @Autowired
    private CustomDataValueDAO customDataValueDAO;

    @Override
    public GeneralWsResponseBean getAllCustomDataValue() {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            List<CustomDataValue> entityList = customDataValueDAO.getAllCustomDataValue();

            if (entityList != null && !entityList.isEmpty()) {
                List<CustomDataValueBean> beanList = new ArrayList<CustomDataValueBean>();
                for (CustomDataValue entity : entityList) {
                    CustomDataValueBean bean = new DozerBeanMapper().map(entity, CustomDataValueBean.class);

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
    public GeneralWsResponseBean getCustomDataValueById(Integer id) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomDataValue entity = customDataValueDAO.getCustomDataValueById(id, true);

            if (entity != null) {
                CustomDataValueBean bean = new DozerBeanMapper().map(entity, CustomDataValueBean.class);

                responseBean.setResponseObject(bean);
                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }

        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean addCustomDataValue(AddValueWrapperBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        // try {
            CustomData dataEntity = customDataDAO.getCustomDataById(requestBean.getCdId(), true);

            if (dataEntity != null) {
                // CustomDataValue entity = new DozerBeanMapper().map(requestBean,
                // CustomDataValue.class);
                // Create the first level first
                CustomDataValue firstLevelEntity = new CustomDataValue();
                firstLevelEntity.setCdValueLevel(0);
                firstLevelEntity.setCustomData(dataEntity);

                firstLevelEntity.setCreateDt(new Date());
                firstLevelEntity.setStatus(SystemConstant.ACTIVE);

                //Create the parent entity first
                // customDataValueDAO.save(firstLevelEntity);

                //Then create the child entity
                for (CustomDataValueBean newValue : requestBean.getValueBeans()) {
                    CustomDataSetting settingEntity = customDataSettingDAO.getCustomDataSettingById(newValue.getCdsId(), true);
                    if (settingEntity != null) {
                        CustomDataValue secondLevelEntity = new CustomDataValue();
                        secondLevelEntity.setCdValueLevel(1);
                        secondLevelEntity.setParentValue(firstLevelEntity);
                        secondLevelEntity.setCustomDataSetting(settingEntity);
                        secondLevelEntity.setCdValue(
                                CommonServiceUtils.parseIntoDbValue(newValue.getCdValue(), settingEntity.getCdsType()));

                        secondLevelEntity.setCreateDt(new Date());
                        secondLevelEntity.setStatus(SystemConstant.ACTIVE);

                        customDataValueDAO.persist(secondLevelEntity);
                    }
                }

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        // } catch (Exception e) {
        //     responseBean.setResponseObject(e.getMessage());
        // }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean updateCustomDataValue(CustomDataValueBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomDataValue entity = customDataValueDAO.getCustomDataValueById(requestBean.getCdValueId(), false);

            if (entity != null) {
                // entity = new DozerBeanMapper().map(requestBean, CustomDataValue.class);
                // entity.setCdValue(requestBean.getCdValue());
                // entity.setCustomData(requestBean.getCustomData());
                // entity.setParentValue(requestBean.getParentValue());
                // entity.setChildValueList(requestBean.getChildValueList());
                entity.setModifyDt(new Date());

                customDataValueDAO.update(entity);

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean deleteCustomDataValue(DeleteEntityReqBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomDataValue entity = customDataValueDAO.getCustomDataValueById(requestBean.getEntityId(), false);

            if (entity != null) {
                customDataValueDAO.delete(entity);

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }
}