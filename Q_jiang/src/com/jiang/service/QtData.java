package com.jiang.service;

import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * ����������
 * @author Q
 * @created 2016��8��23�� ����10:29:34
 * @since
 */
public interface QtData extends Serializable {
	
	/**
	 * ����������/�޸�������
	 * @author Q
	 * @created 2016��8��23�� ����10:30:13
	 * @since 
	 * @param id
	 * @param qtName
	 * @param phoneNo
	 * @param category
	 * @param opinion
	 * @param reason
	 * @param greetings
	 * @return
	 * @throws SQLException
	 * @throws QException
	 */
	public OutResults addInviter(int id, String qtName, String phoneNo, String category, String opinion, String reason, String greetings) throws SQLException, QException;
	
	/**
	 * ��������ѯ������Ϣ
	 * @author Q
	 * @created 2016��8��23�� ����10:31:27
	 * @since 
	 * @return
	 * @throws SQLException
	 * @throws QException
	 */
	public OutResults queryInviter() throws SQLException;
	
	/**
	 * ��������ѯ������Ϣ
	 * @author Q
	 * @created 2016��8��23�� ����10:32:25
	 * @since 
	 * @param qtName
	 * @param phoneNo
	 * @return
	 */
	public OutResults queryOneInfo(String qtName, String phoneNo) throws SQLException;
	
	/**
	 * ��������ѯף����
	 * @author Q
	 * @created 2016��8��23�� ����10:32:31
	 * @since 
	 * @return
	 */
	public OutResults queryGreetings() throws SQLException;
	
	
	

}
