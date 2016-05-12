package com.jiang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.bean.TestBean;
import com.jiang.function.Function;
import com.jiang.qutils.QException;
import com.jiang.qutils.QOutput;

/**
 * 
 * 描述：servlet的请求入口
 * @author Q
 * @created 2016年5月4日 下午1:38:34
 * @since
 */

public class ReceiveServlet extends QOutput {

	private static final long serialVersionUID = 778544136834654147L;
	
	
	TestBean test = new TestBean();
	
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
		// 
		test.setResponse(response);
		
		int funNo = Integer.parseInt(request.getParameter("funNo"));
		try {
			switch(funNo){
				case 1000:
					func.func1000(request);
					break;
				case 2000:
					
					break;
				default:
					this.outPut("-999", "");
			}
		} catch (QException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
