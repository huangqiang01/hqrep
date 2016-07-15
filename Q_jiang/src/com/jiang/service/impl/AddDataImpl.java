package com.jiang.service.impl;

import java.sql.SQLException;

import com.jiang.qutils.QException;
import com.jiang.qutils.bean.OutResults;
import com.jiang.qutils.dao.AddDataDao;
import com.jiang.qutils.dao.GetDataDao;
import com.jiang.service.AddData;

public class AddDataImpl implements AddData {
	
	private static final long serialVersionUID = -3885798033866006173L;
	
	GetDataDao getDataDao = new GetDataDao();
	AddDataDao addDataDao = new AddDataDao();
	
	@Override
	public OutResults submitLeave(String time, String date, String text, String mark, String ip) throws SQLException, QException {
		
		int no = getDataDao.queryAddNo(date, mark, ip);
		if (no >= 2) {
			throw new QException("-1", "你提交的次数过多");
		}
		return addDataDao.submitLeave(time, date, text, mark, ip);
	}
}
