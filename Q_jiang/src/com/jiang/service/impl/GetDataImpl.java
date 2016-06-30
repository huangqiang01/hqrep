package com.jiang.service.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	 * ��ѯ��ؽ���
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void getPresent() throws SQLException, IOException{
		List list = new ArrayList();
		//ģ���ȡ���ݿ�����
		Presentations present = new Presentations();
		dbh = new DBHelper("select * from presentations;");
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			present.setId(rs.getString("id"));
			present.setPrName(rs.getString("prName"));
			present.setPrContent(rs.getString("prContent"));
			present.setIsShow(rs.getString("isShow"));
			present.setReserve(rs.getString("reserve"));
			list.add(present);
		}
		this.outPut(list);
	} 
	
	
	
	
	
	
	
}
