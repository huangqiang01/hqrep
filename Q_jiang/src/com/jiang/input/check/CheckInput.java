package com.jiang.input.check;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.jiang.qutils.QException;

public class CheckInput {
	
	private static final long serialVersionUID = -1744006652870132392L;
	
	public void input1000(String name, String password) throws IOException, QException{
		if (name.equals("")){
			throw new QException("-1", "用户名不能为空");
		}
		if (password.equals("")){
			throw new QException("-2", "密码不能为空");
		}
	}
}
