package com.jiang.bean;

import java.io.Serializable;

public class StudyContent implements Serializable {
	
	private String textTital;
	private String releaseDate;
	private String zan;
	private String content;
	private String referencePoint;
	public String getTextTital() {
		return textTital;
	}
	public void setTextTital(String textTital) {
		this.textTital = textTital;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getZan() {
		return zan;
	}
	public void setZan(String zan) {
		this.zan = zan;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReferencePoint() {
		return referencePoint;
	}
	public void setReferencePoint(String referencePoint) {
		this.referencePoint = referencePoint;
	}
}
