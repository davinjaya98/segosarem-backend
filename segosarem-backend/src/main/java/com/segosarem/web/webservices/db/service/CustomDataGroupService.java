package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.customdatagroup.CustomDataGroupBean;

public interface CustomDataGroupService {
    
    public GeneralWsResponseBean getAllCustomDataGroup();
    public GeneralWsResponseBean getCustomDataGroupById(Integer id);

    public GeneralWsResponseBean addCustomDataGroup(CustomDataGroupBean requestBean);
    //This can be used to update status to active, deactivated, or deleted
    public GeneralWsResponseBean updateCustomDataGroup(CustomDataGroupBean requestBean);
    //This one effectively removed it from db
    public GeneralWsResponseBean deleteCustomDataGroup(DeleteEntityReqBean requestBean);
}