package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.webservices.AddItemCategoryReqBean;
import com.segosarem.web.webservices.bean.webservices.DeleteEntityReqBean;
import com.segosarem.web.webservices.bean.webservices.ListItemCategoryResBean;

public interface ItemCategoryService {
    
    public GeneralWsResponseBean save(AddItemCategoryReqBean requestBean);
    public GeneralWsResponseBean delete(DeleteEntityReqBean requestBean);
    public GeneralWsResponseBean deactive(DeleteEntityReqBean requestBean);
    public ListItemCategoryResBean getItemCategoryList();
    public ListItemCategoryResBean getItemCategoryListById(Integer categoryId);
}