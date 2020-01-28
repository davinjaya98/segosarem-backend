package com.paparadaminteractive.artic.webservices.db.service;

import com.paparadaminteractive.artic.webservices.bean.GeneralWsResponseBean;
import com.paparadaminteractive.artic.webservices.bean.ItemBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.AddItemReqBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.DeleteEntityReqBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.ListItemResBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.ListItemReqBean;
import java.util.List;

public interface ItemService{
    
    public GeneralWsResponseBean save(AddItemReqBean requestBean);
    public GeneralWsResponseBean delete(DeleteEntityReqBean requestBean);
    public GeneralWsResponseBean deactive(DeleteEntityReqBean requestBean);
    public ListItemResBean getItemList(ListItemReqBean requestBean);
    public ListItemResBean getItemById(Integer itemId);

}