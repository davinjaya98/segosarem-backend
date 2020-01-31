package com.segosarem.web.webservices.bean.webservices;

import com.segosarem.web.webservices.bean.ItemCategoryBean;
import com.segosarem.web.webservices.bean.ItemSubCategoryBean;

public class AddItemSubCategoryReqBean {
    
    private ItemCategoryBean itemCategoryBean;
    private ItemSubCategoryBean itemSubCategoryBean;
    
    public void setItemCategoryBean(ItemCategoryBean itemCategoryBean) {
        this.itemCategoryBean = itemCategoryBean;
    }
    
    public ItemCategoryBean getItemCategoryBean() {
        return this.itemCategoryBean;
    }
    
    public void setItemSubCategoryBean(ItemSubCategoryBean itemSubCategoryBean) {
        this.itemSubCategoryBean = itemSubCategoryBean;
    }
    
    public ItemSubCategoryBean getItemSubCategoryBean() {
        return this.itemSubCategoryBean;
    }
}