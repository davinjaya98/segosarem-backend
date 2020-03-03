package com.segosarem.web.webservices.bean.customdatavalue;

import java.util.List;

public class AddValueWrapperBean {
    
    private Integer cdId;
    private List<CustomDataValueBean> valueBeans;


    public AddValueWrapperBean() {
    }

    public AddValueWrapperBean(Integer cdId, List<CustomDataValueBean> valueBeans) {
        this.cdId = cdId;
        this.valueBeans = valueBeans;
    }

    public Integer getCdId() {
        return this.cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }

    public List<CustomDataValueBean> getValueBeans() {
        return this.valueBeans;
    }

    public void setValueBeans(List<CustomDataValueBean> valueBeans) {
        this.valueBeans = valueBeans;
    }
}