package org.hn.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hn.Dao.AuctionDaoimpl;
import org.hn.Dao.UserDao;
import org.hn.Dao.UserDaoImpl;
import org.hn.Service.UserService;
import org.hn.entity.Auction;
import org.hn.entity.User;
import org.hn.util.PageBean;

public class UserServlet extends HttpServlet {
	private UserService userservice = new UserService();
	private AuctionDaoimpl auctiondao = new AuctionDaoimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userservice.Login(username, password);
		
		if(user!=null){
			PageBean pb = new PageBean();
			pb.setTotalCount(auctiondao.getListCount());
			session.setAttribute("pb", pb);
			List<Auction> alist = auctiondao.getByPage(pb.getPageSize(),pb.getCurrentPage());
			
			request.setAttribute("alist", alist);
			request.getRequestDispatcher("auctionList.jsp").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}

}
