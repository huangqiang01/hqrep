package com.jiang.service;

import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * 
 * 描述：修改数据库添数据
 * @author Q
 * @created 2016年7月21日 下午5:05:25
 * @since
 */
public interface UpdateData extends Serializable {
	
	/**
	 * 描述：增加点赞数
	 * @author Q
	 * @created 2016年7月21日 下午5:06:44
	 * @since 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws QException
	 */
	public OutResults updateZan(String id) throws SQLException, QException;

}
