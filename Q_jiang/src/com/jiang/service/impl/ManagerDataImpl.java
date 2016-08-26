package com.jiang.service.impl;

import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;
import com.jiang.qutils.dao.ManagerDataDao;
import com.jiang.service.ManagerData;

/**
 * 
 * 描述：管理者操作
 * @author Q
 * @created 2016年8月22日 上午11:06:06
 * @since
 */
public class ManagerDataImpl implements ManagerData {
	
	private static final long serialVersionUID = 4646791970951293941L;
	
	ManagerDataDao managerDataDao = new ManagerDataDao();
	
	/**
	 * 登录
	 */
	@Override
	public OutResults managerLogin(String name, String passw, String check) {
		OutResults or = new OutResults();
		if (name.equals("手机欠费") && passw.equals("147258") && check.equals("999999")){
			or.setError_info_no("0", "调用成功");
			return or;
		} else {
			or.setError_info_no("-1", "调用失败");
			return or;
		}
	}
	
	/**
	 * 增加照片，修改照片信息
	 * @throws QException 
	 * @throws SQLException 
	 */
	@Override
	public OutResults addOrUpdatePhoto(int id, int classId, String imgName,
			String shotTypes, String imgInfo, String imgUrl, String imgWidth,
			String imgHeight, String imgDate, String imgTime, String introduce,
			String isShow) throws QException, SQLException {
		if (classId == 0){
			classId = 0;
		}
		if (imgName.equals("") || imgName == null){
			throw new QException("-1", "名称不能为空");
		}
		if (shotTypes.equals("") || shotTypes == null){
			shotTypes = "手机";
		}
		if (imgUrl.equals("") || imgUrl == null){
			throw new QException("-2", "图片路径不能为空");
		}
		if (isShow.equals("") || isShow == null){
			isShow = "0";
		}
		return managerDataDao.addOrUpdatePhoto(id, classId, imgName, shotTypes, imgInfo, imgUrl, imgWidth, imgHeight, imgDate, imgTime, introduce, isShow);
	}
}
