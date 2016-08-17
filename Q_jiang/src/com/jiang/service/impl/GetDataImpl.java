package com.jiang.service.impl;

import java.sql.SQLException;

import com.jiang.qutils.bean.OutResults;
import com.jiang.qutils.dao.GetDataDao;
import com.jiang.service.GetData;

public class GetDataImpl implements GetData {
	
	private static final long serialVersionUID = 3388115292101105247L;
	
	GetDataDao getDataDao = new GetDataDao();
	
	
	@Override
	public OutResults getBannerImg() throws SQLException {
		
		return getDataDao.getBannerImg();
		
	}

	@Override
	public OutResults getPresent() throws SQLException {
		return getDataDao.getPresent();
	}

	@Override
	public OutResults getNewMessage(String startPage, String isFirstPage) throws SQLException {
		return getDataDao.getNewMessage(startPage, isFirstPage);
	}

	@Override
	public OutResults getStudyTitle() throws SQLException {
		System.out.println(getDataDao.getStudyTitle());
		
		
		
		return getDataDao.getStudyTitle();
	}

	@Override
	public OutResults getStudyAbsList() throws SQLException {
		return getDataDao.getStudyAbsList();
	}

	@Override
	public OutResults getStudyContent(String id) throws SQLException {
		return getDataDao.getStudyContent(id);
	}

	@Override
	public OutResults getPhoto(String startPage) throws SQLException {
		return getDataDao.getPhoto(startPage);
	}
}
