package com.team5.zhaochao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team5.util.DBManager;
import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.User;
import com.team5.zhaochao.dao.UserDao;

public class UserDaoImpl implements UserDao {
	//����û���Ϣ
	@Override
	public boolean userAdd(User user) {
		return false;
	}
	//ɾ���û���Ϣ
	@Override
	public boolean userRemove(int user_id) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			ps = conn.prepareStatement("delete from user where user_id = ?");
			ps.setInt(1,user_id );
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
	
	
	//��ʾ�û���Ϣ
	@Override
	public List<User> userShow() {
		Connection conn = DBManager.getConnection();
		List<User> list = new ArrayList<User>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			 ps = conn.prepareStatement("select * from user");
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUser_id(rs.getInt(1));
				user.setUsername(rs.getString(5));
				user.setPassword(rs.getString(2));
				user.setRegister_date(rs.getDate(3));
				user.setEmail(rs.getString(4));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(rs, ps, conn);
		}
		return list;
	}
	
	 //����ҳ���ÿҳ���������õ�����
	@Override
	public PageUtil getPage(int pageNo, int pageSize) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		PageUtil page = null;
		try {
			//��ȡ����������
			int totalCount = 0; 
			ps = conn.prepareStatement("select count(user_id) from user");
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
			ps = conn.prepareStatement("select user_id,username from user limit " + (pageNo-1)*pageSize+","+pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUser_id(rs.getInt(1));
				user.setUsername(rs.getString(2));
				list.add(user);
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
