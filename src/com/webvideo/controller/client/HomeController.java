package com.webvideo.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webvideo.dao.FavoriteDAO;
import com.webvideo.dao.VideoDAO;
import com.webvideo.model.Favorite;
import com.webvideo.model.User;
import com.webvideo.model.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoDAO viDAO = new VideoDAO();
	FavoriteDAO faDAO = new FavoriteDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if(us != null) {
			List<Favorite> list = faDAO.getFabyUID(us.getId());
			request.setAttribute("listFa", list);
		}	
		String spageid = request.getParameter("page");
		int pageid=1;
		if(spageid != null) {
			pageid = Integer.parseInt(spageid);
		}
		long count = viDAO.countVideo();
		int pagesite = 6;
		int endpage = (int) Math.ceil(count/pagesite);
		if(count%pagesite != 0 ) {
			endpage++;
		}
		request.setAttribute("endpage", endpage);
		List<Video> listVi = viDAO.getVideoForPageIndex(pagesite, pageid);
		request.setAttribute("listVi", listVi);
		request.getRequestDispatcher("/view/client/view/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if(us != null) {
			List<Favorite> list = faDAO.getFabyUID(us.getId());
			request.setAttribute("listFa", list);
		}
		List<Video> listVi = viDAO.getAllVideo();
		request.setAttribute("listVi", listVi);
		request.getRequestDispatcher("/view/client/view/home.jsp").forward(request, response);
	}
	public void pagination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
