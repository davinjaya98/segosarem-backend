package com.paparadaminteractive.artic.webservices.db.service;

import com.paparadaminteractive.artic.webservices.bean.GeneralWsResponseBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.AddItemSubCategoryReqBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.ListItemSubCategoryResBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.DeleteEntityReqBean;
import java.util.List;

public interface ItemSubCategoryService {
    
    public GeneralWsResponseBean save(AddItemSubCategoryReqBean requestBean);
    public GeneralWsResponseBean delete(DeleteEntityReqBean requestBean);
    public GeneralWsResponseBean deactive(DeleteEntityReqBean requestBean);
    public ListItemSubCategoryResBean getItemSubCategoryList(Integer categoryId);
    public ListItemSubCategoryResBean getItemSubCategoryListById(Integer subCategoryId);
}