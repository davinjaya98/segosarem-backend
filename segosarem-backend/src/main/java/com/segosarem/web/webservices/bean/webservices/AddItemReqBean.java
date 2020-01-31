package com.segosarem.web.webservices.bean.webservices;

import com.segosarem.web.webservices.bean.ItemBean;
import com.segosarem.web.webservices.bean.ItemSubCategoryBean;

public class AddItemReqBean {
    
    private ItemBean itemBean;
    private ItemSubCategoryBean itemSubCategoryBean;

    public void setItemBean(ItemBean itemBean) {
        this.itemBean = itemBean;
    }
    
    public ItemBean getItemBean() {
        return this.itemBean;
    }

    public void setItemSubCategoryBean(ItemSubCategoryBean itemSubCategoryBean) {
        this.itemSubCategoryBean = itemSubCategoryBean;
    }
    
    public ItemSubCategoryBean getItemSubCategoryBean() {
        return this.itemSubCategoryBean;
    }
}