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
 * ģ��     �˴�����ҵ��Ĵ����
 * 
 */
public class GetDataImpl extends QOutput {
	
	static DBHelper dbh;
	static ResultSet rs;

	//ģ���ȡ ����
	public void getUserinfo(String username, String password) throws Exception, IOException, SQLException{
		List list = new ArrayList();
		//ģ���ȡ���ݿ�����
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
		dbh = new DBHelper("insert into big_directory value(2, '�찲��', '�찲����̫����', '�Ұ������찲�ţ��찲����̫������ΰ��...');");
		
		int up_num = dbh.pst.executeUpdate();
		if (up_num > 0){
			this.outPut("0", "��ӳɹ�");
		} else {
			this.outPut("-1", "���ʧ��");
		}
	}
	
	public void updateInfo() throws SQLException, IOException{
		
		dbh = new DBHelper("update big_directory set title='��ԭ',info='�����Ĵ��ԭ' where id=2;");
		
		int up_num = dbh.pst.executeUpdate();
		
		if (up_num > 0){
			this.outPut("0", "�޸ĳɹ�");
		} else {
			this.outPut("-1", "�޸�ʧ��");
		}
	}
	
	public void deleteInfo() throws SQLException, IOException{
		dbh = new DBHelper("delete from big_directory where big_directory.id=2;");
		int up_num = dbh.pst.executeUpdate();
		
		if (up_num > 0){
			this.outPut("0", "ɾ���ɹ�");
		} else {
			this.outPut("-1", "ɾ��ʧ��");
		}
	}
	
	/**
	 * 
	 * ��������ѯ��ؽ���
	 * @author Q
	 * @created 2016��7��1�� ����3:54:42
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getPresent() throws SQLException, IOException{
		List list = new ArrayList();
		//ģ���ȡ���ݿ�����
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
	 * �������ύ����-����
	 * @author Q
	 * @created 2016��7��1�� ����3:54:15
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void submitLeave(String time, String date, String text) throws SQLException, IOException{
		String sql = "insert into websiteEvaluation values(0, '"+time+"', '"+date+"', '"+text+"', '')";
		dbh = new DBHelper(sql);
		int up_num = dbh.pst.executeUpdate();
		if (up_num > 0){
			this.outPut("0", "�ύ�ɹ�");
		} else {
			this.outPut("-1", "�ύʧ��");
		}
	}
	
	/**
	 * 
	 * ��������ȡ��������
	 * @author Q
	 * @created 2016��7��1�� ����4:20:48
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getNewMessage(String startPage) throws SQLException, IOException{
		List list = new ArrayList();
		//ģ���ȡ���ݿ�����
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
