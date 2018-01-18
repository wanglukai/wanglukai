package org.hn.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hn.Dao.AuctionDaoimpl;

public class AuctionDeleteServlet extends HttpServlet {
	
	private AuctionDaoimpl auctiondao = new AuctionDaoimpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		auctiondao.delete(id);
		response.sendRedirect("AuctionServlet");
		
	}

}
