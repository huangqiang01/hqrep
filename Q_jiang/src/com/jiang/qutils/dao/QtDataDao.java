package com.jiang.qutils.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiang.bean.QtInfo;
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
public class QtDataDao {
	
	static DBHelper dbh;
	static ResultSet rs;
	
	/**
	 * 描述：增加/修改 邀请人
	 * @author Q
	 * @created 2016年8月23日 上午10:08:07
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
	public OutResults addInviter(int id, String qtName, String phoneNo, String category, String opinion, String reason, String greetings) throws SQLException, QException {
		String sql = "";
		OutResults or = new OutResults();
		if (id == 0){
			sql = "insert into qtInfo values(0, '" + qtName + "', '" + phoneNo + "', '" + category + "', '" + opinion + "', '" + reason + "', '" + greetings + "', '')";
		} else {
			sql = "update qtInfo set qtName='"+qtName+"',phoneNo='"+phoneNo+"',category='"+category+"',opinion='"+opinion+"',reason='"+reason+"',greetings='"+greetings+"' where id="+id;
		}
		dbh = new DBHelper(sql);
		int up_num = dbh.pst.executeUpdate();
		if (up_num > 0) {
			or.setError_info("提交成功");
		} else {
			or.setError_info_no("-2", "提交失败");
		}
		return or;
	}
	
	/**
	 * 描述：查询所有信息
	 * @author Q
	 * @created 2016年8月23日 上午10:19:21
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults queryInviter() throws SQLException{
		QtInfo qt = null;
		List list = new ArrayList();
		OutResults or = new OutResults();
		dbh = new DBHelper("select qtName,phoneNo,opinion,qtDate,qtTime from qtInfo order by qtDate desc, qtTime desc");
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			qt = new QtInfo();
			qt.setQtName(rs.getString("qtName"));
			qt.setPhoneNo(rs.getString("phoneNo"));
			qt.setOpinion(rs.getString("opinion"));
			qt.setQtDate(rs.getString("qtDate"));
			qt.setQtTime(rs.getString("qtTime"));
			list.add(qt);
		}
		or.setResults(list);
		return or;
	}
	
	/**
	 * 描述：查询个人信息
	 * @author Q
	 * @created 2016年8月23日 上午10:25:46
	 * @since 
	 * @param qtName
	 * @param phoneNo
	 * @return
	 * @throws SQLException
	 */
	public OutResults queryOneInfo(String qtName, String phoneNo) throws SQLException{
		QtInfo qt = null;
		List list = new ArrayList();
		OutResults or = new OutResults();
		dbh = new DBHelper("select qtName,phoneNo,category,opinion,reason,greetings,qtDate,qtTime from qtInfo where phoneNo='"+phoneNo+"' and qtName='"+qtName+"'");
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			qt = new QtInfo();
			qt.setId(rs.getString("id"));
			qt.setQtName(rs.getString("qtName"));
			qt.setPhoneNo(rs.getString("phoneNo"));
			qt.setCategory(rs.getString("category"));
			qt.setOpinion(rs.getString("opinion"));
			qt.setReason(rs.getString("reason"));
			qt.setGreetings(rs.getString("greetings"));
			qt.setQtDate(rs.getString("qtDate"));
			qt.setQtTime(rs.getString("qtTime"));
			list.add(qt);
		}
		or.setResults(list);
		return or;
	}
	
	/**
	 * 描述：查询祝福语
	 * @author Q
	 * @created 2016年8月23日 上午10:28:34
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults queryGreetings() throws SQLException{
		QtInfo qt = null;
		List list = new ArrayList();
		OutResults or = new OutResults();
		dbh = new DBHelper("select greetings from qtInfo");
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			qt = new QtInfo();
			qt.setGreetings(rs.getString("greetings"));
			list.add(qt);
		}
		or.setResults(list);
		return or;
	}
}
