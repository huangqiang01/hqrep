package com.jiang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.function.Function;
import com.jiang.input.filter.GetIP;
import com.jiang.qutils.QOutput;

/**
 * 
 * ������servlet���������
 * @author Q
 * @created 2016��5��4�� ����1:38:34
 * @since
 */

public class ReceiveServlet extends HttpServlet {

	private static final long serialVersionUID = 778544136834654147L;
	
	// ������󣬲�����response
	QOutput qput = new QOutput();
	
	// ���ܲ�
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
		// ���� response
		qput.setResponse(response);
		
		int funNo = Integer.parseInt(request.getParameter("funNo"));
		try {
			switch(funNo){
				case 1000:
					// ��ѯbannerͼƬ
					func.func1000(request);
					break;
				case 1001: 
					// ��ѯ��վ��ؽ���
					func.func1001(request);
					break;
				case 1002:
					// �ύ����-����
					func.func1002(request);
					break;
				case 1003:
					// ��ȡ��������
					func.func1003(request);
					break;
				case 2000:
					
					break;
				default:
					qput.outPut("-999", "�޴˹��ܺ�");
			}
		} catch (Exception e) {
			qput.outPut("-222", "ϵͳ����ʧ��");
			e.printStackTrace();
		}
	}
}
