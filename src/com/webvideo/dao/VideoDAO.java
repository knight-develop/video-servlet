package com.webvideo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.webvideo.model.Video;
import com.webvideo.utils.JPAUtil;

public class VideoDAO {
	private EntityManager em = JPAUtil.getEntityManager();

	@SuppressWarnings("finally")
	public List<Video> getAllVideo() {
		List<Video> list = new ArrayList<Video>();
		try {
			String jpql = "Select o from Video o";
			em.getTransaction().begin(); // bắt đầu Transaction
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			list = query.getResultList();
			em.getTransaction().commit();// Chấp nhận kế quả thao tác
		} catch (Exception e) {
			em.getTransaction().rollback();// kết thúc transaction
			System.out.println(e.toString());
		} finally {
			return list;
		}
	}

	public boolean create(Video video) {
		boolean result = false;
		try {
			em.getTransaction().begin();
			em.persist(video);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			// TODO: handle exception
		}
		return result;
	}

	public boolean update(Video video) {
		boolean result = false;
		try {
			em.getTransaction().begin();
			em.merge(video);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			// TODO: handle exception
		}
		return result;
	}

	public boolean delete(String id) {
		boolean result = false;
		try {
			Video video = this.findByID(id);
			em.getTransaction().begin();
			em.remove(video);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			// TODO: handle exception
		}
		return result;
	}

	public Video findByID(String id) {
		Video video = em.find(Video.class, id);
		return video;
	}
	public List<Video> getVideoFavoriteByUID(String id){
		String jpql = "select o.video from Favorite o where o.user.id =:uid";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		query.setParameter("uid", id);
		List<Video> list = query.getResultList();
		return list;
	}
	public List<Video> getVideoForPageIndex(int pagesite, int pageid){
		List<Video> list = new ArrayList<>();
		String jpql = "Select v from Video v";
		TypedQuery<Video> query = em.createQuery(jpql,Video.class );
		query.setFirstResult(pageid);
		query.setMaxResults(pagesite);
		list = query.getResultList();
		return list;
	}
	public long countVideo() {
		String jpql = "select count(v.id) from Video v";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		Long count = query.getSingleResult();
		return count;
	}
	public static void main(String[] args) {
		System.out.println(new VideoDAO().countVideo());
	}
}
