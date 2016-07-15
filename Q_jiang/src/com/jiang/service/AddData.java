package com.jiang.service;

import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * 
 * �����������ݿ��������
 * @author Q
 * @created 2016��7��15�� ����12:53:19
 * @since
 */
public interface AddData extends Serializable {
	
	/**
	 * 
	 * �������ύ����-����
	 * @author Q
	 * @created 2016��7��15�� ����12:55:36
	 * @since 
	 * @param time �ύ��ʱ��
	 * @param date �ύ������
	 * @param text �ύ������
	 * @param mark 0-���飬1-����
	 * @param ip �ύ������
	 * @return
	 * @throws SQLException
	 * @throws QException 
	 */
	public OutResults submitLeave(String time, String date, String text, String mark, String ip) throws SQLException, QException;

}
