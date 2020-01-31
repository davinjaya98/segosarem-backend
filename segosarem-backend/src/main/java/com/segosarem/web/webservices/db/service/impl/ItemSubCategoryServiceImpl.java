package com.segosarem.web.webservices.db.service.impl;

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
import com.segosarem.web.constant.SystemConstant;

//DB
import com.segosarem.web.webservices.db.dao.ItemCategoryDAO;
import com.segosarem.web.webservices.db.dao.ItemSubCategoryDAO;
import com.segosarem.web.webservices.db.entity.ItemCategory;
import com.segosarem.web.webservices.db.entity.ItemSubCategory;
import com.segosarem.web.webservices.db.service.ItemSubCategoryService;

//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.webservices.AddItemSubCategoryReqBean;
import com.segosarem.web.webservices.bean.webservices.DeleteEntityReqBean;
import com.segosarem.web.webservices.bean.webservices.ListItemSubCategoryResBean;
import com.segosarem.web.webservices.bean.ItemSubCategoryBean;

@Transactional
@Service("ItemSubCategoryService")
public class ItemSubCategoryServiceImpl implements ItemSubCategoryService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private ItemCategoryDAO itemCategoryDAO;
    
	@Autowired
	private ItemSubCategoryDAO itemSubCategoryDAO;

	@Override
	public GeneralWsResponseBean save(AddItemSubCategoryReqBean requestBean) {
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            //Find the id first
            ItemCategory itemCategoryEntity = itemCategoryDAO.getItemCategoryById(requestBean.getItemCategoryBean().getItemCategoryId());
    
            if(itemCategoryEntity != null) {
                ItemSubCategory entity = new ItemSubCategory();
                entity.setItemSubCategoryName(requestBean.getItemSubCategoryBean().getItemSubCategoryName());
                entity.setItemCategory(itemCategoryEntity);
                entity.setStatus(SystemConstant.ACTIVE);
                itemSubCategoryDAO.save(entity);
    
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
            ItemSubCategory entity = itemSubCategoryDAO.getItemSubCategoryById(requestBean.getEntityId());
    
            if(entity != null) {
                itemSubCategoryDAO.delete(entity);
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
            ItemSubCategory entity = itemSubCategoryDAO.getItemSubCategoryById(requestBean.getEntityId());
    
            if(entity != null) {
                entity.setStatus(SystemConstant.DEACTIVE);
                itemSubCategoryDAO.update(entity);
            }

            responseBean.setReturnCode(SystemConstant.SUCCESS);

        }catch(Exception e) {}
        
        return responseBean;
    }

    @Override
    public ListItemSubCategoryResBean getItemSubCategoryList(Integer categoryId){
        ListItemSubCategoryResBean responseBean = new ListItemSubCategoryResBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
        
        List<ItemSubCategory> itemSubCategoryList = itemSubCategoryDAO.getItemSubCategoryList(categoryId);
        List<ItemSubCategoryBean> itemSubCategoryBeanList = new ArrayList<ItemSubCategoryBean>();

        if(itemSubCategoryList != null && !itemSubCategoryList.isEmpty()) {
            for(ItemSubCategory entity : itemSubCategoryList) {
                ItemSubCategoryBean itemSubCategoryBean = new ItemSubCategoryBean();
                itemSubCategoryBean.setItemSubCategoryId(entity.getItemSubCategoryId());
                itemSubCategoryBean.setItemSubCategoryName(entity.getItemSubCategoryName());
                itemSubCategoryBean.setStatus(entity.getStatus());
                itemSubCategoryBeanList.add(itemSubCategoryBean);
            }
            
            responseBean.setItemSubCategoryBeanList(itemSubCategoryBeanList);
            responseBean.setReturnCode(SystemConstant.SUCCESS);
        }
        
		return responseBean;
    }

    @Override
    public ListItemSubCategoryResBean getItemSubCategoryListById(Integer subCategoryId){
        ListItemSubCategoryResBean responseBean = new ListItemSubCategoryResBean();
        responseBean.setReturnCode(SystemConstant.FAILED);

        ItemSubCategory itemSubCategory = itemSubCategoryDAO.getItemSubCategoryById(subCategoryId);
        List<ItemSubCategoryBean> itemSubCategoryBeanList = new ArrayList<ItemSubCategoryBean>();
        if(itemSubCategory != null){
            ItemSubCategoryBean itemSubCategoryBean = new ItemSubCategoryBean();
            itemSubCategoryBean.setItemSubCategoryId(itemSubCategory.getItemSubCategoryId());
            itemSubCategoryBean.setItemSubCategoryName(itemSubCategory.getItemSubCategoryName());
            itemSubCategoryBean.setStatus(itemSubCategory.getStatus());
            itemSubCategoryBeanList.add(itemSubCategoryBean);

            responseBean.setItemSubCategoryBeanList(itemSubCategoryBeanList);
            responseBean.setReturnCode(SystemConstant.SUCCESS);
        }

        return responseBean;
    }

}