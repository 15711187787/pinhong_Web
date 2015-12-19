package com.team5.zhaochao.bean;

import java.util.Date;

/**
 * �û���bean��
 * 
 * @author superzhao
 *
 */

public class User {
	private int user_id;    //�û��ı��
	private String username;  //�û����û���
	private String password;  //�û�������
	private Date register_date;  //�û�ע�������
	private String email;  // �û�������
	
	//get��set����
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//���췽��
	public User(int user_id, String username, String password,
			Date register_date, String email) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.register_date = register_date;
		this.email = email;
	}
	public User() {
	}
	
	
	
}
