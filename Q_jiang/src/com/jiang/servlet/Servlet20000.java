package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.qutils.QException;
import com.jiang.qutils.QOutput;
import com.jiang.service.impl.QtDataImpl;

/**
 * 描述：增加/修改 邀请人
 * @author Q
 * @created 2016年8月23日 上午10:38:46
 * @since
 */

public class Servlet20000 extends QOutput {
	
	private static final long serialVersionUID = -1803879837342807036L;
	// 创建业务层
	QtDataImpl qtDataImpl = new QtDataImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String qtName = request.getParameter("qtName");
		String phoneNo = request.getParameter("phoneNo");
		String category = request.getParameter("category");
		String opinion = request.getParameter("opinion");
		String reason = request.getParameter("reason");
		String greetings = request.getParameter("greetings");
		try {
			// 增加/修改 邀请人
			this.outPut(qtDataImpl.addInviter(id, qtName, phoneNo, category, opinion, reason, greetings), response);
			
		} catch (QException e) {
			this.outPut(e.getErrorNo(), e.getErrorInfo(), response);
			e.printStackTrace();
		} catch (SQLException e) {
			this.outPut("-222", "系统内部错误！！！", response);
			e.printStackTrace();
		}
	}
}
