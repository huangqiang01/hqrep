package com.jiang.service.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiang.bean.Evaluation;
import com.jiang.bean.Presentations;
import com.jiang.bean.Userinfo;
import com.jiang.db.DBHelper;
import com.jiang.qutils.QException;
import com.jiang.qutils.QOutput;

/**
 * 模拟     此处进行业务的处理层
 * 
 */
public class GetDataImpl extends QOutput {
	
	static DBHelper dbh;
	static ResultSet rs;

	//模拟获取 数据
	public void getUserinfo(String username, String password) throws Exception, IOException, SQLException{
		List list = new ArrayList();
		//模拟获取数据库数据
		Userinfo userinfo = new Userinfo();
		dbh = new DBHelper("select * from big_directory where id=0;");
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			userinfo.setUserid(rs.getString("id"));
			userinfo.setUsername(rs.getString("title"));
			userinfo.setPassword(rs.getString("info"));
			userinfo.setInfo(rs.getString("content"));
			list.add(userinfo);
		}
		this.outPut(list);
	}
	public void addInfo() throws SQLException, IOException{
		dbh = new DBHelper("insert into big_directory value(2, '天安门', '天安门上太阳升', '我爱北京天安门，天安门上太阳升，伟大...');");
		
		int up_num = dbh.pst.executeUpdate();
		if (up_num > 0){
			this.outPut("0", "添加成功");
		} else {
			this.outPut("-1", "添加失败");
		}
	}
	
	public void updateInfo() throws SQLException, IOException{
		
		dbh = new DBHelper("update big_directory set title='草原',info='美丽的大草原' where id=2;");
		
		int up_num = dbh.pst.executeUpdate();
		
		if (up_num > 0){
			this.outPut("0", "修改成功");
		} else {
			this.outPut("-1", "修改失败");
		}
	}
	
	public void deleteInfo() throws SQLException, IOException{
		dbh = new DBHelper("delete from big_directory where big_directory.id=2;");
		int up_num = dbh.pst.executeUpdate();
		
		if (up_num > 0){
			this.outPut("0", "删除成功");
		} else {
			this.outPut("-1", "删除失败");
		}
	}
	
	/**
	 * 
	 * 描述：查询相关介绍
	 * @author Q
	 * @created 2016年7月1日 下午3:54:42
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getPresent() throws SQLException, IOException{
		List list = new ArrayList();
		//模拟获取数据库数据
		Presentations present;
		dbh = new DBHelper("select * from presentations;");
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			present = new Presentations();
			present.setId(rs.getString("id"));
			present.setPrName(rs.getString("prName"));
			present.setPrContent(rs.getString("prContent"));
			present.setIsShow(rs.getString("isShow"));
			present.setReserve(rs.getString("reserve"));
			list.add(present);
		}
		this.outPut(list);
	}
	
	/**
	 * 
	 * 描述：提交建议-留言
	 * @author Q
	 * @created 2016年7月1日 下午3:54:15
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void submitLeave(String time, String date, String text) throws SQLException, IOException{
		String sql = "insert into websiteEvaluation values(0, '"+time+"', '"+date+"', '"+text+"', '')";
		dbh = new DBHelper(sql);
		int up_num = dbh.pst.executeUpdate();
		if (up_num > 0){
			this.outPut("0", "提交成功");
		} else {
			this.outPut("-1", "提交失败");
		}
	}
	
	/**
	 * 
	 * 描述：获取最新留言
	 * @author Q
	 * @created 2016年7月1日 下午4:20:48
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getNewMessage(String startPage) throws SQLException, IOException{
		List list = new ArrayList();
		//模拟获取数据库数据
		Evaluation evaluation;
		int start = Integer.parseInt(startPage);
		dbh = new DBHelper("select * from websiteEvaluation order by edate desc, etime desc, id desc limit "+((start - 1)*20)+", 20;");
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			evaluation = new Evaluation();
			evaluation.setId(rs.getString("id"));
			evaluation.setEtime(rs.getString("etime"));
			evaluation.setEdate(rs.getString("edate"));
			evaluation.setEvalContent(rs.getString("evalContent"));
			evaluation.setReserve(rs.getString("reserve"));
			list.add(evaluation);
		}
		this.outPut(list);
	}
	
	
	
	
	
}
