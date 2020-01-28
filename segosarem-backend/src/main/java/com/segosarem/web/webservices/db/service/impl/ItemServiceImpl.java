package com.paparadaminteractive.artic.webservices.db.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Constant
import com.paparadaminteractive.artic.constant.SystemConstant;

//DB
import com.paparadaminteractive.artic.webservices.db.dao.ItemCategoryDAO;
import com.paparadaminteractive.artic.webservices.db.dao.ItemSubCategoryDAO;
import com.paparadaminteractive.artic.webservices.db.dao.ItemDAO;
import com.paparadaminteractive.artic.webservices.db.entity.ItemCategory;
import com.paparadaminteractive.artic.webservices.db.entity.ItemSubCategory;
import com.paparadaminteractive.artic.webservices.db.entity.Item;
import com.paparadaminteractive.artic.webservices.db.service.ItemService;

//Bean
import com.paparadaminteractive.artic.webservices.bean.ItemBean;
import com.paparadaminteractive.artic.webservices.bean.GeneralWsResponseBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.AddItemReqBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.DeleteEntityReqBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.ListItemResBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.ListItemReqBean;

@Transactional
@Service("ItemService")
public class ItemServiceImpl implements ItemService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private ItemDAO itemDAO;
    
	@Autowired
	private ItemSubCategoryDAO itemSubCategoryDAO;

	@Override
	public GeneralWsResponseBean save(AddItemReqBean requestBean) {
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            //Find the id first
            ItemSubCategory itemSubCategoryEntity = itemSubCategoryDAO.getItemSubCategoryById(requestBean.getItemSubCategoryBean().getItemSubCategoryId());
    
            if(itemSubCategoryEntity != null) {
                Item entity = new Item();
                entity.setItemName(requestBean.getItemBean().getItemName());
                entity.setItemPrice(requestBean.getItemBean().getItemPrice());
                entity.setItemSKU(requestBean.getItemBean().getItemSKU());
                entity.setItemSubCategory(itemSubCategoryEntity);
                entity.setStatus(SystemConstant.ACTIVE);
                itemDAO.save(entity);
    
                responseBean.setReturnCode(SystemConstant.SUCCESS);
            }

        }catch(Exception e) {}

        return responseBean;
	}

    @Override
    public GeneralWsResponseBean delete(DeleteEntityReqBean requestBean){
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            //Find the id first
            Item entity = itemDAO.getItemById(requestBean.getEntityId());
    
            if(entity != null) {
                itemDAO.delete(entity);
            }

            responseBean.setReturnCode(SystemConstant.SUCCESS);

        }catch(Exception e) {}
        
        return responseBean;
    }

    @Override
    public GeneralWsResponseBean deactive(DeleteEntityReqBean requestBean){
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            //Find the id first
            Item entity = itemDAO.getItemById(requestBean.getEntityId());
    
            if(entity != null) {
                entity.setStatus(SystemConstant.DEACTIVE);
                itemDAO.update(entity);
            }

            responseBean.setReturnCode(SystemConstant.SUCCESS);

        }catch(Exception e) {}
        
        return responseBean;
    }

    @Override
    public ListItemResBean getItemList(ListItemReqBean requestBean){
        ListItemResBean responseBean = new ListItemResBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
        
        Integer subCategoryId = requestBean.getSubCategoryId();
        String itemName = requestBean.getItemName();
        String itemPriceMin = requestBean.getItemPriceMin();
        String itemPriceMax = requestBean.getItemPriceMax();
        List<Item> itemList = itemDAO.getItemList(subCategoryId,itemName,itemPriceMin,itemPriceMax);
        List<ItemBean> itemBeanList = new ArrayList<ItemBean>();

        if(itemList != null && !itemList.isEmpty()) {
            for(Item entity : itemList) {
                ItemBean itemBean = new ItemBean();
                itemBean.setItemId(entity.getItemId());
                itemBean.setItemName(entity.getItemName());
                itemBean.setItemPrice(entity.getItemPrice());
                itemBean.setItemSKU(entity.getItemSKU());
                itemBean.setStatus(entity.getStatus());
                itemBeanList.add(itemBean);
            }
            
            responseBean.setItemBeanList(itemBeanList);
            responseBean.setReturnCode(SystemConstant.SUCCESS);
        }
        
		return responseBean;
    }
    @Override
    public ListItemResBean getItemById(Integer itemId){
        ListItemResBean responseBean = new ListItemResBean();
        responseBean.setReturnCode(SystemConstant.FAILED);

        Item item = itemDAO.getItemById(itemId);
        List<ItemBean> itemBeanList = new ArrayList<ItemBean>();
        if(item != null){
            ItemBean itemBean = new ItemBean();
            itemBean.setItemId(item.getItemId());
            itemBean.setItemName(item.getItemName());
            itemBean.setItemPrice(item.getItemPrice());
            itemBean.setItemSKU(item.getItemSKU());
            itemBean.setStatus(item.getStatus());
            itemBeanList.add(itemBean);

            responseBean.setItemBeanList(itemBeanList);
            responseBean.setReturnCode(SystemConstant.SUCCESS);
        }

        return responseBean;
    }
}