package com.team5.zhaochao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team5.util.DBManager;
import com.team5.zhaochao.bean.Administrator;
import com.team5.zhaochao.dao.AdminDao;


/**
 * Administrator  dao ��ʵ����
 * @author superzhao
 *
 */
public class AdminDaoImpl implements AdminDao {

	//����û���
	@Override
	public boolean admin_Add(Administrator admin) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			ps = conn.prepareStatement("insert into administrator(username,password) values(?,?)"); 
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			int row = ps.executeUpdate();
			if(row>0){
				flag = true; //�������ݿ����б�Ӱ�����
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(null, ps, conn);//�ر����ݿ�
		}
		
		return flag;
	}

	//����û����Ƿ��ظ�
	@Override
	public boolean checkName(String str) {
		boolean flag  = true;
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from administrator where username = ?");
			ps.setString(1, str);
			rs = ps.executeQuery();
			if(!rs.next()){
				flag = false;//�������ݿ����û������û���
			}else{
				flag = true;//�������ݿ��д�������û���
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(rs, ps, conn); //�ر����ݿ�
		}
		return flag; 
	}

	//����Ա��¼,����û������������ȷ��
	public boolean checkValidity(String username,String password ) {
		boolean flag = false;
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select password from administrator where username = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				if(password.equals(rs.getString(1))){
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
