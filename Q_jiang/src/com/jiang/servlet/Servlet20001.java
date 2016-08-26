package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.qutils.QOutput;
import com.jiang.service.impl.QtDataImpl;

/**
 * 描述：查询所有信息
 * @author Q
 * @created 2016年8月23日 上午10:39:14
 * @since
 */

public class Servlet20001 extends QOutput {
	
	private static final long serialVersionUID = -1803879837342807036L;
	// 创建业务层
	QtDataImpl qtDataImpl = new QtDataImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			this.outPut(qtDataImpl.queryInviter(), response);
		} catch (SQLException e) {
			this.outPut("-222", "系统内部错误！！！", response);
			e.printStackTrace();
		}
	}
}
