package com.jiang.function;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.input.check.CheckInput;
import com.jiang.qutils.QException;
import com.jiang.qutils.QOutput;
import com.jiang.service.impl.GetDataImpl;

public class Function extends QOutput {
	
	// ����ҵ���
	GetDataImpl getDataImpl = new GetDataImpl();
	
	/**
	 * @throws QException 
	 * @throws SQLException 
	 * @see HttpServlet#userLogin(HttpServletRequest request, HttpServletResponse response)
	 */
	public void func1000(HttpServletRequest request) throws ServletException, IOException, QException, SQLException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// �������Ƿ�Ϸ�
		if (username.equals("")){
			throw new QException("-1", "�û�������Ϊ��");
		}
		if (password.equals("")){
			throw new QException("-2", "���벻��Ϊ��");
		}
//		getDataImpl.addInfo();
//		getDataImpl.updateInfo();
		getDataImpl.deleteInfo();
		
//		this.outPut(getDataImpl.getUserinfo(username, password));
	}
	
	/**
	 * 
	 * ��������ȡ��վ��ؽ���
	 * @author Q
	 * @created 2016��7��1�� ����4:19:44
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void func1001() throws SQLException, IOException{
		getDataImpl.getPresent();
		
	}
	
	/**
	 * 
	 * �������ύ����-����
	 * @author Q
	 * @created 2016��7��1�� ����3:47:02
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 * @throws QException 
	 */
	public void func1002(HttpServletRequest request) throws SQLException, IOException, QException{
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String text = request.getParameter("text");
		if (time.equals("")){
			throw new QException("-1", "���۵�ʱ�䲻��Ϊ��");
		}
		if (date.equals("")){
			throw new QException("-2", "���۵����ڲ���Ϊ��");
		}
		if (text.equals("")){
			throw new QException("-3", "���۵����ݲ���Ϊ��");
		}
		getDataImpl.submitLeave(time, date, text);
	}
	
	/**
	 * 
	 * ��������ȡ��������
	 * @author Q
	 * @created 2016��7��1�� ����4:20:13
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void func1003(HttpServletRequest request) throws SQLException, IOException{
		String startPage = request.getParameter("startPage");
		if (startPage.equals("")){
			startPage = "1";
		}
		getDataImpl.getNewMessage(startPage);
	}
}
