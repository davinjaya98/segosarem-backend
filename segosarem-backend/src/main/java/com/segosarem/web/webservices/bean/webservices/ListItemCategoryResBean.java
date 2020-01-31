package com.segosarem.web.webservices.bean.webservices;

import java.util.List;

import com.segosarem.web.webservices.bean.ItemCategoryBean;
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

public class ListItemCategoryResBean extends GeneralWsResponseBean{
    
    private List<ItemCategoryBean> itemCategoryBeanList;
    
    public void setItemCategoryBeanList(List<ItemCategoryBean> itemCategoryBeanList) {
        this.itemCategoryBeanList = itemCategoryBeanList;
    }
    
    public List<ItemCategoryBean> getItemCategoryBeanList() {
        return this.itemCategoryBeanList;
    }
}