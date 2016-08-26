package com.jiang.bean;

import java.io.Serializable;

public class QtInfo implements Serializable {
	
	private static final long serialVersionUID = -2634104958008340594L;
	private String id;
	private String qtName;
	private String phoneNo;
	private String category;
	private String opinion;
	private String reason;
	private String greetings;
	private String qtDate;
	private String qtTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQtName() {
		return qtName;
	}
	public void setQtName(String qtName) {
		this.qtName = qtName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getGreetings() {
		return greetings;
	}
	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}
	public String getQtDate() {
		return qtDate;
	}
	public void setQtDate(String qtDate) {
		this.qtDate = qtDate;
	}
	public String getQtTime() {
		return qtTime;
	}
	public void setQtTime(String qtTime) {
		this.qtTime = qtTime;
	}
	
}
