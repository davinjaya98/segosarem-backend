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
import com.paparadaminteractive.artic.webservices.db.entity.ItemCategory;
import com.paparadaminteractive.artic.webservices.db.service.ItemCategoryService;

//Bean
import com.paparadaminteractive.artic.webservices.bean.ItemCategoryBean;
import com.paparadaminteractive.artic.webservices.bean.GeneralWsResponseBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.AddItemCategoryReqBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.DeleteEntityReqBean;
import com.paparadaminteractive.artic.webservices.bean.webservices.ListItemCategoryResBean;

@Transactional
@Service("ItemCategoryService")
public class ItemCategoryServiceImpl implements ItemCategoryService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ItemCategoryDAO itemCategoryDAO;

	@Override
	public GeneralWsResponseBean save(AddItemCategoryReqBean requestBean) {
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            ItemCategory entity = new ItemCategory();
            entity.setItemCategoryName(requestBean.getItemCategoryBean().getItemCategoryName());
            entity.setStatus(SystemConstant.ACTIVE);
            itemCategoryDAO.save(entity);

            responseBean.setReturnCode(SystemConstant.SUCCESS);

        }catch(Exception e) {}

        return responseBean;
	}
    //delete row
	@Override
	public GeneralWsResponseBean delete(DeleteEntityReqBean requestBean) {
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            //Find the id first
            ItemCategory entity = itemCategoryDAO.getItemCategoryById(requestBean.getEntityId());
    
            if(entity != null) {
                itemCategoryDAO.delete(entity);
            }

            responseBean.setReturnCode(SystemConstant.SUCCESS);

        }catch(Exception e) {}
        
        return responseBean;
    }
    
	@Override
	public GeneralWsResponseBean deactive(DeleteEntityReqBean requestBean) {
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            //Find the id first
            ItemCategory entity = itemCategoryDAO.getItemCategoryById(requestBean.getEntityId());

            if(entity != null) {
                entity.setStatus(SystemConstant.DEACTIVE);
                itemCategoryDAO.update(entity);
            }

            responseBean.setReturnCode(SystemConstant.SUCCESS);

        }catch(Exception e) {}
        
        return responseBean;
	}

	@Override
	public ListItemCategoryResBean getItemCategoryList() {
        ListItemCategoryResBean responseBean = new ListItemCategoryResBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
        
        List<ItemCategory> itemCategoryList = itemCategoryDAO.getItemCategoryList();
        List<ItemCategoryBean> itemCategoryBeanList = new ArrayList<ItemCategoryBean>();

        if(itemCategoryList != null && !itemCategoryList.isEmpty()) {
            for(ItemCategory entity : itemCategoryList) {
                ItemCategoryBean itemCategoryBean = new ItemCategoryBean();
                itemCategoryBean.setItemCategoryId(entity.getItemCategoryId());
                itemCategoryBean.setItemCategoryName(entity.getItemCategoryName());
                itemCategoryBean.setStatus(entity.getStatus());
                itemCategoryBeanList.add(itemCategoryBean);
            }
            
            responseBean.setItemCategoryBeanList(itemCategoryBeanList);
            responseBean.setReturnCode(SystemConstant.SUCCESS);
        }
        
		return responseBean;
	}

    @Override
    public ListItemCategoryResBean getItemCategoryListById(Integer categoryId){
        ListItemCategoryResBean responseBean = new ListItemCategoryResBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
        
        ItemCategory itemCategory = itemCategoryDAO.getItemCategoryById(categoryId);
        List<ItemCategoryBean> itemCategoryBeanList = new ArrayList<ItemCategoryBean>();
        if(itemCategory != null) {
            ItemCategoryBean itemCategoryBean = new  ItemCategoryBean();
            itemCategoryBean.setItemCategoryId(itemCategory.getItemCategoryId());
            itemCategoryBean.setItemCategoryName(itemCategory.getItemCategoryName());
            itemCategoryBean.setStatus(itemCategory.getStatus());
            itemCategoryBeanList.add(itemCategoryBean);
            
            responseBean.setItemCategoryBeanList(itemCategoryBeanList);
            responseBean.setReturnCode(SystemConstant.SUCCESS);
        }
        
		return responseBean;   
    }
}