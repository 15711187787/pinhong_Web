package com.team5.zhaochao.service;

import java.util.List;

import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.News;
/**
 * ���ŵ�service�ӿ���
 * @author superzhao
 *
 */
public interface NewsService {
	public boolean newsAdd(News news);//�������
	public List<News> newsShow();//���ŵ���ʾ
	public boolean newsUpdate(News news);//���ŵ��޸�
	public boolean newsRemove(News news);//���ŵ�ɾ��
	public PageUtil getPage(int pageNo,int pageSize); //����ҳ���ÿҳ���������õ�����
}
