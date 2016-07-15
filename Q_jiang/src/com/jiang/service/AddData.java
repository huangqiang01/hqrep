package com.jiang.service;

import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * 
 * 描述：向数据库添加数据
 * @author Q
 * @created 2016年7月15日 下午12:53:19
 * @since
 */
public interface AddData extends Serializable {
	
	/**
	 * 
	 * 描述：提交评价-建议
	 * @author Q
	 * @created 2016年7月15日 下午12:55:36
	 * @since 
	 * @param time 提交的时间
	 * @param date 提交的日期
	 * @param text 提交的内容
	 * @param mark 0-建议，1-留言
	 * @param ip 提交的主机
	 * @return
	 * @throws SQLException
	 * @throws QException 
	 */
	public OutResults submitLeave(String time, String date, String text, String mark, String ip) throws SQLException, QException;

}
