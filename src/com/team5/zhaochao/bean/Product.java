package com.team5.zhaochao.bean;

/**
 * ��Ʒ��bean��
 * @author superzhao
 *
 */
public class Product {
   private int pro_id;  //��Ʒ���
   private String pro_name; //��Ʒ��
   private String pro_brand; //��ƷƷ��
   private String pro_version;//��Ʒ�ͺ�
   private long pro_price;  //��Ʒ�۸�
   private String pro_image;//��ƷͼƬ��·��
   private String pro_introduce;//��Ʒ�Ľ���
   
   //���캯��
   public Product() {

   }
   
   
   public Product(int pro_id, String pro_name, String pro_brand,
		String pro_version, long pro_price, String pro_image,
		String pro_introduce) {
	this.pro_id = pro_id;
	this.pro_name = pro_name;
	this.pro_brand = pro_brand;
	this.pro_version = pro_version;
	this.pro_price = pro_price;
	this.pro_image = pro_image;
	this.pro_introduce = pro_introduce;
}


//get��set����
public int getPro_id() {
	return pro_id;
}
public void setPro_id(int pro_id) {
	this.pro_id = pro_id;
}
public String getPro_name() {
	return pro_name;
}
public void setPro_name(String pro_name) {
	this.pro_name = pro_name;
}
public String getPro_brand() {
	return pro_brand;
}
public void setPro_brand(String pro_brand) {
	this.pro_brand = pro_brand;
}
public String getPro_version() {
	return pro_version;
}
public void setPro_version(String pro_version) {
	this.pro_version = pro_version;
}
public long getPro_price() {
	return pro_price;
}
public void setPro_price(long pro_price) {
	this.pro_price = pro_price;
}
public String getPro_image() {
	return pro_image;
}
public void setPro_image(String pro_image) {
	this.pro_image = pro_image;
}
public String getPro_introduce() {
	return pro_introduce;
}
public void setPro_introduce(String pro_introduce) {
	this.pro_introduce = pro_introduce;
}
   
}
