package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.jiang.qutils.QOutput;
import com.jiang.service.impl.UpdateDataImpl;

/**
 * 描述：文章其他操作
 * @author Q
 * @created 2016年7月21日 下午5:11:32
 * @since
 */

public class Servlet10300 extends QOutput {

	private static final long serialVersionUID = -1165523613350622006L;
	// 创建业务层
	UpdateDataImpl updateDataImpl = new UpdateDataImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		try {	
			this.outPut(updateDataImpl.updateZan(id), response);
		} catch (SQLException e) {
			this.outPut("-222", "系统内部错误！！！", response);
			e.printStackTrace();
		}
	}
}
