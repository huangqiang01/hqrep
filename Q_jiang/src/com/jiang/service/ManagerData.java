package com.jiang.service;

import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * 描述：后端管理登录
 * @author Q
 * @created 2016年8月22日 上午10:59:08
 * @since
 */
public interface ManagerData extends Serializable {
	
	/**
	 * 描述：管理登录
	 * @author Q
	 * @created 2016年8月22日 上午11:02:05
	 * @since 
	 * @param name
	 * @param passw
	 * @param check
	 * @return
	 */
	public OutResults managerLogin(String name, String passw, String check);
	
	/**
	 * 描述：增加照片，修改照片信息
	 * @author Q
	 * @created 2016年8月22日 下午1:45:42
	 * @since 
	 * @param id
	 * @param classId
	 * @param imgName
	 * @param shotTypes
	 * @param imgInfo
	 * @param imgUrl
	 * @param imgWidth
	 * @param imgHeight
	 * @param imgDate
	 * @param imgTime
	 * @param introduce
	 * @param isShow
	 * @return
	 */
	public OutResults addOrUpdatePhoto(int id, int classId, String imgName, String shotTypes, String imgInfo, String imgUrl, String imgWidth, String imgHeight, String imgDate, String imgTime, String introduce, String isShow) throws QException, SQLException;
	
}
