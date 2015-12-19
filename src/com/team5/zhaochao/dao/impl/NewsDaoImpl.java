package com.team5.zhaochao.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team5.util.DBManager;
import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.News;
import com.team5.zhaochao.dao.NewsDao;
/**
 * ���ŵ�dao���ʵ����
 * @author superzhao
 *
 */
public class NewsDaoImpl implements NewsDao {

	//�������
	@Override
	public boolean newsAdd(News news) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		Date time = new Date(new java.util.Date().getTime());
		try {
			ps = conn.prepareStatement("insert into news(news_title,news_date,news_content) values(?,?,?)");
			ps.setString(1, news.getNews_title());
			ps.setDate(2, time);
			ps.setString(3, news.getNews_content());
			int row = ps.executeUpdate();
			if(row>0){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(null, ps, conn);
		}
		return flag;
	}

	//չʾ����
	@Override
	public List<News> newsShow() {
		List<News> list = new ArrayList<News>();
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select news_id,news_title,news_date from news");
			rs = ps.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setNews_id(rs.getInt(1));
				news.setNews_title(rs.getString(2));
				news.setNews_date(rs.getDate(3));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(rs, ps, conn);
		}
		return list;
	}

	//��������
	@Override
	public boolean newsUpdate(News news) {
		return false;
	}

	//ɾ������
	@Override
	public boolean newsRemove(News news) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			ps = conn.prepareStatement("delete from news where news_id = ?");
			ps.setInt(1, news.getNews_id());
			if(ps.executeUpdate()>0){  //����ִ�гɹ�������
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(null, ps, conn);
		}
		
		return flag;
	}

	////����ҳ���ÿҳ���������õ�����
	@Override
	public PageUtil getPage(int pageNo, int pageSize) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		PageUtil page = null;
		try {
			//��ȡ����������
			int totalCount = 0; 
			ps = conn.prepareStatement("select count(news_id) from news");
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			ps = conn.prepareStatement("select news_id,news_title,news_date from news limit " + (pageNo-1)*pageSize+","+pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setNews_id(rs.getInt(1));
				news.setNews_title(rs.getString(2));
				news.setNews_date(rs.getDate(3));
				list.add(news);
			}
			page = new PageUtil(pageSize, totalCount);
			page.setData(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(rs, ps, conn);
		}
		return page;
	}


}
