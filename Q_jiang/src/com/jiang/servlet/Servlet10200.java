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
 * ��������ѯ��Ƭ
 * @author Q
 * @created 2016��8��16�� ����9:14:16
 * @since
 */

public class Servlet10200 extends QOutput {

	private static final long serialVersionUID = -4409987727335267218L;
	// ����ҵ���
	GetDataImpl getDataImpl = new GetDataImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ǰ�ڼ�ҳ
		String currentPage = request.getParameter("currentPage");
		try {
			this.outPut(getDataImpl.getPhoto(currentPage), response);
		} catch (SQLException e) {
			this.outPut("-222", "ϵͳ�ڲ����󣡣���", response);
			e.printStackTrace();
		}
	}
}
