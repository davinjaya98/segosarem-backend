package com.segosarem.web.webservices.bean.quotation;

public class QuotationBean {
    
    //For Response
    private Integer quotationId;
	private String custName;
	private String custEmail;
    private String custPhoneNumber;

    public QuotationBean(){}

    public QuotationBean(Integer quotationId, String custName, String CustEmail, String custPhoneNumber){
        this.quotationId = quotationId;
        this.custName = custName;
	    this.custEmail = custEmail;
        this.custPhoneNumber = custPhoneNumber;
    }

    public Integer getQuotationId(){
        return this.quotationId;
    }

    public void setQuotationId(Integer quotationId){
        this.quotationId = quotationId;
    }

    public String getCustName(){
        return this.custName;
    }

    public void setCustName(String custName){
        this.custName = custName;
    }

    public String getCustEmail(){
        return this.custEmail;
    }

    public void setCustEmail(String custEmail){
        this.custEmail = custEmail;
    }

    public String getCustPhoneNumber(){
        return this.custPhoneNumber;
    }

    public void setCustPhoneNumber(String custPhoneNumber){
        this.custPhoneNumber = custPhoneNumber;
    }
}