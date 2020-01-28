package com.paparadaminteractive.artic.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ResponseWrapper<T> implements Serializable {

	public static final String SUCCESS = "1";
	public static final String ERROR = "0";

	public static final String PAGE_NOT_FOUND = "404";

	String responseCode;
	String responseMsg;
	long responseTime;
	List<ErrorBean> errorList;
	T responseObject;

	public ResponseWrapper() {
		this.responseTime = Calendar.getInstance().getTimeInMillis();
		this.responseCode = ResponseWrapper.SUCCESS;
		this.responseMsg = "";
	}

	public ResponseWrapper(String responseCode, String responseMsg) {
		this.responseCode = responseCode;
	}

	public ResponseWrapper(T responseObject) {
		this();
		this.responseObject = responseObject;
	}

	public ResponseWrapper(String responseCode, String responseMsg, T responseObject) {
		this(responseCode, responseMsg);
		this.responseObject = responseObject;
	}

	public ResponseWrapper(String responseCode, String responseMsg, T responseObject, List<ErrorBean> errorList) {
		this(responseCode, responseMsg, responseObject);
		if (errorList != null) {
			this.responseCode = ResponseWrapper.ERROR;
		}
		this.errorList = errorList;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public T getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(T responseObject) {
		this.responseObject = responseObject;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	@JsonProperty("error")
	public List<ErrorBean> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<ErrorBean> errorList) {
		this.responseCode = ResponseWrapper.ERROR;
		this.errorList = errorList;
	}

	public ResponseWrapper<T> addError(String code, String key, String value) {
		this.responseCode = ResponseWrapper.ERROR;
		if (errorList == null) {
			errorList = new ArrayList<ErrorBean>();
		}
		errorList.add(new ErrorBean(code, key, value));
		return this;
	}

	public ResponseWrapper<T> addErrors(String code, Map<String, List<String>> errorMap) {
		errorMap.forEach((key, classes) -> classes.forEach(clazz -> addError(code, key, clazz)));
		return this;
	}
	
}
