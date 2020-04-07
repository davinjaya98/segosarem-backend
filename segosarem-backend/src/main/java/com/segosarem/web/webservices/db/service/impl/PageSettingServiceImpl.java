package com.segosarem.web.webservices.db.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.segosarem.web.webservices.db.dao.CustomDataDAO;
import com.segosarem.web.webservices.db.dao.CustomDataGroupDAO;

import com.segosarem.web.webservices.db.entity.PageSetting;
import com.segosarem.web.webservices.db.entity.CustomData;
import com.segosarem.web.webservices.db.entity.CustomDataGroup;
import com.segosarem.web.webservices.db.entity.CustomDataValue;

import com.segosarem.web.webservices.db.service.CommonServiceUtils;
import com.segosarem.web.webservices.db.service.PageSettingService;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;
//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.customdata.CustomDataBean;
import com.segosarem.web.webservices.bean.customdatagroup.CustomDataGroupBean;
import com.segosarem.web.webservices.bean.pagesetting.PageSettingBean;

@Transactional
@Service("PageSettingService")
public class PageSettingServiceImpl implements PageSettingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PageSettingDAO pageSettingDAO;

    @Autowired
    private CustomDataDAO customDataDAO;

    @Autowired
    private CustomDataGroupDAO customDataGroupDAO;

    @Override
    public GeneralWsResponseBean getAllPageSetting() {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            List<PageSetting> entityList = pageSettingDAO.getAllPageSetting();

            if (entityList != null && !entityList.isEmpty()) {
                List<PageSettingBean> beanList = new ArrayList<PageSettingBean>();
                for (PageSetting entity : entityList) {
                    PageSettingBean bean = new DozerBeanMapper().map(entity, PageSettingBean.class);

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
    public GeneralWsResponseBean getPageSettingById(Integer id) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            PageSetting entity = pageSettingDAO.getPageSettingById(id, true);

            if (entity != null) {
                PageSettingBean bean = new DozerBeanMapper().map(entity, PageSettingBean.class);

                responseBean.setResponseObject(bean);
                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }

        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean getPageSettingByKey(String key) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            // Get page setting first - 1
            PageSetting pageSettingEntity = pageSettingDAO.getPageSettingByKey(key, true);

            if (pageSettingEntity != null) {
                // Get page setting first - 2
                PageSettingBean pageSettingBean = new DozerBeanMapper().map(pageSettingEntity, PageSettingBean.class);

                // Get custom data group
                List<CustomDataGroupBean> customDataGroupBeanList = pageSettingBean.getCustomDataGroupList();

                if (customDataGroupBeanList != null && !customDataGroupBeanList.isEmpty()) {
                    for (CustomDataGroupBean customDataGroupBean : customDataGroupBeanList) {
                        // Get custom data
                        List<CustomDataBean> customDataBeanList = customDataGroupBean.getCustomDataList();

                        if (customDataBeanList != null && !customDataBeanList.isEmpty()) {
                            // Logic to update custom data bean with a key value pair data from setting and
                            // value
                            for (CustomDataBean customDataBean : customDataBeanList) {
                                CustomData customDataEntity = customDataDAO
                                        .getCustomDataByKey(customDataBean.getCdKey(), true);

                                if (customDataEntity != null) {
                                    if (customDataEntity.getCdValueList() != null
                                            && !customDataEntity.getCdValueList().isEmpty()) {
                                        List<Map<String, Object>> cdValuePairs = new ArrayList<Map<String, Object>>();

                                        // Because only the parent 0 tagged into the CustomData Entity
                                        for (CustomDataValue parentValue : customDataEntity.getCdValueList()) {
                                            if (parentValue.getChildValueList() != null
                                                    && !parentValue.getChildValueList().isEmpty()) {
                                                Map<String, Object> cdValuePair = new LinkedHashMap<String, Object>();
                                                cdValuePair.put("parentId", parentValue.getCdValueId());

                                                Map<String, Object> cdValueChildPair = new LinkedHashMap<String, Object>();
                                                for (CustomDataValue childValue : parentValue.getChildValueList()) {
                                                    Map<String, Object> keyValuePair = new LinkedHashMap<String, Object>();
                                                    keyValuePair.put("fieldType",
                                                            childValue.getCustomDataSetting().getCdsType());
                                                    keyValuePair.put("value",
                                                            CommonServiceUtils.parseValue(childValue.getCdValue(),
                                                                    childValue.getCustomDataSetting().getCdsType()));

                                                    cdValueChildPair.put(childValue.getCustomDataSetting().getCdsKey(),
                                                            keyValuePair);
                                                }
                                                cdValuePair.put("value", cdValueChildPair);

                                                cdValuePairs.add(cdValuePair);
                                            }
                                        }

                                        customDataBean.setCdValuePair(cdValuePairs);
                                    }
                                }
                            }
                        }
                    }
                }

                responseBean.setResponseObject(pageSettingBean);
                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }

        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean getAllValueByPageSettingKey(String key) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            Map<String, Object> responseObj = new LinkedHashMap<String, Object>();
            // Get page setting first - 1
            String[] keyList = key.split(",");
            for (String splitKey : keyList) {
                PageSetting pageSettingEntity = pageSettingDAO.getPageSettingByKey(splitKey, true);

                if (pageSettingEntity != null) {
                    // Set the page setting
                    Map<String, Object> pageSettingObject = new LinkedHashMap<String, Object>();
                    pageSettingObject.put("title", pageSettingEntity.getPageTitle());
                    pageSettingObject.put("description", pageSettingEntity.getPageDescription());
                    pageSettingObject.put("seoKeywords", pageSettingEntity.getPageSeoKeywords());

                    responseObj.put("pageSetting", pageSettingObject);

                    Map<String, Object> pageSettingValue = new LinkedHashMap<String, Object>();

                    // Get custom data group
                    List<CustomDataGroup> customDataGroupList = pageSettingEntity.getCustomDataGroupList();

                    if (customDataGroupList != null && !customDataGroupList.isEmpty()) {
                        for (CustomDataGroup customDataGroup : customDataGroupList) {
                            // Get custom data
                            List<CustomData> customDataList = customDataGroup.getCustomDataList();

                            if (customDataList != null && !customDataList.isEmpty()) {
                                for (CustomData customData : customDataList) {

                                    List<CustomDataValue> parentValueList = customData.getCdValueList();

                                    List<Map<String, Object>> valueMap = new ArrayList<Map<String, Object>>();

                                    if (parentValueList != null && !parentValueList.isEmpty()) {
                                        for (CustomDataValue parentValue : parentValueList) {
                                            List<CustomDataValue> childValueList = parentValue.getChildValueList();

                                            Map<String, Object> childMap = new LinkedHashMap<String, Object>();
                                            for (CustomDataValue childValue : childValueList) {
                                                childMap.put(childValue.getCustomDataSetting().getCdsKey(),
                                                        CommonServiceUtils.parseValue(childValue.getCdValue(),
                                                                childValue.getCustomDataSetting().getCdsType()));
                                            }
                                            valueMap.add(childMap);
                                        }
                                    }
                                    pageSettingValue.put(customData.getCdKey(), valueMap);
                                }
                            }
                        }
                    }

                    responseObj.put(pageSettingEntity.getPageKey(), pageSettingValue);
                }
            }

            responseBean.setResponseObject(responseObj);
            responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);

        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean addPageSetting(PageSettingBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            PageSetting entity = new DozerBeanMapper().map(requestBean, PageSetting.class);
            entity.setCreateDt(new Date());
            entity.setStatus(SystemConstant.ACTIVE);

            pageSettingDAO.save(entity);

            responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean updatePageSetting(PageSettingBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            PageSetting entity = pageSettingDAO.getPageSettingById(requestBean.getSettingId(), false);

            if (entity != null) {
                // entity = new DozerBeanMapper().map(requestBean, PageSetting.class);
                // entity.setPageKey(requestBean.getPageKey());
                entity.setPageSeoKeywords(requestBean.getPageSeoKeywords());
                entity.setPageDescription(requestBean.getPageDescription());
                entity.setPageTitle(requestBean.getPageTitle());
                entity.setPageSequence(requestBean.getPageSequence());
                // entity.setStatus(requestBean.getStatus());
                entity.setModifyDt(new Date());

                pageSettingDAO.update(entity);

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }

    @Override
    public GeneralWsResponseBean deletePageSetting(DeleteEntityReqBean requestBean) {
        GeneralWsResponseBean responseBean = CommonServiceUtils.generateResponseBean();
        try {
            PageSetting entity = pageSettingDAO.getPageSettingById(requestBean.getEntityId(), false);

            if (entity != null) {
                pageSettingDAO.delete(entity);

                responseBean = CommonServiceUtils.setResponseToSuccess(responseBean);
            }
        } catch (Exception e) {
            responseBean.setResponseObject(e.getMessage());
        }

        return responseBean;
    }
}