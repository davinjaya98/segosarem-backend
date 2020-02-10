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
import com.segosarem.web.webservices.db.service.QuotationService;

//Beans
import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

import com.segosarem.web.webservices.bean.quotation.QuotationBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Quotation API", description="API regarding quotation logic")
public class QuotationAPI {
    private final Logger logger = Logger.getLogger(this.getClass());
    private ResourceBundle labels = ResourceBundle.getBundle("messages");

    //services
    @Autowired
    QuotationService quotationService;
    //services

    @ApiOperation(value = "Get list of quotations", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getQuotationList")
    public GeneralWsResponseBean getQuotationList(HttpServletRequest request, HttpServletResponse response) {
		return (GeneralWsResponseBean) quotationService.getAllQuotation();
	}

    @ApiOperation(value = "Get quotation by id", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Get the details"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getQuotationById", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean getQuotationById(HttpServletRequest request, HttpServletResponse response,
			@RequestBody QuotationBean requestBean) {

		return (GeneralWsResponseBean) quotationService.getQuotationById(requestBean.getSettingId());
	}

    @ApiOperation(value = "Get quotation by key", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Get the details"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/getQuotationByKey", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean getQuotation(HttpServletRequest request, HttpServletResponse response,
			@RequestBody QuotationBean requestBean) {

		return (GeneralWsResponseBean) quotationService.getQuotationByKey(requestBean.getPageKey());
	}

    @ApiOperation(value = "Add new quotation", response = GeneralWsResponseBean.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Added"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/addQuotation", consumes = { "application/json" }, produces = {
			"application/json" })
	public GeneralWsResponseBean addQuotation(HttpServletRequest request, HttpServletResponse response,
			@RequestBody QuotationBean requestBean) {

		return (GeneralWsResponseBean) quotationService.addQuotation(requestBean);
	}
}