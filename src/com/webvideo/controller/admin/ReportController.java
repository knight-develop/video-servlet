package com.webvideo.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webvideo.dao.FavoriteDAO;
import com.webvideo.dao.VideoDAO;
import com.webvideo.model.Video;
import com.webvideo.utils.FavoriteUserReport;
import com.webvideo.utils.FavoriteVideoReport;

/**
 * Servlet implementation class ReportController
 */
@WebServlet("/admin/report")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reportFavorite(request, response);
		reportFavoriteUserByVideo(request, response);
		request.getRequestDispatcher("/view/admin/view/report.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void reportFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavoriteDAO faDAO = new FavoriteDAO();
		try {
			List<FavoriteVideoReport> listFR = faDAO.reportFavoriteByVideo();
			if(listFR == null) {
				return;
			}
			request.setAttribute("listFR", listFR);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void reportFavoriteUserByVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavoriteDAO faDAO = new FavoriteDAO();
		String videoUserId = request.getParameter("videoUserId");
		VideoDAO viDAO = new VideoDAO();
		List<Video> listVI = viDAO.getAllVideo();
		if(videoUserId == null && listVI.size() > 0) {
			videoUserId = listVI.get(0).getId();
		}
		try {
			List<FavoriteUserReport> listFU = faDAO.reportFavoriteUser(videoUserId);
			if(listFU == null) {
				return;
			}
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("listVi", listVI);
			request.setAttribute("listFU", listFU);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
