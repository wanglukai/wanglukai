package org.hn.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hn.Dao.AuctionDaoimpl;
import org.hn.util.PageBean;


public class AuctionServlet extends HttpServlet {

	private AuctionDaoimpl auctiondao = new AuctionDaoimpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		PageBean pb = (PageBean)session.getAttribute("pb");
		String currentPage = request.getParameter("currentPage");
		if(currentPage != null){
			int curPage = Integer.parseInt(currentPage);
			if(curPage<=0){
				curPage=1;
			}else if(curPage>=pb.getTotalPageCount()){
				curPage = pb.getTotalPageCount();
			}
			pb.setCurrentPage(curPage);
		}
		session.setAttribute("pb",pb);
		List<org.hn.entity.Auction> alist = auctiondao.getByPage(pb.getPageSize(), pb.getCurrentPage());
		request.setAttribute("alist", alist);
		request.getRequestDispatcher("auctionList.jsp").forward(request, response);
		
		
	}

}
