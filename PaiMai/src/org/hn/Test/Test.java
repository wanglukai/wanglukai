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
//  		u.setName("凯哥");
//  		u.setPassword("123456");
//  		u.setPhone("18303051935");
//  		u.setAddress("河北邯郸");
//  		u.setPostNumber("123456");
//  		u.setIdCard("130429199911175237");
//  		u.setIdAdmin(0);
//  		session.save(u);
//  		tx.commit();
		
//		Session session = org.hn.util.HibernateSessionFactory.getSession();
//    	Transaction tx = session.beginTransaction();
//    	org.hn.entity.Auction auction = new org.hn.entity.Auction();
//    	auction.setId(6);
//    	auction.setesc("青花瓷6");
//    	auction.setName("青花瓷夜壶6");
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
		
	    //byte类型所占的字节数求法
//        System.out.println("byte的二进制位数为：" + Byte.SIZE);
//        System.out.println("byte所占的字节数为：" + Byte.SIZE/8);     //一个字节占8个二进制位     
//        //short类型所占的字节数求法
//        System.out.println("short的二进制位数为：" + Short.SIZE);
//        System.out.println("short所占的字节数为：" + Short.SIZE/8);
//        //int类型所占的字节数求法
//        System.out.println("int的二进制位数为：" + Integer.SIZE);
//        System.out.println("int所占的字节数为：" + Integer.SIZE/8);
//        //long类型所占的字节数求法
//        System.out.println("long的二进制位数为：" + Long.SIZE);
//        System.out.println("long所占的字节数为：" + Long.SIZE/8);
//        //float类型所占的字节数求法
//        System.out.println("float的二进制位数为：" + Float.SIZE);
//        System.out.println("float所占的字节数为：" + Float.SIZE/8);
//        //double类型所占的字节数求法
//        System.out.println("double的二进制位数为：" + Double.SIZE);
//        System.out.println("double所占的字节数为：" + Double.SIZE/8);
//        //char类型所占的字节数求法
//        System.out.println("char的二进制位数为：" + Character.SIZE);
//        System.out.println("char所占的字节数为：" + Character.SIZE/8);
		
	}
}	
