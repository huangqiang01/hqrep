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
	
	public void func1001() throws SQLException, IOException{
		getDataImpl.getPresent();
		
	}
}
