package com.jiang.qutils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.jiang.qutils.bean.OutResults;

/**
 * 
 * �������Զ����쳣�����ߣ������쳣��Ϣ�������
 * @author Q
 * @created 2016��4��29�� ����9:22:52
 * @since
 */

public class QOutput extends HttpServlet {
	
	private static final long serialVersionUID = -3273574819375933515L;
	/*
	 * �쳣������
	 */
	public OutResults setOutBean(String no, String msg){
		OutResults or = new OutResults();
		or.setError_no(no);
		or.setError_info(msg);
		return or;
	}

	/**
	 * 
	 * �����������ѯ���
	 * @author Q
	 * @created 2016��7��12�� ����4:00:23
	 * @since 
	 * @param or
	 * @param response
	 * @throws IOException
	 */
	public void outPut(OutResults or, HttpServletResponse response) throws IOException{
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		om.writeValue(pw, or);
		pw.flush();
		pw.close();
	}
	
	/**
	 * 
	 * ��������װ����������
	 * @author Q
	 * @created 2016��7��12�� ����4:05:32
	 * @since 
	 * @param no
	 * @param msg
	 * @param response
	 * @throws IOException
	 */
	public void outPut(String no, String msg, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		om.writeValue(pw, setOutBean(no, msg));
		pw.flush();
		pw.close();
	}
}
