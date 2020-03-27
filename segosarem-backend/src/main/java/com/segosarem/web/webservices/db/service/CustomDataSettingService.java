package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.customdatasetting.CustomDataSettingBean;

public interface CustomDataSettingService {

    public GeneralWsResponseBean addCustomDataSetting(CustomDataSettingBean requestBean);

    // This can be used to update status to active, deactivated, or deleted
    public GeneralWsResponseBean updateCustomDataSetting(CustomDataSettingBean requestBean);

    // get list of custom data settings by custom data id
    public GeneralWsResponseBean getCdSettingsListByCdId(Integer id);

    public GeneralWsResponseBean getCdSettingsById(Integer id);

    public GeneralWsResponseBean deleteCustomDataSetting(DeleteEntityReqBean requestBean);
}