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
	
	// 创建业务层
	GetDataImpl getDataImpl = new GetDataImpl();
	
	/**
	 * @throws QException 
	 * @throws SQLException 
	 * @see HttpServlet#userLogin(HttpServletRequest request, HttpServletResponse response)
	 */
	public void func1000(HttpServletRequest request) throws ServletException, IOException, QException, SQLException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 检查入参是否合法
		if (username.equals("")){
			throw new QException("-1", "用户名不能为空");
		}
		if (password.equals("")){
			throw new QException("-2", "密码不能为空");
		}
//		getDataImpl.addInfo();
//		getDataImpl.updateInfo();
		getDataImpl.deleteInfo();
		
//		this.outPut(getDataImpl.getUserinfo(username, password));
	}
	
	/**
	 * 
	 * 描述：获取网站相关介绍
	 * @author Q
	 * @created 2016年7月1日 下午4:19:44
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void func1001() throws SQLException, IOException{
		getDataImpl.getPresent();
		
	}
	
	/**
	 * 
	 * 描述：提交建议-留言
	 * @author Q
	 * @created 2016年7月1日 下午3:47:02
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
			throw new QException("-1", "评论的时间不能为空");
		}
		if (date.equals("")){
			throw new QException("-2", "评论的日期不能为空");
		}
		if (text.equals("")){
			throw new QException("-3", "评论的内容不能为空");
		}
		getDataImpl.submitLeave(time, date, text);
	}
	
	/**
	 * 
	 * 描述：获取最新留言
	 * @author Q
	 * @created 2016年7月1日 下午4:20:13
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
