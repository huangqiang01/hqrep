package com.jiang.qutils;


import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 描述：保存response
 * @author Q
 * @created 2016年5月13日 上午9:45:21
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
