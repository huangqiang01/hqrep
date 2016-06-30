package com.jiang.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * �����������ݿ⣬�ر����ݿ�
 * @author Q
 * @created 2016��5��13�� ����2:02:26
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
			// ָ����������
			Class.forName(driver);
			// ��ȡ����
			conn = DriverManager.getConnection(url, user, password);
			// ׼��ִ�����
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
