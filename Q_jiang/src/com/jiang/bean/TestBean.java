package com.jiang.bean;


import javax.servlet.http.HttpServletResponse;

public class TestBean {
	
	private static HttpServletResponse response;

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
