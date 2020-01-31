package com.segosarem.web.webservices.bean.webservices;

import com.segosarem.web.webservices.bean.ItemCategoryBean;

public class AddItemCategoryReqBean {
    
    private ItemCategoryBean itemCategoryBean;
    
    public void setItemCategoryBean(ItemCategoryBean itemCategoryBean) {
        this.itemCategoryBean = itemCategoryBean;
    }
    
    public ItemCategoryBean getItemCategoryBean() {
        return this.itemCategoryBean;
    }
}