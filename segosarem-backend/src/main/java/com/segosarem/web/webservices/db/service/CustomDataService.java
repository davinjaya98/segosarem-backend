package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.customdata.CustomDataBean;

public interface CustomDataService {

    public GeneralWsResponseBean getAllCustomData();

    public GeneralWsResponseBean getCustomDataListByCdGroupId(Integer id);

    public GeneralWsResponseBean getCustomDataById(Integer id);

    public GeneralWsResponseBean getCustomDataByKey(String key);

    public GeneralWsResponseBean addCustomData(CustomDataBean requestBean);

    // This can be used to update status to active, deactivated, or deleted
    public GeneralWsResponseBean updateCustomData(CustomDataBean requestBean);

    // This one effectively removed it from db
    public GeneralWsResponseBean deleteCustomData(DeleteEntityReqBean requestBean);
}