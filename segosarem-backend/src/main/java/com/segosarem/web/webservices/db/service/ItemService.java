package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.ItemBean;
import com.segosarem.web.webservices.bean.webservices.AddItemReqBean;
import com.segosarem.web.webservices.bean.webservices.DeleteEntityReqBean;
import com.segosarem.web.webservices.bean.webservices.ListItemResBean;
import com.segosarem.web.webservices.bean.webservices.ListItemReqBean;
import java.util.List;

public interface ItemService{
    
    public GeneralWsResponseBean save(AddItemReqBean requestBean);
    public GeneralWsResponseBean delete(DeleteEntityReqBean requestBean);
    public GeneralWsResponseBean deactive(DeleteEntityReqBean requestBean);
    public ListItemResBean getItemList(ListItemReqBean requestBean);
    public ListItemResBean getItemById(Integer itemId);

}