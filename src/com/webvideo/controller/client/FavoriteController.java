package com.webvideo.controller.client;

import java.io.IOException;
import java.util.Date;
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
 * Servlet implementation class FavoriteController
 */
@WebServlet(urlPatterns = { "/favorite", "/favorite/like/*", "/favorite/unlike/*" })
public class FavoriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoriteDAO faDAO = new FavoriteDAO();
	VideoDAO viDAO = new VideoDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavoriteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/favorite/like":
			like(request, response);
			break;
		case "/favorite/unlike":
			unlike(request, response);
			break;
		default:
			listVideo(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/favorite/like":
			like(request, response);
			break;
		case "/favorite/unlike":
			unlike(request, response);
			break;
		}
	}

	private void unlike(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String videoID = req.getParameter("vid");
		try {
			faDAO.delete(user.getId(), videoID);
			resp.sendRedirect("/ASSJV4/home");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void like(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			resp.sendRedirect("/ASSJV4/login");
			return;
		}
		String videoID = req.getParameter("vid");
		if (videoID == null) {
			resp.sendRedirect("/ASSJV4/home");
			return;
		}
		try {
			Favorite fa = new Favorite();
			Video video = viDAO.findByID(videoID);
			fa.setUser(user);
			fa.setVideo(video);
			fa.setLikeDate(new Date());
			if (faDAO.insert(fa)) {
				req.setAttribute("message", "Unlike");
			}
			resp.sendRedirect("/ASSJV4/home");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void listVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			resp.sendRedirect("/ASSJV4/login");
			return;
		}
		List<Video> listVi = viDAO.getVideoFavoriteByUID(user.getId());
		req.setAttribute("listVi", listVi);
		req.getRequestDispatcher("/view/client/view/favorite.jsp").forward(req, resp);
	}
}
