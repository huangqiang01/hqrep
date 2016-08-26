package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.qutils.QOutput;
import com.jiang.service.impl.QtDataImpl;

/**
 * ��������ѯ������Ϣ
 * @author Q
 * @created 2016��8��23�� ����10:39:28
 * @since
 */

public class Servlet20002 extends QOutput {
	
	private static final long serialVersionUID = -1803879837342807036L;
	// ����ҵ���
	QtDataImpl qtDataImpl = new QtDataImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String qtName = request.getParameter("qtName");
		String phoneNo = request.getParameter("phoneNo");
		try {
			// ����-�޸���Ƭ
			this.outPut(qtDataImpl.queryOneInfo(qtName, phoneNo), response);
		} catch (SQLException e) {
			this.outPut("-222", "ϵͳ�ڲ����󣡣���", response);
			e.printStackTrace();
		}
	}
}
