package com.jiang.service;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import com.jiang.qutils.bean.OutResults;

/**
 * 
 * 描述：获取数据库数据
 * @author Q
 * @created 2016年7月15日 下午12:53:30
 * @since
 */
public interface GetData extends Serializable {
	
	/**
	 * 描述：获取首页banner
	 * @author Q
	 * @created 2016年7月4日 下午2:37:41
	 * @since 
	 * @throws SQLException
	 * @throws IOException 
	 */
	public OutResults getBannerImg() throws SQLException;
	
	/**
	 * 描述：查询相关介绍
	 * @author Q
	 * @created 2016年7月15日 下午12:50:23
	 * @since 
	 * @return
	 * @throws SQLException
	 * @throws IOException 
	 */
	public OutResults getPresent() throws SQLException;
	
	/**
	 * 描述：获取最新留言
	 * @author Q
	 * @created 2016年7月15日 下午12:51:41
	 * @since 
	 * @param startPage
	 * @param isFirstPage
	 * @return
	 * @throws SQLException
	 * @throws IOException 
	 */
	public OutResults getNewMessage(String startPage, String isFirstPage) throws SQLException;
	
	/**
	 * 描述：获取文章title
	 * @author Q
	 * @created 2016年7月15日 下午3:33:00
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults getStudyTitle() throws SQLException;

	/**
	 * 描述：获取文章简介列表
	 * @author Q
	 * @created 2016年7月15日 下午4:03:09
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults getStudyAbsList() throws SQLException;
	
	/**
	 * 描述：根据文章id获取文章内容
	 * @author Q
	 * @created 2016年7月15日 下午4:04:30
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults getStudyContent(String id) throws SQLException;
	
	
	
	

}
