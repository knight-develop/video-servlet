package com.webvideo.controller.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webvideo.dao.ShareDAO;
import com.webvideo.model.Share;
import com.webvideo.model.User;
import com.webvideo.model.Video;
import com.webvideo.utils.SendMail;

/**
 * Servlet implementation class ShareController
 */
@WebServlet("/share")
public class ShareController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoID = request.getParameter("vid");
		if(videoID == null) {
			System.out.println("123");
			response.sendRedirect("/ASSJV4/home");
			return;
		}
		request.setAttribute("videoID", videoID);
		request.getRequestDispatcher("/view/client/view/share.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoID = request.getParameter("videoID");
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		try {
			if(videoID == null) {
				request.setAttribute("message", "video id is null");
			}else {
				String to = request.getParameter("email");
				String subject = "Dear Mr./Ms";
				String msg = "The video is more interesting and i want to share with you   <br/>"
						+ "Please click the link<br/>"
						+ "<a href =\"<%=Reqest.getContexPath()%>/details/${videoID}\">View video</a>"+"Regard <br/>"
								+ "Adminnistator";
				SendMail.send(to, subject, msg);
				ShareDAO shDAO = new ShareDAO();
				Share share = new Share();
				share.setEmails(to);
				share.setShareDate(new Date());
				
				
				share.setUser(us);
				Video video = new Video();
				video.setId(videoID);
				share.setVideo(video);
				shDAO.insert(share);
				request.setAttribute("message", "Video link has been sent");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Error");
		}
		request.getRequestDispatcher("/view/client/view/share.jsp").forward(request, response);;	
	}

}
