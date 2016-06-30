package com.jiang.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * 描述：打开数据库，关闭数据库
 * @author Q
 * @created 2016年5月13日 下午2:02:26
 * @since
 */
public class DBHelper {
	
	private final static String url = "jdbc:mysql://127.0.0.1:3306/app?useSSL=false";
	
	private final static String driver = "com.mysql.jdbc.Driver";
	
	private final static String user = "root";
	
	private final static String password = "tqyhq2@db";
	
	private Connection conn = null;
	
	public PreparedStatement pst = null;
	
	public DBHelper(String sql){
		try {
			// 指定连接类型
			Class.forName(driver);
			// 获取连接
			conn = DriverManager.getConnection(url, user, password);
			// 准备执行语句
			pst = conn.prepareStatement(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DBclose(){
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
