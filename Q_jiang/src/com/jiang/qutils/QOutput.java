package com.jiang.qutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * 
 * 描述：自定义异常处理工具，并对异常信息进行输出
 * @author Q
 * @created 2016年4月29日 上午9:22:52
 * @since
 */

public class QOutput extends HttpServlet {
	
	private static final long serialVersionUID = 268973572484397412L;
	
	private static final List<JSONObject> listEmpty = new ArrayList<JSONObject>();

	/*
	 * 异常处理工具
	 */
	public void outPut(String no, String msg, List<JSONObject> list, HttpServletResponse response) throws IOException{
		this.writerOut(no, msg, list, response);
	}
	
	public void outPut(List<JSONObject> list, HttpServletResponse response) throws IOException{
		this.writerOut("0", "调用成功", list, response);
	}
	
	public void outPut(String no, String msg, HttpServletResponse response) throws IOException{
		this.writerOut(no, msg, listEmpty, response);
	}
	
	public void writerOut(String no, String msg, List<JSONObject> listOut, HttpServletResponse response) throws IOException{
		JSONObject jsonObj = JSONObject.fromObject("{}");
		PrintWriter pw = response.getWriter();
		jsonObj.put("error_no", no);
		jsonObj.put("error_info", msg);
		jsonObj.put("results", listOut);
		pw.print(jsonObj);
		pw.flush();
		pw.close();
	}
}
