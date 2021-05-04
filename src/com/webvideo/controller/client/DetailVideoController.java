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
 * Servlet implementation class DetailVideoController
 */
@WebServlet("/details/*")
public class DetailVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	VideoDAO viDAO = new VideoDAO();
	FavoriteDAO faDAO = new FavoriteDAO();
    public DetailVideoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vid = request.getParameter("id");
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		Video videoDetails = viDAO.findByID(vid);
		int view = videoDetails.getViews();
		videoDetails.setViews(view++);
		viDAO.update(videoDetails);
		List<Video> listV = viDAO.getAllVideo();
		if(us != null) {
			List<Favorite> list = faDAO.getFabyUID(us.getId());
			request.setAttribute("listFa", list);
		}
		request.setAttribute("vDetail", videoDetails);
		request.setAttribute("listV", listV);
		request.getRequestDispatcher("/view/client/view/details.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
