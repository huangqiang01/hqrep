package com.jiang.bean;

import java.io.Serializable;

/**
 * 
 * 描述：建议-留言
 * @author Q
 * @created 2016年7月1日 下午4:38:48
 * @since
 */
public class Evaluation implements Serializable {

	private static final long serialVersionUID = -8243631865807908594L;
	
	private String id;
	private String etime;
	private String edate;
	private String evalContent;
	private String reserve;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getEvalContent() {
		return evalContent;
	}
	public void setEvalContent(String evalContent) {
		this.evalContent = evalContent;
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
