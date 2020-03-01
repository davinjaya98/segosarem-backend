package com.segosarem.web.webservices.db.service;

import com.segosarem.web.constant.SystemConstant;
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

//Common functions for services
public class CommonServiceUtils {

    //Generate initial response bean
    public static GeneralWsResponseBean generateResponseBean() {
        GeneralWsResponseBean obj = new GeneralWsResponseBean();
        obj.setReturnCode(SystemConstant.FAILED);

        return obj;
    }

    //Set response bean to success
    public static GeneralWsResponseBean setResponseToSuccess(GeneralWsResponseBean responseBean) {
        responseBean.setReturnCode(SystemConstant.SUCCESS);

        return responseBean;
    }
}