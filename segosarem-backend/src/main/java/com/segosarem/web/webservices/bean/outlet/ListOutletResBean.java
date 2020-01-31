package com.segosarem.web.webservices.bean.outlet;

import java.util.List;

import com.segosarem.web.webservices.bean.outlet.OutletBean;
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

public class ListOutletResBean extends GeneralWsResponseBean{
    
    private List<OutletBean> outletBeanList;
    
    public void setOutletBeanList(List<OutletBean> outletBeanList) {
        this.outletBeanList = outletBeanList;
    }
    
    public List<OutletBean> getOutletBeanList() {
        return this.outletBeanList;
    }
}