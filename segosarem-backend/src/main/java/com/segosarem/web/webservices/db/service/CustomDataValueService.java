package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.customdatavalue.AddValueWrapperBean;
import com.segosarem.web.webservices.bean.customdatavalue.CustomDataValueBean;

public interface CustomDataValueService {
    
    public GeneralWsResponseBean getAllCustomDataValue();
    public GeneralWsResponseBean getCustomDataValueById(Integer id);

    public GeneralWsResponseBean addOrUpdateCustomDataValue(AddValueWrapperBean requestBean);
    //This can be used to update status to active, deactivated, or deleted
    public GeneralWsResponseBean updateCustomDataValue(CustomDataValueBean requestBean);
    //This one effectively removed it from db
    public GeneralWsResponseBean deleteCustomDataValue(DeleteEntityReqBean requestBean);
}