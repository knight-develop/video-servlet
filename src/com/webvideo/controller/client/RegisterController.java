package com.webvideo.controller.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.webvideo.dao.UserDAO;
import com.webvideo.model.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO usDAO = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/client/view/login.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User us = new User();
			BeanUtils.populate(us, request.getParameterMap());
			if(usDAO.create(us)) {
				response.sendRedirect("/Assignment/login");
				System.out.println("Dang ki thanh cong");
			}else {
				System.out.println("Dang ki that bai");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}
