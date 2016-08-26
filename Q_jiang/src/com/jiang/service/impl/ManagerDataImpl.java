package com.jiang.service.impl;

import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;
import com.jiang.qutils.dao.ManagerDataDao;
import com.jiang.service.ManagerData;

/**
 * 
 * �����������߲���
 * @author Q
 * @created 2016��8��22�� ����11:06:06
 * @since
 */
public class ManagerDataImpl implements ManagerData {
	
	private static final long serialVersionUID = 4646791970951293941L;
	
	ManagerDataDao managerDataDao = new ManagerDataDao();
	
	/**
	 * ��¼
	 */
	@Override
	public OutResults managerLogin(String name, String passw, String check) {
		OutResults or = new OutResults();
		if (name.equals("�ֻ�Ƿ��") && passw.equals("147258") && check.equals("999999")){
			or.setError_info_no("0", "���óɹ�");
			return or;
		} else {
			or.setError_info_no("-1", "����ʧ��");
			return or;
		}
	}
	
	/**
	 * ������Ƭ���޸���Ƭ��Ϣ
	 * @throws QException 
	 * @throws SQLException 
	 */
	@Override
	public OutResults addOrUpdatePhoto(int id, int classId, String imgName,
			String shotTypes, String imgInfo, String imgUrl, String imgWidth,
			String imgHeight, String imgDate, String imgTime, String introduce,
			String isShow) throws QException, SQLException {
		if (classId == 0){
			classId = 0;
		}
		if (imgName.equals("") || imgName == null){
			throw new QException("-1", "���Ʋ���Ϊ��");
		}
		if (shotTypes.equals("") || shotTypes == null){
			shotTypes = "�ֻ�";
		}
		if (imgUrl.equals("") || imgUrl == null){
			throw new QException("-2", "ͼƬ·������Ϊ��");
		}
		if (isShow.equals("") || isShow == null){
			isShow = "0";
		}
		return managerDataDao.addOrUpdatePhoto(id, classId, imgName, shotTypes, imgInfo, imgUrl, imgWidth, imgHeight, imgDate, imgTime, introduce, isShow);
	}
}
