package com.team5.liuwei.service.impl;

import java.util.List;

import com.team5.liuwei.bean.News;
import com.team5.liuwei.dao.impl.NewsDaoImpl;
import com.team5.liuwei.service.NewsService;
import com.team5.util.PageUtil;

public class SelectNews implements NewsService{
//��ȡ����������Ϣ
	public List<News> selectAll() {
		NewsDaoImpl news = new NewsDaoImpl();
		List<News> allnews = news.selectAll();
		return allnews;
	}

	
	//��ȡĳ��������Ϣ
	public News selectOne(int index) {
			NewsDaoImpl news = new NewsDaoImpl();
			List<News> allnews = news.selectAll();
			News onenews = null;
			for(int i=0;i<allnews.size();i++){
				if(index==allnews.get(i).getNews_id()){
					onenews = allnews.get(i);
					break;
				}
			}
			return onenews;
	}
	
	//����ҳ���ÿҳ���������õ�����
		public PageUtil getPage(int pageNo,int pageSize){
			NewsDaoImpl news = new NewsDaoImpl();
			PageUtil page = news.getPage(pageNo, pageSize);
			return page;
		}
	
}

