package com.jiang.qutils.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiang.bean.BannerImg;
import com.jiang.bean.Evaluation;
import com.jiang.bean.Presentations;
import com.jiang.bean.StudyContent;
import com.jiang.bean.StudyTitle;
import com.jiang.db.DBHelper;
import com.jiang.qutils.bean.OutResults;

/**
 * 
 * 描述：与数据库连接层，并查询数据
 * @author Q
 * @created 2016年7月15日 下午12:37:20
 * @since
 */
public class GetDataDao {
	
	static DBHelper dbh;
	static ResultSet rs;
	/**
	 * 
	 * 描述：获取首页banner
	 * @author Q
	 * @created 2016年7月4日 下午2:37:41
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public OutResults getBannerImg() throws SQLException{
		List list = new ArrayList();
		OutResults or = new OutResults();
		//模拟获取数据库数据
		BannerImg bannerImg;
		dbh = new DBHelper("select * from bannerImg where isShow=1 order by showOrder;");
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			bannerImg = new BannerImg();
			bannerImg.setId(rs.getString("id"));
			bannerImg.setAddr(rs.getString("addr"));
			bannerImg.setiName(rs.getString("iName"));
			bannerImg.setiExplain(rs.getString("iExplain"));
			bannerImg.setIsShow(rs.getString("isShow"));
			bannerImg.setShowOrder(rs.getString("showOrder"));
			bannerImg.setReserve(rs.getString("reserve"));
			list.add(bannerImg);
		}
		
		or.setResults(list);
		return or;
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
	public OutResults getPresent() throws SQLException{
		List list = new ArrayList();
		OutResults or = new OutResults();
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
		
		or.setResults(list);
		return or;
	}
	
	/**
	 * 描述：获取最新留言
	 * @author Q
	 * @created 2016年7月1日 下午4:20:48
	 * @since 
	 * @throws SQLException
	 * @throws IOException
	 */
	public OutResults getNewMessage(String startPage, String isFirstPage) throws SQLException{
		List list = new ArrayList();
		OutResults or = new OutResults();
		//模拟获取数据库数据
		Evaluation evaluation;
		int start = Integer.parseInt(startPage);
		if (isFirstPage != null && isFirstPage.equals("1")){
			dbh = new DBHelper("select * from websiteEvaluation order by edate desc, etime desc, id desc limit 0, 5;");
		} else {
			dbh = new DBHelper("select * from websiteEvaluation order by edate desc, etime desc, id desc limit "+((start - 1)*20)+", 20;");
		}
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
		or.setResults(list);
		return or;
	}
	
	/**
	 * 
	 * 描述：获取当日提交的留言-建议数量
	 * @author Q
	 * @created 2016年7月15日 下午1:40:47
	 * @since 
	 * @param date
	 * @param ip
	 * @return
	 * @throws SQLException
	 */
	public int queryAddNo(String date, String mark, String ip) throws SQLException{
		String tname = "websiteEvaluation";
		if (mark.equals("1")){
			tname = "websiteSuggest";
		}
		String sql = "select t.id from " + tname + " as t where ip='" + ip + "' and edate='" + date + "'";
		dbh = new DBHelper(sql);
		rs = dbh.pst.executeQuery();
		rs.last();
		int no = rs.getRow();
		rs.beforeFirst();
		return no;
	}
	
	/**
	 * 描述：获取文章title
	 * @author Q
	 * @created 2016年7月15日 下午3:04:54
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults getStudyTitle() throws SQLException{
		List list = new ArrayList();
		OutResults or = new OutResults();
		//模拟获取数据库数据
		StudyTitle title;
		String sql = "select s.id,s.seriesId,s.contentListNo,s.textTital,s.releaseDate,s.notesState from studyTitle as s order by releaseDate, id";
		dbh = new DBHelper(sql);
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			title = new StudyTitle();
			title.setId(rs.getString("id"));
//			title.setClassId(rs.getString("classId"));
			title.setSeriesId(rs.getString("seriesId"));
			title.setContentListNo(rs.getString("contentListNo"));
			title.setTextTital(rs.getString("textTital"));
//			title.setsAbstract(rs.getString("sAbstract"));
			title.setReleaseDate(rs.getString("releaseDate"));
//			title.setZan(rs.getString("zan"));
			title.setNotesState(rs.getString("notesState"));
//			title.setReserve(rs.getString("reserve"));
			list.add(title);
		}
		
		or.setResults(list);
		return or;
		
	}
	
	/**
	 * 描述：获取文章简介列表
	 * @author Q
	 * @created 2016年7月15日 下午3:33:40
	 * @since 
	 * @return
	 * @throws SQLException
	 */
	public OutResults getStudyAbsList() throws SQLException{
		List list = new ArrayList();
		OutResults or = new OutResults();
		//模拟获取数据库数据
		StudyTitle title;
		String sql = "select s.id,s.classId,s.seriesId,s.textTital,s.sAbstract,s.releaseDate,s.zan,s.notesState from studyTitle as s order by releaseDate, id";
		dbh = new DBHelper(sql);
		rs = dbh.pst.executeQuery();
		while(rs.next()){
			title = new StudyTitle();
			title.setId(rs.getString("id"));
			title.setClassId(rs.getString("classId"));
			title.setSeriesId(rs.getString("seriesId"));
			title.setTextTital(rs.getString("textTital"));
			title.setsAbstract(rs.getString("sAbstract"));
			title.setReleaseDate(rs.getString("releaseDate"));
			title.setZan(rs.getString("zan"));
			title.setNotesState(rs.getString("notesState"));
//			title.setReserve(rs.getString("reserve"));
			list.add(title);
		}
		
		or.setResults(list);
		return or;
		
	}
	
	/**
	 * 描述：根据文章id获取文章内容
	 * @author Q
	 * @created 2016年7月15日 下午4:03:42
	 * @since 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public OutResults getStudyContent(String id) throws SQLException{
		id = "1";
		String sql = "select textTital,releaseDate,zan,content,referencePoint from studyTitle as st inner join sContent as sc on st.id=sc.studyId where sc.id="+id+";";
		System.out.println(sql);
		dbh = new DBHelper(sql);
		rs = dbh.pst.executeQuery();
		StudyContent stContent;
		List list = new ArrayList();
		OutResults or= new OutResults();
		
		while(rs.next()){
			stContent = new StudyContent();
			stContent.setTextTital(rs.getString("textTital"));
			stContent.setReleaseDate(rs.getString("textTital"));
			stContent.setZan(rs.getString("zan"));
			stContent.setContent(rs.getString("content"));
			stContent.setReferencePoint(rs.getString("referencePoint"));
			list.add(stContent);
		}
		or.setResults(list);
		return or;
	}
	
	
	
	public static void main(String[] args) {
		try {
			System.out.println(new GetDataDao().getStudyContent("1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
