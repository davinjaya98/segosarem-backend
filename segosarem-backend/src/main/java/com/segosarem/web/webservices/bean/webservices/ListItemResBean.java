package com.segosarem.web.webservices.bean.webservices;

import java.util.List;

import com.segosarem.web.webservices.bean.ItemBean;
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import java.util.List;

public class ListItemResBean extends GeneralWsResponseBean{

    private List<ItemBean> itemBeanList;

    public void setItemBeanList(List<ItemBean> itemBeanList) {
        this.itemBeanList = itemBeanList;
    }
    
    public List<ItemBean> getItemBeanList() {
        return this.itemBeanList;
    }
}