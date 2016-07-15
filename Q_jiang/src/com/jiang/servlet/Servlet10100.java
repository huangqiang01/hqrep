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
 * 描述：获取文章title列表
 * @author Q
 * @created 2016年7月12日 下午4:09:26
 * @since
 */

public class Servlet10100 extends QOutput {

	private static final long serialVersionUID = 778544136834654147L;
	
	// 创建业务层
	GetDataImpl getDataImpl = new GetDataImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.outPut(getDataImpl.getStudyTitle(), response);
		} catch (SQLException e) {
			this.outPut("-222", "系统内部错误！！！", response);
			e.printStackTrace();
		}
	}
}
