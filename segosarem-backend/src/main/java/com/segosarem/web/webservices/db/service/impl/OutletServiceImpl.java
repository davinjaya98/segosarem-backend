package com.segosarem.web.webservices.db.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.segosarem.web.webservices.db.dao.OutletDAO;
import com.segosarem.web.webservices.db.entity.Outlet;
import com.segosarem.web.webservices.db.service.OutletService;

//Bean
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.outlet.OutletBean;
import com.segosarem.web.webservices.bean.outlet.AddOutletReqBean;
import com.segosarem.web.webservices.bean.outlet.ListOutletResBean;

@Transactional
@Service("OutletService")
public class OutletServiceImpl implements OutletService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OutletDAO outletDAO;

	@Override
	public GeneralWsResponseBean save(AddOutletReqBean requestBean) {
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            String imageUrl = "blabla";
            Outlet entity = new Outlet();
            entity.setOutletName(requestBean.getOutletName());
            entity.setOutletDescription(requestBean.getOutletDescription());
            entity.setOutletSequence(requestBean.getOutletSequence());
            entity.setOutletImageUrl(imageUrl);

            entity.setCreateDt(new Date());
            entity.setStatus(SystemConstant.ACTIVE);

            outletDAO.save(entity);

            responseBean.setReturnCode(SystemConstant.SUCCESS);

        }catch(Exception e) {}

        return responseBean;
	}
    //delete row
	@Override
	public GeneralWsResponseBean delete(Integer outletId) {
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            //Find the id first
            Outlet entity = outletDAO.getOutletById(outletId);
    
            if(entity != null) {
                outletDAO.delete(entity);
            }

            responseBean.setReturnCode(SystemConstant.SUCCESS);

        }catch(Exception e) {}
        
        return responseBean;
    }
    
	@Override
	public GeneralWsResponseBean deactive(Integer outletId) {
        GeneralWsResponseBean responseBean = new GeneralWsResponseBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
    
        try{
            //Find the id first
            Outlet entity = outletDAO.getOutletById(outletId);

            if(entity != null) {
                entity.setStatus(SystemConstant.DEACTIVE);
                outletDAO.update(entity);
            }

            responseBean.setReturnCode(SystemConstant.SUCCESS);

        }catch(Exception e) {}
        
        return responseBean;
	}

	@Override
	public ListOutletResBean getOutletList() {
        ListOutletResBean responseBean = new ListOutletResBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
        
        List<Outlet> outletList = outletDAO.getOutletList();
        List<OutletBean> outletBeanList = new ArrayList<OutletBean>();

        if(outletList != null && !outletList.isEmpty()) {
            for(Outlet entity : outletList) {
                OutletBean outletBean = new OutletBean();
                outletBean.setOutletId(entity.getOutletId());
                outletBean.setOutletName(entity.getOutletName());
                outletBean.setOutletDescription(entity.getOutletDescription());
                outletBean.setOutletSequence(entity.getOutletSequence());
                outletBeanList.add(outletBean);
            }
            
            responseBean.setOutletBeanList(outletBeanList);
            responseBean.setReturnCode(SystemConstant.SUCCESS);
        }
        
		return responseBean;
	}

    @Override
    public ListOutletResBean getOutletById(Integer outletId){
        ListOutletResBean responseBean = new ListOutletResBean();
        responseBean.setReturnCode(SystemConstant.FAILED);
        
        Outlet entity = outletDAO.getOutletById(outletId);
        List<OutletBean> outletBeanList = new ArrayList<OutletBean>();
        if(entity != null) {
            OutletBean outletBean = new OutletBean();
            outletBean.setOutletId(entity.getOutletId());
            outletBean.setOutletName(entity.getOutletName());
            outletBean.setOutletDescription(entity.getOutletDescription());
            outletBeanList.add(outletBean);
            
            responseBean.setOutletBeanList(outletBeanList);
            responseBean.setReturnCode(SystemConstant.SUCCESS);
        }
        
		return responseBean;   
    }
}