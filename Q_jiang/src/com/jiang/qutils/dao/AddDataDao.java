package com.jiang.qutils.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jiang.db.DBHelper;
import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * 
 * �����������ݿ����Ӳ㣬����ѯ����
 * @author Q
 * @created 2016��7��15�� ����12:37:20
 * @since
 */
public class AddDataDao {
	
	static DBHelper dbh;
	static ResultSet rs;
	
	/**
	 * �������ύ����-����
	 * @author Q
	 * @created 2016��7��1�� ����3:54:15
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 * @throws QException 
	 */
	public OutResults submitLeave(String time, String date, String text, String mark, String ip) throws SQLException, QException {
		String tname = "websiteEvaluation";
		OutResults or = new OutResults();
		if (mark.equals("1")) {
			tname = "websiteSuggest";
		}
		String sql = "insert into " + tname + " values(0, '" + time + "', '" + date + "', '" + text + "', '" + ip + "', '')";
		dbh = new DBHelper(sql);
		int up_num = dbh.pst.executeUpdate();
		if (up_num > 0) {
			or.setError_info("�ύ�ɹ�");
		} else {
			or.setError_info_no("-2", "�ύʧ��");
		}
		return or;
	}
}
