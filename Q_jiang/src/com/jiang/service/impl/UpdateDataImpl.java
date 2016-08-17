package com.jiang.service.impl;

import java.sql.SQLException;

import com.jiang.qutils.bean.OutResults;
import com.jiang.qutils.dao.UpdateDataDao;
import com.jiang.service.UpdateData;

public class UpdateDataImpl implements UpdateData {
	
	private static final long serialVersionUID = -3885798033866006173L;
	
	UpdateDataDao updateDataDao = new UpdateDataDao();
	@Override
	public OutResults updateZan(String id) throws SQLException {
		return updateDataDao.updateZan(id);
	}
	
	public static void main(String[] args) {
		try {
			new UpdateDataImpl().updateZan("1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
