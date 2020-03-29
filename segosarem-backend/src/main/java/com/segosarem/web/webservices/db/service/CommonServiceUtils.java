package com.segosarem.web.webservices.db.service;

import com.segosarem.web.constant.SystemConstant;
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

//Common functions for services
public class CommonServiceUtils {

    // Generate initial response bean
    public static GeneralWsResponseBean generateResponseBean() {
        GeneralWsResponseBean obj = new GeneralWsResponseBean();
        obj.setReturnCode(SystemConstant.FAILED);

        return obj;
    }

    // Set response bean to success
    public static GeneralWsResponseBean setResponseToSuccess(GeneralWsResponseBean responseBean) {
        responseBean.setReturnCode(SystemConstant.SUCCESS);

        return responseBean;
    }

    // Parse value to the correct type
    public static Object parseValue(byte[] value, Integer type) {
        Object parsedValue = null;

        switch (type) {
            case SystemConstant.CUSTOM_DATA_SETTING_TEXTFIELD:
                parsedValue = new String(value);
                break;
            case SystemConstant.CUSTOM_DATA_SETTING_BOOLEAN:
                parsedValue = new String(value);
                break;
            case SystemConstant.CUSTOM_DATA_SETTING_IMAGE_PATH:
                //THIS IS ALREADY IN IMAGE PATH FORMAT
                parsedValue = new String(value);
                break;
            case SystemConstant.CUSTOM_DATA_SETTING_TEXTAREA:
                //THIS IS ALREADY IN IMAGE PATH FORMAT
                parsedValue = new String(value);
                break;
            case SystemConstant.CUSTOM_DATA_SETTING_IMAGE_BLOB:
                parsedValue = value;
                break;
        }

        return parsedValue;
    }

    // Parse value to the correct type
    public static byte[] parseIntoDbValue(String value, Integer type) {
        byte[] parsedValue = null;

        switch (type) {
            case SystemConstant.CUSTOM_DATA_SETTING_TEXTFIELD:
                parsedValue = value.getBytes();
                break;
            case SystemConstant.CUSTOM_DATA_SETTING_BOOLEAN:
                parsedValue = value.getBytes();
                break;
            case SystemConstant.CUSTOM_DATA_SETTING_IMAGE_PATH:
                //THIS SHOULD BE SAVING IMAGE INTO A FOLDER
                parsedValue = value.getBytes();
                break;
            case SystemConstant.CUSTOM_DATA_SETTING_TEXTAREA:
                //THIS IS ALREADY IN IMAGE PATH FORMAT
                parsedValue = value.getBytes();
                break;
            case SystemConstant.CUSTOM_DATA_SETTING_IMAGE_BLOB:
                parsedValue = value.getBytes();
                break;
        }

        return parsedValue;
    }
}