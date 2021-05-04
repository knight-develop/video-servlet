package com.webvideo.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webvideo.model.User;

@WebFilter(filterName = "AdminFilter",urlPatterns =  {"/admin/*"},dispatcherTypes = DispatcherType.REQUEST)
public class AdminFilter implements HttpFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		if(session == null) {
			resp.sendRedirect("/ASSJV4/home");
			return;
		}
		User us = (User) session.getAttribute("user");
		if(us == null) {
			resp.sendRedirect("/ASSJV4/home");
			return;
		}
		boolean isAdmin = us.getAdmin();
		if(us != null) {
			if(isAdmin) {
				chain.doFilter(req, resp);
			}else{
				resp.sendRedirect("/ASSJV4/home");
			}
		}
		
	}

}
