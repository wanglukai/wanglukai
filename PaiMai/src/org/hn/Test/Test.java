package org.hn.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hn.entity.User;


public class Test {
	public static void main(String[] args) throws IOException {
//	 Configuration cfg = new Configuration().configure();
//     SchemaExport export = new SchemaExport(cfg);
//      export.create(true,true);
//      
//      	Session session = org.hn.util.HibernateSessionFactory.getSession();
//  		Transaction tx = session.beginTransaction();
//  		User u = new User();
//  		
//  		u.setName("����");
//  		u.setPassword("123456");
//  		u.setPhone("18303051935");
//  		u.setAddress("�ӱ�����");
//  		u.setPostNumber("123456");
//  		u.setIdCard("130429199911175237");
//  		u.setIdAdmin(0);
//  		session.save(u);
//  		tx.commit();
		
//		Session session = org.hn.util.HibernateSessionFactory.getSession();
//    	Transaction tx = session.beginTransaction();
//    	org.hn.entity.Auction auction = new org.hn.entity.Auction();
//    	auction.setId(6);
//    	auction.setesc("�໨��6");
//    	auction.setName("�໨��ҹ��6");
//    	auction.setEndTime(new Date());
//    	auction.setStartTime(new Date());
//    	auction.setUpset(100000d);
//    	auction.setStartPrice(100000d);
//    	FileInputStream fis = new FileInputStream("C:\\db\\742_7.jpg");
//    	byte[] bytes = new byte[fis.available()];
//    	fis.read(bytes);
//    	auction.setPic(bytes);
//    	auction.setPicType(".jpg");
//    	session.save(auction);
//    	tx.commit();
		
	    //byte������ռ���ֽ�����
//        System.out.println("byte�Ķ�����λ��Ϊ��" + Byte.SIZE);
//        System.out.println("byte��ռ���ֽ���Ϊ��" + Byte.SIZE/8);     //һ���ֽ�ռ8��������λ     
//        //short������ռ���ֽ�����
//        System.out.println("short�Ķ�����λ��Ϊ��" + Short.SIZE);
//        System.out.println("short��ռ���ֽ���Ϊ��" + Short.SIZE/8);
//        //int������ռ���ֽ�����
//        System.out.println("int�Ķ�����λ��Ϊ��" + Integer.SIZE);
//        System.out.println("int��ռ���ֽ���Ϊ��" + Integer.SIZE/8);
//        //long������ռ���ֽ�����
//        System.out.println("long�Ķ�����λ��Ϊ��" + Long.SIZE);
//        System.out.println("long��ռ���ֽ���Ϊ��" + Long.SIZE/8);
//        //float������ռ���ֽ�����
//        System.out.println("float�Ķ�����λ��Ϊ��" + Float.SIZE);
//        System.out.println("float��ռ���ֽ���Ϊ��" + Float.SIZE/8);
//        //double������ռ���ֽ�����
//        System.out.println("double�Ķ�����λ��Ϊ��" + Double.SIZE);
//        System.out.println("double��ռ���ֽ���Ϊ��" + Double.SIZE/8);
//        //char������ռ���ֽ�����
//        System.out.println("char�Ķ�����λ��Ϊ��" + Character.SIZE);
//        System.out.println("char��ռ���ֽ���Ϊ��" + Character.SIZE/8);
		
	}
}	
