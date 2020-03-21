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
import com.segosarem.web.webservices.db.service.CustomDataService;

//Beans
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.customdata.CustomDataBean;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Custom Data API", description = "API Operations for custom data logic")
public class CustomDataAPI {

	private final Logger logger = Logger.getLogger(this.getClass());
	private ResourceBundle labels = ResourceBundle.getBundle("messages");
	// protected final String partner = "FAVE";

	// Services
	@Autowired
	CustomDataService customDataService;
	// Services

	// Custom Data List
	@ApiOperation(value = "Get list of custom data", response = GeneralWsResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getCustomDataList")
	public GeneralWsResponseBean getCustomDataList(HttpServletRequest request, HttpServletResponse response) {

		return (GeneralWsResponseBean) customDataService.getAllCustomData();
	}

	// get custom data list by custom data group id
	@ApiOperation(value = "Get list of custom data by custom data group id", response = GeneralWsResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getCustomDataListByCdGroupId", consumes = {
			"application/json" })
	public GeneralWsResponseBean getCustomDataListByPsId(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CustomDataBean requestBean) {

		return (GeneralWsResponseBean) customDataService.getCustomDataListByCdGroupId(requestBean.getCdGroupId());
	}

	// get custom data list by custom data group id

	// get custom data by id
	@ApiOperation(value = "Get custom data by id", response = GeneralWsResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Get the details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getCustomDataById", consumes = {
			"application/json" }, produces = { "application/json" })
	public GeneralWsResponseBean getCustomDataById(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CustomDataBean requestBean) {

		return (GeneralWsResponseBean) customDataService.getCustomDataById(requestBean.getCdId());
	}

	@ApiOperation(value = "Get custom data by key", response = GeneralWsResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Get the details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getCustomDataByKey", consumes = {
			"application/json" }, produces = { "application/json" })
	public GeneralWsResponseBean getCustomDataByKey(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CustomDataBean requestBean) {

		return (GeneralWsResponseBean) customDataService.getCustomDataByKey(requestBean.getCdKey());
	}

	// Supposed to be for secure access only
	@ApiOperation(value = "Add new custom data", response = GeneralWsResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Added"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/addCustomData", consumes = {
			"application/json" }, produces = { "application/json" })
	public GeneralWsResponseBean addCustomData(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CustomDataBean requestBean) {

		return (GeneralWsResponseBean) customDataService.addCustomData(requestBean);
	}

	@ApiOperation(value = "Update custom data", response = GeneralWsResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/updateCustomData", consumes = {
			"application/json" }, produces = { "application/json" })
	public GeneralWsResponseBean updateCustomData(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CustomDataBean requestBean) {

		return (GeneralWsResponseBean) customDataService.updateCustomData(requestBean);
	}

	@ApiOperation(value = "Delete custom data / Effectively removed it from db", response = GeneralWsResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Delete"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/deleteCustomData", consumes = {
			"application/json" }, produces = { "application/json" })
	public GeneralWsResponseBean deleteCustomData(HttpServletRequest request, HttpServletResponse response,
			@RequestBody DeleteEntityReqBean requestBean) {

		return (GeneralWsResponseBean) customDataService.deleteCustomData(requestBean);
	}
}
