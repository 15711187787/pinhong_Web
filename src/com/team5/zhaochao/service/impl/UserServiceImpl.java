package com.team5.zhaochao.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.User;
import com.team5.zhaochao.dao.impl.UserDaoImpl;
import com.team5.zhaochao.service.UserService;
/**
 * �û���service���ʵ����
 * @author superzhao
 *
 */
public class UserServiceImpl implements UserService {
	UserDaoImpl udi = new UserDaoImpl();
	
	//����û�
	@Override
	public boolean userAdd(User user) {
		return false;
	}
	//ɾ���û�
	@Override
	public boolean userRemove(int user_id) {
		boolean flag = udi.userRemove(user_id);
		return flag;
	}

	//��ʾ�����û�
	@Override
	public List<User> userShow() {
		List<User> list = new ArrayList<User>();
		list = udi.userShow();
		return list;
	}

	 //����ҳ���ÿҳ���������õ�����
	public PageUtil getPage(int pageNo,int pageSize){
		PageUtil page = udi.getPage(pageNo, pageSize);
		return page;
	}

}
