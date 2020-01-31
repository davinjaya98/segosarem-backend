package com.segosarem.web.webservices.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//Services
import com.segosarem.web.webservices.db.service.OutletService;
import com.segosarem.web.webservices.db.service.ItemSubCategoryService;
import com.segosarem.web.webservices.db.service.ItemService;

//Beans
import com.segosarem.web.webservices.bean.ItemCategoryBean;
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.outlet.ListOutletResBean;
import com.segosarem.web.webservices.bean.outlet.AddOutletReqBean;

import com.segosarem.web.webservices.bean.webservices.DeleteEntityReqBean;
import com.segosarem.web.webservices.bean.webservices.ListItemSubCategoryResBean;
import com.segosarem.web.webservices.bean.webservices.AddItemSubCategoryReqBean;
import com.segosarem.web.webservices.bean.webservices.AddItemReqBean;
import com.segosarem.web.webservices.bean.webservices.ListItemReqBean;
import com.segosarem.web.webservices.bean.webservices.ListItemResBean;
import com.segosarem.web.webservices.bean.webservices.GetEntityReqBean;

import com.segosarem.web.constant.SystemConstant;

@RestController
public class SegosaremWebServices {

	private final Logger logger = Logger.getLogger(this.getClass());
	private ResourceBundle labels = ResourceBundle.getBundle("messages");
	//protected final String partner = "FAVE";

	// Services
	@Autowired
	OutletService outletService;
	@Autowired
	ItemSubCategoryService itemSubCategoryService;
	@Autowired
	ItemService itemService;
	// Services

	//Outlets
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getOutletList")
	public ListOutletResBean getOutletList(HttpServletRequest request, HttpServletResponse response) {

		return (ListOutletResBean) outletService.getOutletList();
	}

	//Supposed to be for secure access only
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/addOutlet", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean addOutlet(HttpServletRequest request, HttpServletResponse response,
			@RequestBody AddOutletReqBean requestBean) {

		return (GeneralWsResponseBean) outletService.save(requestBean);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/deleteOutlet", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean deleteOutlet(HttpServletRequest request, HttpServletResponse response,
			@RequestBody DeleteEntityReqBean requestBean) {

		Integer outletId = requestBean.getEntityId();

		return (GeneralWsResponseBean) outletService.deactive(outletId);
	}
	//subcategory
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getItemSubCategoryList", consumes = { "application/json" }, produces = {
		"application/json" })
	public ListItemSubCategoryResBean getItemSubCategoryList(HttpServletRequest request, HttpServletResponse response, @RequestBody GetEntityReqBean requestBean) {

		ListItemSubCategoryResBean responseBean = new ListItemSubCategoryResBean();
		if(requestBean!=null)
			return (ListItemSubCategoryResBean) itemSubCategoryService.getItemSubCategoryList(requestBean.getEntityId());

		responseBean.setReturnCode("111111");
		return responseBean;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/addItemSubCategory", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean addItemSubCategory(HttpServletRequest request, HttpServletResponse response,
			@RequestBody AddItemSubCategoryReqBean requestBean) {

		return (GeneralWsResponseBean) itemSubCategoryService.save(requestBean);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/deleteItemSubCategory", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean deleteItemSubCategory(HttpServletRequest request, HttpServletResponse response,
			@RequestBody DeleteEntityReqBean requestBean) {

		return (GeneralWsResponseBean) itemSubCategoryService.deactive(requestBean);
	}
	//item
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getItemList", consumes = { "application/json" }, produces = {
			"application/json" })
	public ListItemResBean getItemList(HttpServletRequest request, HttpServletResponse response, @RequestBody ListItemReqBean requestBean) {

		ListItemResBean responseBean = new ListItemResBean();

		return (ListItemResBean) itemService.getItemList(requestBean);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getItemById", consumes = { "application/json" }, produces = {
			"application/json" })
	public ListItemResBean getItemById(HttpServletRequest request, HttpServletResponse response,
			@RequestBody GetEntityReqBean requestBean) {
		
		ListItemResBean responseBean = new ListItemResBean();

		if(requestBean!=null)
			return (ListItemResBean) itemService.getItemById(requestBean.getEntityId());

		responseBean.setReturnCode("111111");
		return responseBean;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/addItem", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean addItem(HttpServletRequest request, HttpServletResponse response,
			@RequestBody AddItemReqBean requestBean) {

		return (GeneralWsResponseBean) itemService.save(requestBean);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/deleteItem", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean deleteItem(HttpServletRequest request, HttpServletResponse response,
			@RequestBody DeleteEntityReqBean requestBean) {

		return (GeneralWsResponseBean) itemService.deactive(requestBean);
	}

	//Supposed to be for secure access only

	/*@ResponseBody
	@RequestMapping(value = "/getImage/{imageName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("imageName") String imageName) throws IOException {
		try {
			InputStream is = new FileInputStream("/images/no_image.jpg");
			is.close();

			return IOUtils.toByteArray(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}*/
}
