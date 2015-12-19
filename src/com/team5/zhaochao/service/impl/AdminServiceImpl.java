package com.team5.zhaochao.service.impl;

import com.team5.zhaochao.bean.Administrator;
import com.team5.zhaochao.dao.AdminDao;
import com.team5.zhaochao.dao.impl.AdminDaoImpl;
import com.team5.zhaochao.service.AdminService;

/**
 * �û���serviceʵ����
 * @author superzhao
 *
 */
public class AdminServiceImpl implements AdminService {
	AdminDaoImpl adi = new AdminDaoImpl();
	//��ӹ���Ա
	@Override
	public boolean admin_Add(Administrator admin) {
		boolean flag = adi.admin_Add(admin);		
		return flag;
	}
	
	//������Ա���û����Ƿ����
	@Override
	public boolean checkName(String str) {
		boolean flag = adi.checkName(str);
		return flag;
	}

	@Override
	public boolean checkValidity(String username, String password) {
		boolean flag = adi.checkValidity(username, password);
		return flag;
	}

}
