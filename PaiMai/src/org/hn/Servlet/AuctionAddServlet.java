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
		 System.out.println(request.getParameter("name")+"时间");
		//commons-upload实现文件上传, 数据来源页面：auctionAdd.jsp
	  String uploadFileName="";
	  String fieldName = "";
		//请求信息中的内容是否是multipart类型
	  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		//上传文件的存储路径（服务器文件系统上的绝对文件路径）
	  String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
	 
	  File fullFile = null;
	  String fileType = null;
	  Auction auction = new Auction();
	  
	  if(isMultipart){
		  FileItemFactory factory = new DiskFileItemFactory();
		  ServletFileUpload  upload = new ServletFileUpload(factory);
		  
		  //解析form表单中所有文件
		  List<FileItem> items = null;
		  try{
		  items = upload.parseRequest(request);
		  }catch (FileUploadException e1){
			  e1.printStackTrace();
		  }
		  Iterator<FileItem> iter = items.iterator();
		  while(iter.hasNext()){//依次处理每个文件
			  FileItem item = (FileItem) iter.next();
			  if(item.isFormField()){//普通表单字段
				  fieldName = item.getFieldName();//表单字段的name属性值
				  String value = item.getString("UTF-8");
				  //获取表单字段的值
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
			  }else{//文件表单字段
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
					  System.out.println("上传成功后的文件名是："+uploadFileName);
				  }
			  }
		  }
		  
	  }
	  InputStream is = new FileInputStream(uploadFilePath+fullFile);
	  byte[] byteArray = new byte[is.available()];
	  is.read(byteArray);
	  is.close();
	  //设置图片数据
	  auction.setPic(byteArray);
	  //设置图片类型
	  auction.setPicType(fileType);
	  auction.setUpset(1000.0);
	  AuctionDaoimpl auctionDao = new AuctionDaoimpl();
	  auctionDao.add(auction);
	  response.sendRedirect("AuctionServlet");
	}

}
