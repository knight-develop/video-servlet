package com.webvideo.controller.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webvideo.dao.UserDAO;
import com.webvideo.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO  usDAO = new UserDAO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("user");
		}
		request.getRequestDispatcher("/view/client/view/login.jsp").forward(request, response);
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");

		User us = usDAO.checkLogin(id, pass);
		if (us != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", us);
			if (us.getAdmin()) {
				response.sendRedirect("/ASSJV4/admin");
			} else {
				response.sendRedirect("/ASSJV4/home");
			}
		} else {
			request.setAttribute("message", "Invalid Username or password ");
			request.getRequestDispatcher("/view/client/view/login.jsp").forward(request, response);
		}
	}

}
