package com.jiang.bean;

import java.io.Serializable;

/**
 * 
 * 描述：获取首页banner
 * @author Q
 * @created 2016年7月4日 下午2:28:23
 * @since
 */
public class BannerImg implements Serializable {
	
	private static final long serialVersionUID = -8028764877053352654L;
	
	private String id;
	private String addr;
	private String iName;
	private String iExplain;
	private String isShow;
	private String showOrder;
	private String reserve;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getiExplain() {
		return iExplain;
	}
	public void setiExplain(String iExplain) {
		this.iExplain = iExplain;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public String getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(String showOrder) {
		this.showOrder = showOrder;
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
