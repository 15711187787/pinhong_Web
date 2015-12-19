package com.team5.zhaochao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.News;
import com.team5.zhaochao.service.impl.NewsServiceImpl;
/**
 * ���ŵ�servlet��
 * @author superzhao
 *
 */
public class NewsServlet extends HttpServlet {

	NewsServiceImpl nsi  = new NewsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	//���ݴ�����method������ѡ��ʵ���ĸ�����
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method.equals("AddNews")){
			doAddNews(request, response);
		}else if(method.equals("RemoveNews")){
			doRemoveNews(request, response);
		}else if(method.equals("ShowNews")){
			doShowNews(request, response);
		}else if(method.equals("showPage")){
			doNewsShowPage(request, response);
		}
	}
	
	
	//�������
	public void doAddNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		News news = new News();
		String news_title = request.getParameter("title");
		String news_content = request.getParameter("content");
		news.setNews_title(news_title);
		news.setNews_content(news_content);
		boolean flag = nsi.newsAdd(news);
		if(flag==true){
			request.getRequestDispatcher("zcNewsServlet?method=showPage&pageNo=1").forward(request, response);;
		}else{
			out.print("���ʧ��");
		}

		out.close();
	}
	
	//ɾ������
	public void doRemoveNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int news_id = Integer.parseInt(request.getParameter("news_id"));
		News news = new News();
		news.setNews_id(news_id);
		boolean flag = nsi.newsRemove(news);
		if(flag == true){
			request.getRequestDispatcher("zcNewsServlet?method=showPage&pageNo=1").forward(request, response);
		}else{
			out.print("ɾ��ʧ��!");
		}
		out.close();
	}
	
	//չʾ����
	public void doShowNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		List<News> list = new ArrayList<News>();
		list = nsi.newsShow();
		request.setAttribute("newsList", list);
		request.getRequestDispatcher("admin/manageNews.jsp").forward(request, response);
	}
	//��ҳ��ʾ
	public void doNewsShowPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo =  pageNo = Integer.parseInt(request.getParameter("pageNo"));
		//����ÿҳ��ʾ��������
		PageUtil page = nsi.getPage(pageNo, 5);
		page.setPageNo(pageNo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("admin/manageNews.jsp").forward(request, response);
	}
	
}
