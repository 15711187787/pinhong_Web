package com.team5.zhaochao.dao;

import com.team5.zhaochao.bean.Administrator;

/**
 * ����Ա��dao��
 * @author superzhao
 *
 */
public interface AdminDao {
	public boolean admin_Add(Administrator admin);  //��ӹ���Ա
	public boolean checkName(String str); //����û����Ƿ��ظ�
	public boolean checkValidity(String username,String password);//����¼ʱ�˺ź������Ƿ���ȷ
	
}
