package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.jiang.qutils.QOutput;
import com.jiang.service.impl.UpdateDataImpl;

/**
 * ������������������
 * @author Q
 * @created 2016��7��21�� ����5:11:32
 * @since
 */

public class Servlet10300 extends QOutput {

	private static final long serialVersionUID = -1165523613350622006L;
	// ����ҵ���
	UpdateDataImpl updateDataImpl = new UpdateDataImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		try {	
			this.outPut(updateDataImpl.updateZan(id), response);
		} catch (SQLException e) {
			this.outPut("-222", "ϵͳ�ڲ����󣡣���", response);
			e.printStackTrace();
		}
	}
}
