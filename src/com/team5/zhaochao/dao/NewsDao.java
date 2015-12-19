package com.team5.zhaochao.dao;

import java.util.List;

import com.team5.zhaochao.bean.News;

/**
 * ���ŵ�dao��
 * @author superzhao
 *
 */
public interface NewsDao {
	public boolean newsAdd(News news);//�������
	public List<News> newsShow();//���ŵ���ʾ
	public boolean newsUpdate(News news);//���ŵ��޸�
	public boolean newsRemove(News news);//���ŵ�ɾ��
	public com.team5.util.PageUtil getPage(int pageNo,int pageSize);  //����ҳ���ÿҳ���������õ�����
}
