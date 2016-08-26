package com.jiang.service.impl;

import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;
import com.jiang.qutils.dao.QtDataDao;
import com.jiang.service.QtData;

public class QtDataImpl implements QtData {
	
	private static final long serialVersionUID = -8160260961307161439L;
	
	QtDataDao qtDataDao = new QtDataDao();
	
	@Override
	public OutResults addInviter(int id, String qtName, String phoneNo,
			String category, String opinion, String reason, String greetings)
			throws SQLException, QException {
		if (qtName.equals("") || qtName == null){
			throw new QException("-1", "姓名不能为空");
		}
		if (phoneNo.equals("") || phoneNo == null){
			throw new QException("-1", "手机号码不能为空");
		}
		return qtDataDao.addInviter(id, qtName, phoneNo, category, opinion, reason, greetings);
	}
	
	@Override
	public OutResults queryInviter() throws SQLException {
		return qtDataDao.queryInviter();
	}
	
	@Override
	public OutResults queryOneInfo(String qtName, String phoneNo) throws SQLException {
		return qtDataDao.queryOneInfo(qtName, phoneNo);
	}
	@Override
	public OutResults queryGreetings() throws SQLException {
		return qtDataDao.queryGreetings();
	}
	
}
