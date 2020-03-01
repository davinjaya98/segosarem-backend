package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.customdatasetting.CustomDataSettingBean;

public interface CustomDataSettingService {

    public GeneralWsResponseBean addCustomDataSetting(CustomDataSettingBean requestBean);
    //This can be used to update status to active, deactivated, or deleted
    public GeneralWsResponseBean updateCustomDataSetting(CustomDataSettingBean requestBean);
}