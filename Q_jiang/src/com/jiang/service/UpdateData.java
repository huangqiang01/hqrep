package com.jiang.service;

import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * 
 * �������޸����ݿ�������
 * @author Q
 * @created 2016��7��21�� ����5:05:25
 * @since
 */
public interface UpdateData extends Serializable {
	
	/**
	 * ���������ӵ�����
	 * @author Q
	 * @created 2016��7��21�� ����5:06:44
	 * @since 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws QException
	 */
	public OutResults updateZan(String id) throws SQLException, QException;

}
