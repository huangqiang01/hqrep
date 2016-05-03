package com.myapp.bean;

import java.io.Serializable;

public class Userinfo implements Serializable {
	
	private static final long serialVersionUID = -8945510188131077885L;
	
	private String userid;
	private String username;
	private String password;
	private String info;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
