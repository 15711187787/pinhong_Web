package com.team5.zhaochao.service;

import java.util.List;

import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.Product;
/**
 *��Ʒ��service�� 
 * @author superzhao
 *
 */
public interface ProService {
	public boolean proAdd(Product pro);//�����Ʒ
	public Product proUpdateForm(int pro_id);//�޸���Ʒǰ��ֵ������
	public boolean proUpdate(Product pro,int old_pro_id);//�޸���Ʒ
	public List<Product> proShow();//չʾ������Ʒ
	public boolean proDelete(int pro_id); //ɾ����Ʒ
	public PageUtil getPage(int pageNo,int pageSize); //����ҳ���ÿҳ���������õ�����
	public boolean proAddWithFile(Product pro);  //ʹ��commons.fileupload��commons.io��ʵ���ϴ�ͼƬ�������Ʒ����
}
