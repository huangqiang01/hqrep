package com.jiang.qutils;


import javax.servlet.http.HttpServletResponse;
/**
 * 
 * ����������response
 * @author Q
 * @created 2016��5��13�� ����9:45:21
 * @since
 */

public class KeepResponse {
	
	private static HttpServletResponse response;

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
