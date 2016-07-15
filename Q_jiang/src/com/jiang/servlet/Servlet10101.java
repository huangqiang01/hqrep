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
 * ��������ȡ���¼���б�
 * @author Q
 * @created 2016��7��15�� ����3:32:02
 * @since
 */

public class Servlet10101 extends QOutput {

	private static final long serialVersionUID = 9140444362286299538L;
	
	// ����ҵ���
	GetDataImpl getDataImpl = new GetDataImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.outPut(getDataImpl.getStudyAbsList(), response);
		} catch (SQLException e) {
			this.outPut("-222", "ϵͳ�ڲ����󣡣���", response);
			e.printStackTrace();
		}
	}
}
