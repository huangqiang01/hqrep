package com.jiang.qutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.jiang.bean.TestBean;

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
	
	TestBean test = new TestBean();
	
	private static final List<JSONObject> listEmpty = new ArrayList<JSONObject>();
	
	/*
	 * �쳣������
	 */
	public void outPut(String no, String msg, List<JSONObject> list) throws IOException{
		this.writerOut(no, msg, list);
	}
	
	public void outPut(List<JSONObject> list) throws IOException{
		this.writerOut("0", "���óɹ�", list);
	}
	
	public void outPut(String no, String msg) throws IOException{
		this.writerOut(no, msg, listEmpty);
	}
	
	public void writerOut(String no, String msg, List<JSONObject> listOut) throws IOException{
		JSONObject jsonObj = JSONObject.fromObject("{}");
		HttpServletResponse response = test.getResponse();
		PrintWriter pw = response.getWriter();
		jsonObj.put("error_no", no);
		jsonObj.put("error_info", msg);
		jsonObj.put("results", listOut);
		pw.print(jsonObj);
		pw.flush();
		pw.close();
	}
}
