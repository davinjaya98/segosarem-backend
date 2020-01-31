package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.webservices.AddItemSubCategoryReqBean;
import com.segosarem.web.webservices.bean.webservices.ListItemSubCategoryResBean;
import com.segosarem.web.webservices.bean.webservices.DeleteEntityReqBean;
import java.util.List;

public interface ItemSubCategoryService {
    
    public GeneralWsResponseBean save(AddItemSubCategoryReqBean requestBean);
    public GeneralWsResponseBean delete(DeleteEntityReqBean requestBean);
    public GeneralWsResponseBean deactive(DeleteEntityReqBean requestBean);
    public ListItemSubCategoryResBean getItemSubCategoryList(Integer categoryId);
    public ListItemSubCategoryResBean getItemSubCategoryListById(Integer subCategoryId);
}