package com.jiang.bean;

import java.io.Serializable;

public class Presentations implements Serializable {

	private static final long serialVersionUID = 5331153962820716956L;
	
	private String id;
	private String prName;
	private String prContent;
	private String isShow;
	private String reserve;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public String getPrContent() {
		return prContent;
	}

	public void setPrContent(String prContent) {
		this.prContent = prContent;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
