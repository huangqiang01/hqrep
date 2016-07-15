package com.jiang.qutils.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jiang.db.DBHelper;
import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * 
 * 描述：与数据库连接层，并查询数据
 * @author Q
 * @created 2016年7月15日 下午12:37:20
 * @since
 */
public class AddDataDao {
	
	static DBHelper dbh;
	static ResultSet rs;
	
	/**
	 * 描述：提交评价-建议
	 * @author Q
	 * @created 2016年7月1日 下午3:54:15
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
			or.setError_info("提交成功");
		} else {
			or.setError_info_no("-2", "提交失败");
		}
		return or;
	}
}
