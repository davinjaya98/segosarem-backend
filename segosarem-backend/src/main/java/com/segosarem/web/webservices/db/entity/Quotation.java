package com.paparadaminteractive.artic.webservices.db.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quotation", catalog = "segosarem_db")
public class Quotation extends GeneralCreateModify implements Serializable {

	private int quotationId;
	private String senderName;
	private String senderEmail;
	private String content;

	public Quotation() {
	}

	/**
	 * @return the quotationId
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "quotation_id", unique = true, nullable = false)
	public int getQuotationId() {
		return quotationId;
	}
	/**
	 * @param quotationId the quotationId to set
	 */
	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
    }

	/**
	 * @return the senderName
	 */
	@Column(name = "sender_name")
	public String getSenderName() {
		return senderName;
	}
	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return the senderEmail
	 */
	@Column(name = "sender_email")
	public String getSenderEmail() {
		return senderEmail;
	}
	/**
	 * @param senderEmail the senderEmail to set
	 */
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	/**
	 * @return the content
	 */
	@Column(name = "content")
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
