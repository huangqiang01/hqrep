package com.myapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.input.function.Function;
import com.myapp.qutils.QException;
import com.myapp.qutils.QOutput;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ReceiveServlet")
public class ReceiveServlet extends QOutput {
	
	private static final long serialVersionUID = -3006482419694856985L;
	
	// ¹¦ÄÜ²ã
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
		int funNo = Integer.parseInt(request.getParameter("funNo"));
		try {
			switch(funNo){
				case 1000:
					func.func1000(request, response);
					break;
				case 2000:
					
					break;
				default:
					this.outPut("-999", "", response);
			}
		} catch (QException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
