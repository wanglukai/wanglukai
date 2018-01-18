package org.hn.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hn.entity.Auction;
import org.hn.Dao.AuctionDaoimpl;

public class imgServlet extends HttpServlet {
	private AuctionDaoimpl auctiondao = new AuctionDaoimpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 int id = Integer.parseInt(request.getParameter("id"));
		  Auction a = auctiondao.getOne(id);
		ServletOutputStream fos = response.getOutputStream();//这是啥意思？
		fos.write(a.getPic());
	}

}
