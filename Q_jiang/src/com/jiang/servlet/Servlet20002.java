package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.qutils.QOutput;
import com.jiang.service.impl.QtDataImpl;

/**
 * 描述：查询个人信息
 * @author Q
 * @created 2016年8月23日 上午10:39:28
 * @since
 */

public class Servlet20002 extends QOutput {
	
	private static final long serialVersionUID = -1803879837342807036L;
	// 创建业务层
	QtDataImpl qtDataImpl = new QtDataImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String qtName = request.getParameter("qtName");
		String phoneNo = request.getParameter("phoneNo");
		try {
			// 增加-修改照片
			this.outPut(qtDataImpl.queryOneInfo(qtName, phoneNo), response);
		} catch (SQLException e) {
			this.outPut("-222", "系统内部错误！！！", response);
			e.printStackTrace();
		}
	}
}
