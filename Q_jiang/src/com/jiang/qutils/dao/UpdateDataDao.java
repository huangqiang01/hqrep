package com.jiang.qutils.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jiang.db.DBHelper;
import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * �����������ݿ����Ӳ㣬����������
 * @author Q
 * @created 2016��7��21�� ����4:58:19
 * @since
 */
public class UpdateDataDao {
	
	static DBHelper dbh;
	static ResultSet rs;
	
	/**
	 * ���������ӵ�����
	 * @author Q
	 * @created 2016��7��21�� ����5:04:34
	 * @since 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws QException
	 */
	public OutResults updateZan(String id) throws SQLException {
		
		OutResults or = new OutResults();
		
		String sql = "update studyTitle set zan = (zan + 1) where id ="+ id +";";
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
