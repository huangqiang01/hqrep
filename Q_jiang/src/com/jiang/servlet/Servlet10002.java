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
 * 描述：提交评价-建议
 * @author Q
 * @created 2016年7月12日 下午4:18:34
 * @since
 */

public class Servlet10002 extends QOutput {

	private static final long serialVersionUID = 778544136834654147L;
	
	// 创建业务层
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
				throw new QException("-1", "评论的时间不能为空");
			}
			if (date == null || date.equals("")){
				throw new QException("-2", "评论的日期不能为空");
			}
			if (text == null || text.equals("")){
				throw new QException("-3", "评论的内容不能为空");
			}
			
			this.outPut(addDataImpl.submitLeave(time, date, text, mark, ip), response);
		} catch (SQLException e) {
			this.outPut("-222", "系统内部错误！！！", response);
			e.printStackTrace();
		} catch (QException e) {
			this.outPut(e.getErrorNo(), e.getErrorInfo(), response);
			e.printStackTrace();
		}
	}
}
