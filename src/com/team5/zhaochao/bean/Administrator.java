package com.team5.zhaochao.bean;

/**
 * ����Ա��bean��
 * 
 * @author zhaochao
 *
 */

public class Administrator {
	private int admin_id;   //����Ա�ı��
	private String username;  //����Ա���û���
	private String password;  //����Ա������
	
	//���췽��
	public Administrator() {
	}
	
	//get��set����
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
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
	
}
