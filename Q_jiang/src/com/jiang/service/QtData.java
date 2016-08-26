package com.jiang.service;

import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * 描述：请帖
 * @author Q
 * @created 2016年8月23日 上午10:29:34
 * @since
 */
public interface QtData extends Serializable {
	
	/**
	 * 描述：增加/修改邀请人
	 * @author Q
	 * @created 2016年8月23日 上午10:30:13
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
	 * 描述：查询所有信息
	 * @author Q
	 * @created 2016年8月23日 上午10:31:27
	 * @since 
	 * @return
	 * @throws SQLException
	 * @throws QException
	 */
	public OutResults queryInviter() throws SQLException;
	
	/**
	 * 描述：查询个人信息
	 * @author Q
	 * @created 2016年8月23日 上午10:32:25
	 * @since 
	 * @param qtName
	 * @param phoneNo
	 * @return
	 */
	public OutResults queryOneInfo(String qtName, String phoneNo) throws SQLException;
	
	/**
	 * 描述：查询祝福语
	 * @author Q
	 * @created 2016年8月23日 上午10:32:31
	 * @since 
	 * @return
	 */
	public OutResults queryGreetings() throws SQLException;
	
	
	

}
