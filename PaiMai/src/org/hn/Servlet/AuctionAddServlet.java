package org.hn.Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hn.Dao.AuctionDaoimpl;
import org.hn.entity.Auction;
import org.hn.util.DateUtil;

public class AuctionAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println(request.getParameter("name")+"ʱ��");
		//commons-uploadʵ���ļ��ϴ�, ������Դҳ�棺auctionAdd.jsp
	  String uploadFileName="";
	  String fieldName = "";
		//������Ϣ�е������Ƿ���multipart����
	  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		//�ϴ��ļ��Ĵ洢·�����������ļ�ϵͳ�ϵľ����ļ�·����
	  String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
	 
	  File fullFile = null;
	  String fileType = null;
	  Auction auction = new Auction();
	  
	  if(isMultipart){
		  FileItemFactory factory = new DiskFileItemFactory();
		  ServletFileUpload  upload = new ServletFileUpload(factory);
		  
		  //����form���������ļ�
		  List<FileItem> items = null;
		  try{
		  items = upload.parseRequest(request);
		  }catch (FileUploadException e1){
			  e1.printStackTrace();
		  }
		  Iterator<FileItem> iter = items.iterator();
		  while(iter.hasNext()){//���δ���ÿ���ļ�
			  FileItem item = (FileItem) iter.next();
			  if(item.isFormField()){//��ͨ���ֶ�
				  fieldName = item.getFieldName();//���ֶε�name����ֵ
				  String value = item.getString("UTF-8");
				  //��ȡ���ֶε�ֵ
				  if(fieldName.equals("name")){
					  auction.setName(value);
				  }
				  if(fieldName.equals("startPrice")){
					  auction.setStartPrice(new Double(value));
				  }
				  if(fieldName.equals("upset")){
					  auction.setUpset(new Double(value));
				  }
				  if(fieldName.equals("startTime")){
					  auction.setStartTime(DateUtil.strToDate(value));
				  }
				  if(fieldName.equals("endTime")){
					  auction.setEndTime(DateUtil.strToDate(value));
				  }
				  if(fieldName.equals("esc")){
					  auction.setesc(value);
				  }
			  }else{//�ļ����ֶ�
				  String fileName = item.getName();
				  if(fileName != null && !fileName.equals("")){
					  fullFile = new File(item.getName());
					  File saveFile = new File(uploadFilePath,fullFile.getName());
					  try{
						  item.write(saveFile);
					  }catch (Exception e ){
						  e.printStackTrace();
					  }
					  uploadFileName = fullFile.getName();
					  fileType = uploadFileName.substring(uploadFileName.lastIndexOf(".")+1);
					  System.out.println("�ϴ��ɹ�����ļ����ǣ�"+uploadFileName);
				  }
			  }
		  }
		  
	  }
	  InputStream is = new FileInputStream(uploadFilePath+fullFile);
	  byte[] byteArray = new byte[is.available()];
	  is.read(byteArray);
	  is.close();
	  //����ͼƬ����
	  auction.setPic(byteArray);
	  //����ͼƬ����
	  auction.setPicType(fileType);
	  auction.setUpset(1000.0);
	  AuctionDaoimpl auctionDao = new AuctionDaoimpl();
	  auctionDao.add(auction);
	  response.sendRedirect("AuctionServlet");
	}

}
