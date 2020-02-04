package com.segosarem.web.webservices.bean.customfield;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

public class GetCustomFieldResBean extends GeneralWsResponseBean {
    
    private CustomFieldBean customField;
    
    public CustomFieldBean getCustomField() {
        return this.customField;
    }

    public void setCustomField(CustomFieldBean customField) {
        this.customField = customField;
    }
}