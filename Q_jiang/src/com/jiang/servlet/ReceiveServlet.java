package com.jiang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.function.Function;
import com.jiang.qutils.QOutput;

/**
 * 
 * 描述：servlet的请求入口
 * @author Q
 * @created 2016年5月4日 下午1:38:34
 * @since
 */

public class ReceiveServlet extends HttpServlet {

	private static final long serialVersionUID = 778544136834654147L;
	
	// 输出错误，并保存response
	QOutput qput = new QOutput();
	
	// 功能层
	Function func = new Function();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 保存 response
		qput.setResponse(response);
		
		int funNo = Integer.parseInt(request.getParameter("funNo"));
		try {
			switch(funNo){
				case 1000:
					func.func1000(request);
					break;
				case 1001: 
					func.func1001();
					break;
				case 2000:
					
					break;
				default:
					qput.outPut("-999", "无此功能号");
			}
		} catch (Exception e) {
			qput.outPut("-222", "系统调用失败");
			e.printStackTrace();
		}
	}
}
