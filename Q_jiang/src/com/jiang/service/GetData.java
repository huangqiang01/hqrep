package com.jiang.service;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.bean.OutResults;

/**
 * 
 * ��������ȡ���ݿ�����
 * @author Q
 * @created 2016��7��15�� ����12:53:30
 * @since
 */
public interface GetData extends Serializable {
	
	/**
	 * ��������ȡ��ҳbanner
	 * @author Q
	 * @created 2016��7��4�� ����2:37:41
	 * @since 
	 * @throws SQLException
	 * @throws IOException 
	 */
	public OutResults getBannerImg() throws SQLException;
	
	/**
	 * ��������ѯ��ؽ���
	 * @author Q
	 * @created 2016��7��15�� ����12:50:23
	 * @since 
	 * @return
	 * @throws SQLException
	 * @throws IOException 
	 */
	public OutResults getPresent() throws SQLException;
	
	/**
	 * ��������ȡ��������
	 * @author Q
	 * @created 2016��7��15�� ����12:51:41
	 * @since 
	 * @param startPage
	 * @param isFirstPage
	 * @return
	 * @throws SQLException
	 * @throws IOException 
	 */
	public OutResults getNewMessage(String startPage, String isFirstPage) throws SQLException;
	
	/**
	 * ��������ȡ����title
	 * @author Q
	 * @created 2016��7��15�� ����3:33:00
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults getStudyTitle() throws SQLException;

	/**
	 * ��������ȡ���¼���б�
	 * @author Q
	 * @created 2016��7��15�� ����4:03:09
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults getStudyAbsList() throws SQLException;
	
	/**
	 * ��������������id��ȡ��������
	 * @author Q
	 * @created 2016��7��15�� ����4:04:30
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults getStudyContent(String id) throws SQLException;
	
	
	
	

}
