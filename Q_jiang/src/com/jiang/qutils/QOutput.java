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
 * �������Զ����쳣�����ߣ������쳣��Ϣ�������
 * @author Q
 * @created 2016��4��29�� ����9:22:52
 * @since
 */

public class QOutput extends HttpServlet {
	
	private static final long serialVersionUID = 268973572484397412L;
	
	private static final List<JSONObject> listEmpty = new ArrayList<JSONObject>();

	/*
	 * �쳣������
	 */
	public void outPut(String no, String msg, List<JSONObject> list, HttpServletResponse response) throws IOException{
		this.writerOut(no, msg, list, response);
	}
	
	public void outPut(List<JSONObject> list, HttpServletResponse response) throws IOException{
		this.writerOut("0", "���óɹ�", list, response);
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
