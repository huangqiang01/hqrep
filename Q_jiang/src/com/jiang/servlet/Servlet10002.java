package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.jiang.input.filter.GetIP;
import com.jiang.qutils.QException;
import com.jiang.qutils.QOutput;
import com.jiang.service.impl.AddDataImpl;

/**
 * 
 * �������ύ����-����
 * @author Q
 * @created 2016��7��12�� ����4:18:34
 * @since
 */

public class Servlet10002 extends QOutput {

	private static final long serialVersionUID = 778544136834654147L;
	
	// ����ҵ���
	AddDataImpl addDataImpl = new AddDataImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// ip
			GetIP getIp = new GetIP();
			String ip = getIp.getIpAddr(request);
			String time = request.getParameter("time");
			String date = request.getParameter("date");
			String text = request.getParameter("text");
			String mark = request.getParameter("subMark");
			mark = mark == null ? "0" : mark;
			if (time == null || time.equals("")){
				throw new QException("-1", "���۵�ʱ�䲻��Ϊ��");
			}
			if (date == null || date.equals("")){
				throw new QException("-2", "���۵����ڲ���Ϊ��");
			}
			if (text == null || text.equals("")){
				throw new QException("-3", "���۵����ݲ���Ϊ��");
			}
			
			this.outPut(addDataImpl.submitLeave(time, date, text, mark, ip), response);
		} catch (SQLException e) {
			this.outPut("-222", "ϵͳ�ڲ����󣡣���", response);
			e.printStackTrace();
		} catch (QException e) {
			this.outPut(e.getErrorNo(), e.getErrorInfo(), response);
			e.printStackTrace();
		}
	}
}
