package com.myapp.input.check;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.myapp.qutils.QException;

public class CheckInput extends HttpServlet {
	
	private static final long serialVersionUID = -1744006652870132392L;
	
	public void input1000(String name, String password, HttpServletResponse response) throws IOException, QException{
		if (name.equals("")){
			throw new QException("-1", "用户名不能为空", response);
		}
		if (password.equals("")){
			throw new QException("-2", "密码不能为空", response);
		}
	}
}
