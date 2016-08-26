package com.jiang.service;

import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * ��������˹����¼
 * @author Q
 * @created 2016��8��22�� ����10:59:08
 * @since
 */
public interface ManagerData extends Serializable {
	
	/**
	 * �����������¼
	 * @author Q
	 * @created 2016��8��22�� ����11:02:05
	 * @since 
	 * @param name
	 * @param passw
	 * @param check
	 * @return
	 */
	public OutResults managerLogin(String name, String passw, String check);
	
	/**
	 * ������������Ƭ���޸���Ƭ��Ϣ
	 * @author Q
	 * @created 2016��8��22�� ����1:45:42
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
