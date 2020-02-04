package com.segosarem.web.webservices.bean.customfield;

import java.util.List;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

public class GetCustomFieldGroupResBean extends GeneralWsResponseBean {
    
    private CustomFieldGroupBean customFieldGroup;
    private List<CustomFieldBean> customFieldList;
    
    public CustomFieldGroupBean getCustomFieldGroup() {
        return this.customFieldGroup;
    }

    public void setCustomFieldGroup(CustomFieldGroupBean customFieldGroup) {
        this.customFieldGroup = customFieldGroup;
    }
    
    public List<CustomFieldBean> getCustomFieldList() {
        return this.customFieldList;
    }

    public void setCustomFieldList(List<CustomFieldBean> customFieldList) {
        this.customFieldList = customFieldList;
    }
}