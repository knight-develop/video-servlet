package com.webvideo.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.webvideo.dao.UserDAO;
import com.webvideo.model.User;
import com.webvideo.model.Video;
import com.webvideo.utils.UploadUtils;

/**
 * Servlet implementation class CRUDUserController
 */
@WebServlet(urlPatterns = { "/admin/user", "/admin/user/delete", "/admin/user/update", "/admin/user/edit/*",
		"/admin/user/reset" })
public class CRUDUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO usDAO = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDUserController() {
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
		try {
			switch (action) {
			case "/admin/user/update": {
				update(request, response);
				break;
			}
			case "/admin/user/edit": {
				edit(request, response);
				break;
			}
			case "/admin/user/delete": {
				delete(request, response);
				break;
			}
			case "/admin/user/reset": {
				reset(request, response);
				break;
			}
			default:
				listUser(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		User user = new User();
		request.setAttribute("user", user);
		System.out.println(user.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUs = usDAO.findALL();
		request.setAttribute("listUs", listUs);
		request.getRequestDispatcher("/view/admin/view/user-form.jsp").forward(request, response);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User us = new User();
		List<User> listUs = usDAO.findALL();
		request.setAttribute("listUs", listUs);
		request.setAttribute("read", "");
		request.setAttribute("reset", 0);
		request.setAttribute("user", us);
		request.getRequestDispatcher("/view/admin/view/user-form.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (usDAO.delete(id)) {
			request.setAttribute("message", "User is inserted");
		} else {
			request.setAttribute("message", "User is not inserted");
		}
		List<User> listUs = usDAO.findALL();
		request.setAttribute("listUs", listUs);
		request.getRequestDispatcher("/view/admin/view/user-form.jsp").forward(request, response);

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User us = usDAO.findByID(id);
		request.setAttribute("user", us);
		request.setAttribute("read", "readonly");
		request.setAttribute("reset", 1);
		List<User> listUs = usDAO.findALL();
		request.setAttribute("listUs", listUs);
		request.getRequestDispatcher("/view/admin/view/user-form.jsp").forward(request, response);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User us = new User();
		try {
			BeanUtils.populate(us, request.getParameterMap());
			if (usDAO.update(us)) {
				request.setAttribute("user", us);
				request.setAttribute("message", "User is inserted");
			} else {
				request.setAttribute("message", "User is not inserted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<User> listUs = usDAO.findALL();
		request.setAttribute("listUs", listUs);
		request.getRequestDispatcher("/view/admin/view/user-form.jsp").forward(request, response);

	}

}
