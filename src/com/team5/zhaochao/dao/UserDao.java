package com.team5.zhaochao.dao;

import java.util.List;

import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.User;

/**
 * �û���dao��
 * @author superzhao
 *
 */

public interface UserDao {

	public boolean userAdd(User user); //����û�
	public boolean userRemove(int user_id);  //ɾ���û�
	public List<User> userShow();  //��ʾ�����û�
	//public boolean userUpdate(); //�޸��û���Ϣ
	public PageUtil getPage(int pageNo,int pageSize);  //����ҳ���ÿҳ���������õ�����
		
}
