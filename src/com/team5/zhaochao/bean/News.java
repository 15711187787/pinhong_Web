package com.team5.zhaochao.bean;

import java.util.Date;

/**
 * ���ŵ�bean��
 * @author superzhao
 *
 */
public class News {
	private int news_id; //���ű��
	private String news_title; //���ű���
	private Date news_date; //���ŷ�������
	private String news_content;  //��������
	
	//���캯��
	public News() {
	}
	
	public News(int news_id, String news_title, Date news_date,
			String news_content) {
		super();
		this.news_id = news_id;
		this.news_title = news_title;
		this.news_date = news_date;
		this.news_content = news_content;
	}

	//get��set����
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public Date getNews_date() {
		return news_date;
	}
	public void setNews_date(Date news_date) {
		this.news_date = news_date;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	
}
