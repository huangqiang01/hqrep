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
 * ��������ȡ��������
 * @author Q
 * @created 2016��7��15�� ����4:06:51
 * @since
 */

public class Servlet10102 extends QOutput {

	private static final long serialVersionUID = -5357887330441178512L;
	// ����ҵ���
	GetDataImpl getDataImpl = new GetDataImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			this.outPut(getDataImpl.getStudyContent(id), response);
		} catch (SQLException e) {
			this.outPut("-222", "ϵͳ�ڲ����󣡣���", response);
			e.printStackTrace();
		}
	}
}
