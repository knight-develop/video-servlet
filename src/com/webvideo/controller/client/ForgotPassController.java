package com.webvideo.controller.client;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webvideo.dao.UserDAO;
import com.webvideo.model.User;
import com.webvideo.utils.SendMail;

/**
 * Servlet implementation class ForgotPassController
 */
@WebServlet("/forgot-password")
public class ForgotPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDAO usDAO = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/client/view/Forgot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		if(username == null || email == null) {
			request.setAttribute("message", "Invalid username or emails");
		}
		User us = usDAO.findByID(username);
		if(us == null || !(us.getEmail().equals(email))) {
			request.setAttribute("message", "username or emails is not found");
		}else {
			Random rand = new Random();
			int upperbound = 5000;
			int valueRandom = rand.nextInt(upperbound);
			String to = us.getEmail();
			String subject = "Your new password is "+valueRandom;
			String msg = "";
			SendMail.send(to, subject, msg);
			us.setPassword(String.valueOf(valueRandom));
			usDAO.update(us);
			request.setAttribute("message", "Successful");
		}
		request.getRequestDispatcher("/view/client/view/Forgot.jsp").forward(request, response);
	}

}
