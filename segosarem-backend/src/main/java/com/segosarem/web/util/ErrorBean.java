package com.segosarem.web.util;

public class ErrorBean {

	String code;
	String key;
	String value;

	public ErrorBean(String code, String key, String value) {
		super();
		this.code = code;
		this.key = key;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
