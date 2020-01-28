package com.paparadaminteractive.artic.webservices.bean.webservices;

import java.util.List;

import com.paparadaminteractive.artic.webservices.bean.ItemSubCategoryBean;
import com.paparadaminteractive.artic.webservices.bean.GeneralWsResponseBean;

import java.util.List;

public class ListItemSubCategoryResBean extends GeneralWsResponseBean{

    private List<ItemSubCategoryBean> itemSubCategoryBeanList;

    public void setItemSubCategoryBeanList(List<ItemSubCategoryBean> itemSubCategoryBeanList) {
        this.itemSubCategoryBeanList = itemSubCategoryBeanList;
    }
    
    public List<ItemSubCategoryBean> getItemSubCategoryBeanList() {
        return this.itemSubCategoryBeanList;
    }
}