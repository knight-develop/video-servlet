package com.webvideo.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.webvideo.dao.FavoriteDAO;
import com.webvideo.dao.ShareDAO;
import com.webvideo.dao.VideoDAO;
import com.webvideo.model.Video;
import com.webvideo.utils.UploadUtils;

/**
 * Servlet implementation class CRUDVideoController
 */
@WebServlet(urlPatterns = {"/admin/video","/admin/video/create","/admin/video/delete","/admin/video/update","/admin/video/edit/*","/admin/video/reset"})
public class CRUDVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoDAO viDAO = new VideoDAO();
	FavoriteDAO faDAO = new FavoriteDAO();
	ShareDAO shDAO = new ShareDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDVideoController() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/admin/video/create": {
				create(request, response);
				break;
			}
			case "/admin/video/update": {
				update(request, response);
				break;
			}
			case "/admin/video/edit": {
				edit(request,response);
				break;
			}
			case "/admin/video/delete": {
				delete(request, response);
				break;
			}
			case "/admin/video/reset": {
				reset(request, response);
				break;
			}
			default:
				listVideo(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Video video = new Video();
		video.setPoster("images/desktop.png");
		request.setAttribute("video", video);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/admin/video/create": {
				create(request, response);
				break;
			}
			case "/admin/video/update": {
				update(request, response);
				break;
			}
			case "/admin/video/edit": {
				
				break;
			}
			case "/admin/video/delete": {
				delete(request, response);
				break;
			}
			case "/admin/video/reset": {
				reset(request, response);
				break;
			}
			default:
				listVideo(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Video video = viDAO.findByID(id);
		req.setAttribute("video", video);
		req.setAttribute("read", "readonly");
		req.setAttribute("reset", 1);
		List<Video> listVi = viDAO.getAllVideo();
		req.setAttribute("listVi", listVi);
		req.getRequestDispatcher("/view/admin/view/video-form.jsp").forward(req, resp);
	}
	private void listVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Video> listVi = viDAO.getAllVideo();
		req.setAttribute("listVi", listVi);
		req.getRequestDispatcher("/view/admin/view/video-form.jsp").forward(req, resp);
	}
	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();
		video.setPoster("images/desktop.png");
		List<Video> listVi = viDAO.getAllVideo();
		req.setAttribute("listVi", listVi);
		req.setAttribute("read", "");
		req.setAttribute("reset", 0);
		req.setAttribute("video", video);
		req.getRequestDispatcher("/view/admin/view/video-form.jsp").forward(req, resp);
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String id = req.getParameter("id");
		faDAO.deleteVideoFavorite(id);
		shDAO.deleteVideoFavorite(id);
		if(viDAO.delete(id)) {
			System.out.println("ok");
		}else {
			System.out.println("lỗi");
		}
		List<Video> listVi = viDAO.getAllVideo();
		req.setAttribute("listVi", listVi);
		req.getRequestDispatcher("/view/admin/view/video-form.jsp").forward(req, resp);
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();
		
		try {
			BeanUtils.populate(video, req.getParameterMap());
			video.setPoster(UploadUtils.processUploadFile("cover", req, "/uploads", video.getId()));
			viDAO.update(video);
			req.setAttribute("video", video);
			
			req.setAttribute("message", "Video is inserted");
		} catch (Exception e) {
			req.setAttribute("message", "Video is not inserted");
		}
		List<Video> listVi = viDAO.getAllVideo();
		req.setAttribute("listVi", listVi);
		req.getRequestDispatcher("/view/admin/view/video-form.jsp").forward(req, resp);	
	}
	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, req.getParameterMap());
			
			video.setPoster(UploadUtils.processUploadFile("cover", req, "/uploads", video.getId()));
			viDAO.create(video);
			req.setAttribute("video", video);
			req.setAttribute("message", "Video is inserted");
		} catch (Exception e) {
			req.setAttribute("message", "Video is not inserted");
		}
		List<Video> listVi = viDAO.getAllVideo();
		req.setAttribute("listVi", listVi);
		req.getRequestDispatcher("/view/admin/view/video-form.jsp").forward(req, resp);
	}
}
