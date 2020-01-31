package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.outlet.AddOutletReqBean;
import com.segosarem.web.webservices.bean.outlet.ListOutletResBean;

public interface OutletService {
    
    public GeneralWsResponseBean save(AddOutletReqBean requestBean);
    public GeneralWsResponseBean delete(Integer outletId);
    public GeneralWsResponseBean deactive(Integer outletId);
    public ListOutletResBean getOutletList();
    public ListOutletResBean getOutletById(Integer outletId);
}