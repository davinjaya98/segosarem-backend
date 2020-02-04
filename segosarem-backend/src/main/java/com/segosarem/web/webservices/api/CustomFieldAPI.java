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
import com.segosarem.web.webservices.db.service.OutletService;

//Beans
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.outlet.ListOutletResBean;
import com.segosarem.web.webservices.bean.outlet.AddOutletReqBean;

import com.segosarem.web.webservices.bean.DeleteEntityReqBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Custom Field API", description="API Operations for custom fields logic")
public class CustomFieldAPI {

	private final Logger logger = Logger.getLogger(this.getClass());
	private ResourceBundle labels = ResourceBundle.getBundle("messages");
	//protected final String partner = "FAVE";

	// Services
	@Autowired
	OutletService outletService;
	// Services

	//Outlets
    @ApiOperation(value = "Get a list of outlets", response = ListOutletResBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getCustomFieldList")
	public ListOutletResBean getCustomFieldList(HttpServletRequest request, HttpServletResponse response) {

		return (ListOutletResBean) outletService.getOutletList();
	}

	//Supposed to be for secure access only
    @ApiOperation(value = "Add outlet", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Add"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/addCustomField", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean addCustomField(HttpServletRequest request, HttpServletResponse response,
			@RequestBody AddOutletReqBean requestBean) {

		return (GeneralWsResponseBean) outletService.save(requestBean);
	}

    @ApiOperation(value = "Delete outlet", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Delete"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/deleteCustomField", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean deleteCustomField(HttpServletRequest request, HttpServletResponse response,
			@RequestBody DeleteEntityReqBean requestBean) {

		Integer outletId = requestBean.getEntityId();

		return (GeneralWsResponseBean) outletService.deactive(outletId);
	}
}
