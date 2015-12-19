package com.team5.zhaochao.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.News;
import com.team5.zhaochao.dao.impl.NewsDaoImpl;
import com.team5.zhaochao.service.NewsService;
//����service���ʵ����
public class NewsServiceImpl implements NewsService {
	NewsDaoImpl ndi = new  NewsDaoImpl();
	//�������
	@Override
	public boolean newsAdd(News news) {
		boolean flag = ndi.newsAdd(news);
		return flag;
	}

	//չʾ����
	@Override
	public List<News> newsShow() {
		List<News> list = new ArrayList<News>();
		list = ndi.newsShow();
		return list;
	}

	//�޸�����
	@Override
	public boolean newsUpdate(News news) {
		return false;
	}

	//ɾ������
	@Override
	public boolean newsRemove(News news) {
		boolean flag = ndi.newsRemove(news);
		return flag;
	}
	
	  //����ҳ���ÿҳ���������õ�����
	public PageUtil getPage(int pageNo,int pageSize){
		PageUtil page = ndi.getPage(pageNo, pageSize);
		return page;
	}
}
