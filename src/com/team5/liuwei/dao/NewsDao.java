package com.team5.liuwei.dao;

import java.util.List;

import com.team5.liuwei.bean.News;

public interface NewsDao {
     List<News> selectAll();
     public com.team5.util.PageUtil getPage(int pageNo,int pageSize);  //����ҳ���ÿҳ���������õ�����
}
