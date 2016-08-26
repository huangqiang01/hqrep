package com.jiang.qutils.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jiang.bean.Photo;
import com.jiang.db.DBHelper;
import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;

/**
 * 描述：与数据库连接层，manager
 * @author Q
 * @created 2016年8月22日 下午1:28:31
 * @since
 */
public class ManagerDataDao {
	
	static DBHelper dbh;
	static ResultSet rs;
	
	/**
	 * 描述：增加照片或修改照片信息
	 * @author Q
	 * @created 2016年8月22日 下午1:42:42
	 * @since 
	 * @param mark
	 * @param classId
	 * @param imgName
	 * @param shotTypes
	 * @param imgInfo
	 * @param imgUrl
	 * @param imgWidth
	 * @param imgHeight
	 * @param imgDate
	 * @param imgTime
	 * @param introduce
	 * @param isShow
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws QException
	 */
	public OutResults addOrUpdatePhoto(int id, int classId, String imgName, String shotTypes, String imgInfo, String imgUrl, String imgWidth, String imgHeight, String imgDate, String imgTime, String introduce, String isShow) throws SQLException, QException {
		String sql = "";
		OutResults or = new OutResults();
		if (id == 0){
			sql = "insert into photo values(0, "+classId+", '"+imgName+"', '"+shotTypes+"', '"+imgInfo+"', '"+imgUrl+"', '"+imgWidth+"', '"+imgHeight+"', '"+imgDate+"', '"+imgTime+"', '"+introduce+"', '"+isShow+"')";
		} else {
			sql = "update photo set classId="+classId+", imgName='"+imgName+"', shotTypes='"+shotTypes+"', imgInfo='"+imgInfo+"', imgUrl='"+imgUrl+"', imgWidth='"+imgWidth+"', imgHeight='"+imgHeight+"', imgDate='"+imgDate+"', imgTime='"+imgTime+"', introduce='"+introduce+"', isShow='"+isShow+"' where id="+id;
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
}
