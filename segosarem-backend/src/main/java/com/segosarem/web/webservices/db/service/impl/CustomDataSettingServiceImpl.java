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
import com.segosarem.web.webservices.db.dao.CustomDataDAO;
import com.segosarem.web.webservices.db.dao.CustomDataSettingDAO;
import com.segosarem.web.webservices.db.entity.CustomData;
import com.segosarem.web.webservices.db.entity.CustomDataSetting;
import com.segosarem.web.webservices.db.service.CommonServiceUtils;

import com.segosarem.web.webservices.db.service.CustomDataSettingService;
//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.customdatasetting.CustomDataSettingBean;
import com.segosarem.web.webservices.bean.DeleteEntityReqBean;

@Transactional
@Service("CustomDataSettingServiceImpl")
public class CustomDataSettingServiceImpl implements CustomDataSettingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomDataDAO customDataDAO;

    @Autowired
    private CustomDataSettingDAO customDataSettingDAO;

    @Override
    public GeneralWsResponseBean addCustomDataSetting(CustomDataSettingBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();

        try {
            // Get the Custom Data to slot to first
            CustomData customData = customDataDAO.getCustomDataById(requestBean.getCdId(), true);

            if (customData != null) {
                CustomDataSetting newCustomDataSettingEntity = new DozerBeanMapper().map(requestBean,
                        CustomDataSetting.class);
                newCustomDataSettingEntity.setCustomData(customData);

                newCustomDataSettingEntity.setCreateDt(new Date());
                newCustomDataSettingEntity.setStatus(SystemConstant.ACTIVE);

                // Add the new custom data group
                customDataSettingDAO.save(newCustomDataSettingEntity);

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        } catch (Exception e) {
            responseBean.setResponseObject(e);
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean updateCustomDataSetting(CustomDataSettingBean requestBean) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GeneralWsResponseBean getCdSettingsListByCdId(Integer id) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            List<CustomDataSetting> entityList = customDataSettingDAO.getCdSettingsListByCdId(id);

            if (entityList != null && !entityList.isEmpty()) {
                List<CustomDataSettingBean> beanList = new ArrayList<CustomDataSettingBean>();
                for (CustomDataSetting entity : entityList) {
                    CustomDataSettingBean bean = new DozerBeanMapper().map(entity, CustomDataSettingBean.class);
                    bean.setCdId(entity.getCustomData().getCdId());
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
    public GeneralWsResponseBean getCdSettingsById(Integer id) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomDataSetting entity = customDataSettingDAO.getCustomDataSettingById(id, true);

            if (entity != null) {
                CustomDataSettingBean bean = new DozerBeanMapper().map(entity, CustomDataSettingBean.class);

                responseBean.setResponseObject(bean);
                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }

        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean deleteCustomDataSetting(DeleteEntityReqBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            CustomDataSetting entity = customDataSettingDAO.getCustomDataSettingById(requestBean.getEntityId(), false);

            if (entity != null) {
                customDataSettingDAO.delete(entity);

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }
}