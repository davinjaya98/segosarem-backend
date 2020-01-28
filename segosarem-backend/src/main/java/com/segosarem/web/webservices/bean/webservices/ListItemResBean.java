package com.paparadaminteractive.artic.webservices.bean.webservices;

import java.util.List;

import com.paparadaminteractive.artic.webservices.bean.ItemBean;
import com.paparadaminteractive.artic.webservices.bean.GeneralWsResponseBean;

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