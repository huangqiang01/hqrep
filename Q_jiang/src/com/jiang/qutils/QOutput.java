package com.jiang.qutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * 描述：自定义异常处理工具，并对异常信息进行输出
 * @author Q
 * @created 2016年4月29日 上午9:22:52
 * @since
 */

public class QOutput extends KeepResponse {
	
	OutResults or = new OutResults();
	
	ObjectMapper om = new ObjectMapper();
	
	/*
	 * 异常处理工具
	 */
	public void outPut(String no, String msg, List list) throws IOException{
		PrintWriter pw = this.getResponse().getWriter();
		or.setError_no(no);
		or.setError_info(msg);
		or.setResults(list);
		om.writeValue(pw, or);
		pw.flush();
		pw.close();
	}
	
	public void outPut(List list) throws IOException{
		PrintWriter pw = this.getResponse().getWriter();
		or.setResults(list);
		om.writeValue(pw, or);
		pw.flush();
		pw.close();
	}
	
	public void outPut(String no, String msg) throws IOException{
		PrintWriter pw = this.getResponse().getWriter();
		or.setError_no(no);
		or.setError_info(msg);
		om.writeValue(pw, or);
		pw.flush();
		pw.close();
	}
}
