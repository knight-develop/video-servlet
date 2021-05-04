package com.webvideo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webvideo.model.User;

@WebFilter(urlPatterns = {"/favorite/*,/logoff","/edit-profile","/share"})
public class UserFilter implements HttpFilter{
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		User us = (User) session.getAttribute("user");
		if(us == null) {
			resp.sendRedirect("/ASSJV4/login");
		}else {
			chain.doFilter(req, resp);
		}
	}
}
