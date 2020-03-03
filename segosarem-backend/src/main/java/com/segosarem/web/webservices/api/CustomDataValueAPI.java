package com.segosarem.web.webservices.api;

import java.util.List;
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
import com.segosarem.web.webservices.db.service.CustomDataValueService;

//Beans
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;
import com.segosarem.web.webservices.bean.customdatavalue.AddValueWrapperBean;
import com.segosarem.web.webservices.bean.customdatavalue.CustomDataValueBean;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Custom Data Value API", description="API Operations for custom data value logic")
public class CustomDataValueAPI {

	private final Logger logger = Logger.getLogger(this.getClass());
	private ResourceBundle labels = ResourceBundle.getBundle("messages");
	//protected final String partner = "FAVE";

	// Services
	@Autowired
	CustomDataValueService customDataValueService;
	// Services

	//Outlets
    @ApiOperation(value = "Get a list of custom data value", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getCustomDataValueList")
	public GeneralWsResponseBean getCustomDataValueList(HttpServletRequest request, HttpServletResponse response) {
		
		return (GeneralWsResponseBean) customDataValueService.getAllCustomDataValue();
	}

    @ApiOperation(value = "Get custom data value by id", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Get the details"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getCustomDataValueById", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean getCustomDataValueById(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CustomDataValueBean requestBean) {

		return (GeneralWsResponseBean) customDataValueService.getCustomDataValueById(requestBean.getCdValueId());
	}

	//Supposed to be for secure access only
    @ApiOperation(value = "Add custom data value", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Added"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/addCustomDataValue", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean addCustomDataValue(HttpServletRequest request, HttpServletResponse response,
			@RequestBody AddValueWrapperBean requestBean) {

		return (GeneralWsResponseBean) customDataValueService.addCustomDataValue(requestBean);
	}

    @ApiOperation(value = "Update custom data value / Also can be used to update status to either active, deactive, or deleted", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Updated"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/updateCustomDataValue", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean updateCustomDataValue(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CustomDataValueBean requestBean) {

		return (GeneralWsResponseBean) customDataValueService.updateCustomDataValue(requestBean);
	}

    @ApiOperation(value = "Delete custom data value / Effectively removed it from db", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Delete"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/deleteCustomDataValue", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean deleteCustomDataValue(HttpServletRequest request, HttpServletResponse response,
			@RequestBody DeleteEntityReqBean requestBean) {

		return (GeneralWsResponseBean) customDataValueService.deleteCustomDataValue(requestBean);
	}
}
