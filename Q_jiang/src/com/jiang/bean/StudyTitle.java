package com.jiang.bean;

import java.io.Serializable;

public class StudyTitle implements Serializable {
	
	
	private String id;
	private String classId;
	private String seriesId;
	private String contentListNo;
	private String textTital;
	private String sAbstract;
	private String releaseDate;
	private String zan;
	private String notesState;
	private String reserve;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}
	public String getContentListNo() {
		return contentListNo;
	}
	public void setContentListNo(String contentListNo) {
		this.contentListNo = contentListNo;
	}
	public String getTextTital() {
		return textTital;
	}
	public void setTextTital(String textTital) {
		this.textTital = textTital;
	}
	public String getsAbstract() {
		return sAbstract;
	}
	public void setsAbstract(String sAbstract) {
		this.sAbstract = sAbstract;
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
	public String getNotesState() {
		return notesState;
	}
	public void setNotesState(String notesState) {
		this.notesState = notesState;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	
}
