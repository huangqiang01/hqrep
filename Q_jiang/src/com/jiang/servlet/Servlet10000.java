package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jiang.qutils.QOutput;
import com.jiang.service.impl.GetDataImpl;

/**
 * 
 * 描述：查询banner图片
 * @author Q
 * @created 2016年5月4日 下午1:38:34
 * @since
 */

public class Servlet10000 extends QOutput {

	private static final long serialVersionUID = 778544136834654147L;
	
	// 创建业务层
	GetDataImpl getDataImpl = new GetDataImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.outPut(getDataImpl.getBannerImg(), response);
		} catch (SQLException e) {
			this.outPut("-222", "系统内部错误！！！", response);
			e.printStackTrace();
		}
	}
}
