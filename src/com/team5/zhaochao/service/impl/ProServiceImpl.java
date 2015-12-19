package com.team5.zhaochao.service.impl;

import java.util.List;

import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.Product;
import com.team5.zhaochao.dao.impl.ProDaoImpl;
import com.team5.zhaochao.service.ProService;
/**
 * ��Ʒ��service��ʵ����
 * @author superzhao
 *
 */
public class ProServiceImpl implements ProService {
	
	ProDaoImpl pdi = new ProDaoImpl();
	//�����Ʒ
	@Override
	public boolean proAdd(Product pro) {
		boolean flag = pdi.proAdd(pro);		
		return flag;
	}
	//������Ʒ
	@Override
	public boolean proUpdate(Product pro,int old_pro_id) {
		boolean flag = pdi.proUpdate(pro, old_pro_id);
		return flag;
	}
	//չʾ��Ʒ
	@Override
	public List<Product> proShow() {
		List<Product> list = pdi.proShow();
		return list;
	}
	//ɾ����Ʒ
	@Override
	public boolean proDelete(int pro_id) {
		boolean flag = pdi.proDelete(pro_id);
		return flag;
	}
	
	//�޸���Ʒǰ��ֵ������
	@Override
	public Product proUpdateForm(int pro_id) {
		Product pro = pdi.proUpdateForm(pro_id);
		return pro;
	}
	  //����ҳ���ÿҳ���������õ�����
	public PageUtil getPage(int pageNo,int pageSize){
		PageUtil page = pdi.getPage(pageNo, pageSize);
		return page;
	}
	
	//ʹ��commons.fileupload��commons.io��ʵ���ϴ�ͼƬ�������Ʒ����
	@Override
	public boolean proAddWithFile(Product pro) {
		boolean flag = pdi.proAddWithFile(pro);
		return flag;
	}

}
