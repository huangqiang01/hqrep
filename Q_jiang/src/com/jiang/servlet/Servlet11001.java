package com.jiang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.jiang.qutils.QException;
import com.jiang.qutils.QOutput;
import com.jiang.service.impl.ManagerDataImpl;
import com.jiang.service.impl.UpdateDataImpl;

/**
 * 描述：增加，修改照片信息
 * @author Q
 * @created 2016年8月22日 下午1:59:01
 * @since
 */

public class Servlet11001 extends QOutput {
	
	private static final long serialVersionUID = -1803879837342807036L;
	// 创建业务层
	ManagerDataImpl managerDataImpl = new ManagerDataImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int classId = Integer.parseInt(request.getParameter("classId"));
		String imgName = request.getParameter("imgName");
		String shotTypes = request.getParameter("shotTypes");
		String imgInfo = request.getParameter("imgInfo");
		String imgUrl = request.getParameter("imgUrl");
		String imgWidth = request.getParameter("imgWidth");
		String imgHeight = request.getParameter("imgHeight");
		String imgDate = request.getParameter("imgDate");
		String imgTime = request.getParameter("imgTime");
		String introduce = request.getParameter("introduce");
		String isShow = request.getParameter("isShow");
		try {
			// 增加-修改照片
			this.outPut(managerDataImpl.addOrUpdatePhoto(id, classId, imgName, shotTypes, imgInfo, imgUrl, imgWidth, imgHeight, imgDate, imgTime, introduce, isShow), response);
		} catch (QException e) {
			this.outPut(e.getErrorNo(), e.getErrorInfo(), response);
			e.printStackTrace();
		} catch (SQLException e) {
			this.outPut("-222", "系统内部错误！！！", response);
			e.printStackTrace();
		}
	}
}
