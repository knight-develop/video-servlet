package com.webvideo.controller.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.webvideo.dao.UserDAO;
import com.webvideo.model.User;

/**
 * Servlet implementation class EditProfileController
 */
@WebServlet("/edit-profile")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDAO usDAO = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		request.setAttribute("user", us);
		request.getRequestDispatcher("/view/client/view/edit-profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		HttpSession session = request.getSession();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			if(usDAO.update(user)) {
				request.setAttribute("user", user);
				session.setAttribute("user", user);
				request.setAttribute("message", "Edit profile sucessful");
			}else {
				request.setAttribute("message", "Invalid Edit profile");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/view/client/view/edit-profile.jsp").forward(request, response);
	}

}
