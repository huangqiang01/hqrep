package com.jiang.function;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.bean.TestBean;
import com.jiang.input.check.CheckInput;
import com.jiang.qutils.QException;
import com.jiang.qutils.QOutput;
import com.jiang.service.impl.GetDataImpl;

public class Function extends QOutput {
	
	private static final long serialVersionUID = 1L;
	
	private List list;
	
	CheckInput checkInput = new CheckInput();
	
	// ����ҵ���
	GetDataImpl getDataImpl = new GetDataImpl();
	
	TestBean test = new TestBean();
	
	
	/**
	 * @throws QException 
	 * @see HttpServlet#userLogin(HttpServletRequest request, HttpServletResponse response)
	 */
	public void func1000(HttpServletRequest request) throws ServletException, IOException, QException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// �������Ƿ�Ϸ�
		
		System.out.println("++" + test.getResponse());
		checkInput.input1000(username, password);
		
		list = getDataImpl.getUserinfo(username, password);
		this.outPut(list);
	}
}
