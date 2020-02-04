package com.segosarem.web.webservices.bean.customfield;

import java.util.List;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

public class ListCustomFieldGroupResBean extends GeneralWsResponseBean{
    
    private List<CustomFieldGroupBean> customFieldGroupList;
    
    public void setCustomFieldGroupList(List<CustomFieldGroupBean> customFieldGroupList) {
        this.customFieldGroupList = customFieldGroupList;
    }
    
    public List<CustomFieldGroupBean> getCustomFieldGroupList() {
        return this.customFieldGroupList;
    }
}