package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.jiang.qutils.QOutput;
import com.jiang.service.impl.ManagerDataImpl;
import com.jiang.service.impl.UpdateDataImpl;

/**
 * ����������Ա��¼
 * @author Q
 * @created 2016��8��22�� ����11:26:21
 * @since
 */

public class Servlet11000 extends QOutput {

	private static final long serialVersionUID = 4125833671008178687L;
	// ����ҵ���
	ManagerDataImpl managerDataImpl = new ManagerDataImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		String passw = request.getParameter("password");
		String check = request.getParameter("check");
		this.outPut(managerDataImpl.managerLogin(name, passw, check), response);
	}
}
