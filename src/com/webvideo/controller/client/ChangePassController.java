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
 * Servlet implementation class ChangePassController
 */
@WebServlet("/change-password")
public class ChangePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDAO usDAO = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/client/view/ChangePass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("id");
		String currentPass = request.getParameter("current-pass");
		String newPass = request.getParameter("new-pass");
		String confirm = request.getParameter("confirm");
		User us = usDAO.findByID(username);

		if(us != null && us.getPassword().equalsIgnoreCase(currentPass)) {
			if(newPass.equalsIgnoreCase(confirm)) {
				us.setPassword(newPass);
				usDAO.update(us);
				request.setAttribute("message", "Change Password Sucessful");
				HttpSession session =  request.getSession();
				session.setAttribute("user", us);
			}else {
				request.setAttribute("message", "Invalid Confirm Password");
				
			}
		}else {
			request.setAttribute("message", "Invalid Username or Current Pass ");
		}
		request.getRequestDispatcher("/view/client/view/ChangePass.jsp").forward(request, response);
	}

}
