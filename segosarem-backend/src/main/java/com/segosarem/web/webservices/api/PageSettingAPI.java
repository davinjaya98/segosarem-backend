package com.segosarem.web.webservices.api;

import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//Services
import com.segosarem.web.webservices.db.service.PageSettingService;

//Beans
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.pagesetting.PageSettingBean;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Page Setting API", description="API Operations for page setting logic")
public class PageSettingAPI {

	private final Logger logger = Logger.getLogger(this.getClass());
	private ResourceBundle labels = ResourceBundle.getBundle("messages");
	//protected final String partner = "FAVE";

	// Services
	@Autowired
	PageSettingService pageSettingService;
	// Services

	//Outlets
    @ApiOperation(value = "Get a list of page setting", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getPageList")
	public GeneralWsResponseBean getPageSettingList(HttpServletRequest request, HttpServletResponse response) {
		
		return (GeneralWsResponseBean) pageSettingService.getAllPageSetting();
	}

    @ApiOperation(value = "Get page setting by id", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Get the details"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getPageSettingById", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean getPageSettingById(HttpServletRequest request, HttpServletResponse response,
			@RequestBody PageSettingBean requestBean) {

		return (GeneralWsResponseBean) pageSettingService.getPageSettingById(requestBean.getSettingId());
	}

    @ApiOperation(value = "Get page setting by key", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Get the details"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getPageSettingByKey", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean getPageSetting(HttpServletRequest request, HttpServletResponse response,
			@RequestBody PageSettingBean requestBean) {

		return (GeneralWsResponseBean) pageSettingService.getPageSettingByKey(requestBean.getPageKey());
	}

	//Supposed to be for secure access only
    @ApiOperation(value = "Add page setting", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Added"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/addPageSetting", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean addPageSetting(HttpServletRequest request, HttpServletResponse response,
			@RequestBody PageSettingBean requestBean) {

		return (GeneralWsResponseBean) pageSettingService.addPageSetting(requestBean);
	}

    @ApiOperation(value = "Update page setting / Also can be used to update status to either active, deactive, or deleted", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Updated"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/updatePageSetting", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean updatePageSetting(HttpServletRequest request, HttpServletResponse response,
			@RequestBody PageSettingBean requestBean) {

		return (GeneralWsResponseBean) pageSettingService.updatePageSetting(requestBean);
	}

    @ApiOperation(value = "Delete page setting / Effectively removed it from db", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Delete"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/deletePageSetting", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean deletePageSetting(HttpServletRequest request, HttpServletResponse response,
			@RequestBody DeleteEntityReqBean requestBean) {

		return (GeneralWsResponseBean) pageSettingService.deletePageSetting(requestBean);
	}
}
