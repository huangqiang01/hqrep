package com.jiang.bean;

import java.io.Serializable;

public class Photo implements Serializable {
	
	private static final long serialVersionUID = -4930653849824193458L;
	private String imgName;
	private String shotTypes;
	private String imgInfo;
	private String imgUrl;
	private String imgWidth;
	private String imgHeight;
	private String imgDate;
	private String imgTime;
	private String introduce;
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getShotTypes() {
		return shotTypes;
	}
	public void setShotTypes(String shotTypes) {
		this.shotTypes = shotTypes;
	}
	public String getImgInfo() {
		return imgInfo;
	}
	public void setImgInfo(String imgInfo) {
		this.imgInfo = imgInfo;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(String imgWidth) {
		this.imgWidth = imgWidth;
	}
	public String getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(String imgHeight) {
		this.imgHeight = imgHeight;
	}
	public String getImgDate() {
		return imgDate;
	}
	public void setImgDate(String imgDate) {
		this.imgDate = imgDate;
	}
	public String getImgTime() {
		return imgTime;
	}
	public void setImgTime(String imgTime) {
		this.imgTime = imgTime;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
