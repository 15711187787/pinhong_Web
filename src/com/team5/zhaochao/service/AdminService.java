package com.team5.zhaochao.service;

import com.team5.zhaochao.bean.Administrator;
/**
 * �û���service��
 * @author superzhao
 *
 */
public interface AdminService {
	public boolean admin_Add(Administrator admin);  //��ӹ���Ա
	public boolean checkName(String str); //������Ա���û����Ƿ����
	public boolean checkValidity(String username,String password);//����¼ʱ�˺ź������Ƿ���ȷ
}
