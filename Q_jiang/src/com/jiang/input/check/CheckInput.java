package com.jiang.input.check;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.jiang.qutils.QException;

public class CheckInput {
	
	private static final long serialVersionUID = -1744006652870132392L;
	
	public void input1000(String name, String password) throws IOException, QException{
		if (name.equals("")){
			throw new QException("-1", "�û�������Ϊ��");
		}
		if (password.equals("")){
			throw new QException("-2", "���벻��Ϊ��");
		}
	}
}
