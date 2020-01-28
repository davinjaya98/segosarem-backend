package com.paparadaminteractive.artic.webservices.bean.webservices;

import com.paparadaminteractive.artic.webservices.bean.ItemCategoryBean;
import com.paparadaminteractive.artic.webservices.bean.ItemSubCategoryBean;

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