package com.paparadaminteractive.artic.webservices.db.service;

import com.paparadaminteractive.artic.webservices.bean.GeneralWsResponseBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.AddItemCategoryReqBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.DeleteEntityReqBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.ListItemCategoryResBean;

public interface ItemCategoryService {
    
    public GeneralWsResponseBean save(AddItemCategoryReqBean requestBean);
    public GeneralWsResponseBean delete(DeleteEntityReqBean requestBean);
    public GeneralWsResponseBean deactive(DeleteEntityReqBean requestBean);
    public ListItemCategoryResBean getItemCategoryList();
    public ListItemCategoryResBean getItemCategoryListById(Integer categoryId);
}