package com.team5.zhaochao.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.team5.util.PageUtil;
import com.team5.zhaochao.bean.Product;
import com.team5.zhaochao.service.impl.ProServiceImpl;

public class ProServlet extends HttpServlet {

	ProServiceImpl psi = new ProServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("Add")) {
			doProAdd(request, response);
		} else if (method.equals("Show")) {
			doProShow(request, response);
		} else if (method.equals("remove")) {
			doProDelete(request, response);
		} else if (method.equals("update")) {
			doProUpdate(request, response);
		} else if (method.equals("updateForm")) {
			doProUpdateForm(request, response);
		} else if (method.equals("showPage")) {
			doProShowPage(request, response);
		} else if (method.equals("AddWithFile")) {
			doProAddWithFile(request, response);
		}

	}

	// ��Ʒ���
	public void doProAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ��jsp��ȡ��ֵ
		int pro_id = Integer.parseInt(request.getParameter("serialNumber"));
		String pro_name = request.getParameter("name");
		String pro_brand = request.getParameter("brand");
		String pro_version = request.getParameter("model");
		Long pro_price = Long.parseLong(request.getParameter("price"));
		String pro_image = request.getParameter("picture");
		String pro_introduce = request.getParameter("description");

		// ����productʵ�������ֵ
		Product pro = new Product();
		pro.setPro_id(pro_id);
		pro.setPro_name(pro_name);
		pro.setPro_brand(pro_brand);
		pro.setPro_version(pro_version);
		pro.setPro_price(pro_price);
		pro.setPro_image(pro_image);
		pro.setPro_introduce(pro_introduce);
		boolean flag = psi.proAdd(pro);
		if (flag == true) {
			request.getRequestDispatcher("admin/manageProduct.jsp").forward(
					request, response);
		} else {
			out.print("�����Ʒʧ��");
		}

		out.close();
	}

	// �޸���Ʒ
	public void doProUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// DiskFileItemFactory FileItem ����Ĺ���,�����趨��������С�ʹ����ʱ�ļ�Ŀ¼
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// �����ڴ滺�����Ĵ�СΪ11k
		factory.setSizeThreshold(11 * 1024);
		// ָ�������ϴ��ļ�����ʱ�ļ���,�Լ�����
		File f = new File("F://tempDirectory");
		// setRepository�����������õ��ϴ��ļ��ߴ����setSizeThreshold�������õ��ٽ�ֵʱ�����ļ�����ʱ�ļ���ʽ�����ڴ����ϵĴ��Ŀ¼��
		factory.setRepository(f);
		// ����ServletFileUpload��ʵ��
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("UTF-8");
		// ���õ����ϴ��ļ������ֵΪ6M,���������ֽ�Ϊ��λ
		sfu.setFileSizeMax(6000 * 1024);
		int old_pro_id = Integer.parseInt(request.getParameter("old_pro_id"));
		try {
			// �õ����е�������(ÿ���ؼ�)�ļ���
			List<FileItem> items = sfu.parseRequest(request);
			// ����һ��product����
			Product pro = new Product();
			for (FileItem fileItem : items) {
				// isFormField()Ϊtrue��ʾ��ǰ�ؼ�����ͨ�ؼ���Ϊfalse��ʾ�����ϴ��ؼ�
				if (fileItem.isFormField()) {
					// ��ȡ�ؼ������ƣ���ÿ���������������
					String name = fileItem.getFieldName();
					// ��ȡ�ؼ���ֵ����UTF-8��ֹ��������
					String value = fileItem.getString("UTF-8");
					// �Կؼ�����������������жϣ����η�װ��һ��Product�����������
					if (name.equals("serialNumber")) {
						pro.setPro_id(Integer.parseInt(value));
					} else if (name.equals("name")) {
						pro.setPro_name(value);
					} else if (name.equals("brand")) {
						pro.setPro_brand(value);
					} else if (name.equals("model")) {
						pro.setPro_version(value);
					} else if (name.equals("price")) {
						pro.setPro_price(Long.parseLong(value));
					} else if (name.equals("description")) {
						pro.setPro_introduce(value);
					}
				} else {
					// �����ϴ��ļ�������
					// ��ȡ�ϴ��ļ�������
					String fileName = fileItem.getName();
					// ��ȡ�ϴ��ļ����ļ�����
					String contentType = fileItem.getContentType();
					// ��ȡ�ϴ��ļ��Ĵ�С
					long size = fileItem.getSize();
					// ��ȡ��ǰwebӦ�ø�Ŀ¼�ľ���·��(Tomcat���������𹤳̵ľ���·��)
					String path = this.getServletContext().getRealPath("/");
					// ��ȡ�����ϴ��ļ���ȫ·��
					String filePath = path + "images/" + fileName;
					// ��ȡ��װ���ϴ��ļ����ݵ�������
					InputStream is = fileItem.getInputStream();
					// �����
					OutputStream os = new FileOutputStream(filePath);
					// ����ļ�
					int len = 0;
					byte[] b = new byte[1024];
					while ((len = is.read(b)) != -1) {
						os.write(b, 0, len);
					}
					// �ر���
					os.close();
					is.close();
					// �ϴ��ɹ���,ɾ����ʱ�ļ�
					fileItem.delete();
					// ����ͼƬ��������·��,����Ҫ�浽���ݿ��е�
					pro.setPro_image("images/" + fileName);
				}
			}
			//����ҵ�����������Ʒ�ķ���
			boolean flag = psi.proUpdate(pro, old_pro_id);
			if (flag == true) {
				request.getRequestDispatcher("zcProServlet?method=showPage&pageNo=1").forward(
						request, response);
			} else {
				out.print("��Ʒ�޸�ʧ��");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	

	// ��Ʒչʾ
	public void doProShow(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Product> list = psi.proShow();
		request.setAttribute("proList", list);
		request.getRequestDispatcher("admin/manageProduct.jsp").forward(
				request, response);
		out.close();
	}

	// ��Ʒɾ��
	public void doProDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int pro_id = Integer.parseInt(request.getParameter("pro_id"));
		boolean flag = psi.proDelete(pro_id);
		if (flag == true) {
			request.getRequestDispatcher("zcProServlet?method=showPage&pageNo=1").forward(
					request, response);
		} else {
			out.print("ɾ��ʧ��!");
		}
		out.close();
	}

	// �޸���Ʒǰ��ֵ������
	public void doProUpdateForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ص����޸�ǰ�ı��
		int pro_id = Integer.parseInt(request.getParameter("pro_id"));
		// �����޸�ǰ����Ϣ������
		Product pro = psi.proUpdateForm(pro_id);
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("admin/updateProduct.jsp").forward(
				request, response);

	}

	// ���ݷ�ҳ����ʾ����
	public void doProShowPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pageNo = pageNo = Integer.parseInt(request.getParameter("pageNo"));
		// ����ÿҳ��ʾ��������
		PageUtil page = psi.getPage(pageNo, 5);
		page.setPageNo(pageNo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("admin/manageProduct.jsp").forward(
				request, response);
		;
	}

	// ʹ��commons.fileupload��commons.io��ʵ���ϴ�ͼƬ�������Ʒ������ʹ��ʱҪ��form���������enctype="multipart/form-data"
	public void doProAddWithFile(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// DiskFileItemFactory FileItem ����Ĺ���,�����趨��������С�ʹ����ʱ�ļ�Ŀ¼
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// �����ڴ滺�����Ĵ�СΪ11k
		factory.setSizeThreshold(11 * 1024);
		// ָ�������ϴ��ļ�����ʱ�ļ���,�Լ�����
		File f = new File("F://tempDirectory");
		// setRepository�����������õ��ϴ��ļ��ߴ����setSizeThreshold�������õ��ٽ�ֵʱ�����ļ�����ʱ�ļ���ʽ�����ڴ����ϵĴ��Ŀ¼��
		factory.setRepository(f);
		// ����ServletFileUpload��ʵ��
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("UTF-8");
		// ���õ����ϴ��ļ������ֵΪ6M,���������ֽ�Ϊ��λ
		sfu.setFileSizeMax(6000 * 1024);
		try {
			// �õ����е�������(ÿ���ؼ�)�ļ���
			List<FileItem> items = sfu.parseRequest(request);
			// ����һ��product����
			Product pro = new Product();
			for (FileItem fileItem : items) {
				// isFormField()Ϊtrue��ʾ��ǰ�ؼ�����ͨ�ؼ���Ϊfalse��ʾ�����ϴ��ؼ�
				if (fileItem.isFormField()) {
					// ��ȡ�ؼ������ƣ���ÿ���������������
					String name = fileItem.getFieldName();
					// ��ȡ�ؼ���ֵ����UTF-8��ֹ��������
					String value = fileItem.getString("UTF-8");
					// �Կؼ�����������������жϣ����η�װ��һ��Product�����������
					if (name.equals("serialNumber")) {
						pro.setPro_id(Integer.parseInt(value));
					} else if (name.equals("name")) {
						pro.setPro_name(value);
					} else if (name.equals("brand")) {
						pro.setPro_brand(value);
					} else if (name.equals("model")) {
						pro.setPro_version(value);
					} else if (name.equals("price")) {
						pro.setPro_price(Long.parseLong(value));
					} else if (name.equals("description")) {
						pro.setPro_introduce(value);
					}
				} else {
					// �����ϴ��ļ�������
					// ��ȡ�ϴ��ļ�������
					String fileName = fileItem.getName();
					// ��ȡ�ϴ��ļ����ļ�����
					String contentType = fileItem.getContentType();
					// ��ȡ�ϴ��ļ��Ĵ�С
					long size = fileItem.getSize();
					// ��ȡ��ǰwebӦ�ø�Ŀ¼�ľ���·��(Tomcat���������𹤳̵ľ���·��)
					String path = this.getServletContext().getRealPath("/");
					// ��ȡ�����ϴ��ļ���ȫ·��
					String filePath = path + "images/" + fileName;
					// ��ȡ��װ���ϴ��ļ����ݵ�������
					InputStream is = fileItem.getInputStream();
					// �����
					OutputStream os = new FileOutputStream(filePath);
					// ����ļ�
					int len = 0;
					byte[] b = new byte[1024];
					while ((len = is.read(b)) != -1) {
						os.write(b, 0, len);
					}
					// �ر���
					os.close();
					is.close();
					// �ϴ��ɹ���,ɾ����ʱ�ļ�
					fileItem.delete();
					// ����ͼƬ��������·��,����Ҫ�浽���ݿ��е�
					pro.setPro_image("images/" + fileName);
				}
			}
			//����ҵ�����������Ʒ�ķ���
			boolean flag = psi.proAddWithFile(pro);
			if (flag == true) {
				request.getRequestDispatcher("zcProServlet?method=showPage&pageNo=1").forward(
						request, response);
			} else {
				out.print("�����Ʒʧ��");
			}

			out.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
