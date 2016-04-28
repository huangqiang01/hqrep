package com.myapp.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.myapp.service.impl.GetDataImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//创建业务层
	GetDataImpl getDataImpl = new GetDataImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String funNo = request.getParameter("funNo");
		if(funNo.equals("1000")){
			userLogin(request, response);
		}else{
			error(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#userLogin(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		JSONObject jsonObj = JSONObject.fromObject("{}");
		Map<String, String> map = null;
		if(username == ""||password == ""){
			map = new HashMap<String, String>();
			map.put("errorInfo", "用户名或密码不能为空");
		}else{
			map = getDataImpl.getUserinfo(username,password);
		}
		jsonObj.put("results", map);
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().print(jsonObj);  
        response.getWriter().flush();  
        response.getWriter().close();  
	}
	
	/**
	 * @see HttpServlet#error(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("无此功能号");
	}

}
