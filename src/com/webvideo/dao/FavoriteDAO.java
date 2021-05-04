package com.webvideo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.webvideo.model.Favorite;
import com.webvideo.model.User;
import com.webvideo.model.Video;
import com.webvideo.utils.JPAUtil;
import com.webvideo.utils.FavoriteVideoReport;
import com.webvideo.utils.FavoriteUserReport;

public class FavoriteDAO {
	static EntityManager em = JPAUtil.getEntityManager();

	public boolean insert(Favorite fa) {
		boolean result = false;
		try {
			em.getTransaction().begin();
			em.persist(fa);
			result = true;
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		return result;
	}

	public void delete(String uid, String vid) {
		String jpql = "select o from Favorite o where o.video.id =:vid and o.user.id =:uid";

		try {
			TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
			query.setParameter("vid", vid);
			query.setParameter("uid", uid);
			Favorite fa = query.getSingleResult();
			if (fa == null) {
				return;
			} else {
				em.getTransaction().begin();
				em.remove(fa);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public List<Favorite> getFabyUID(String id) {
		List<Favorite> list = em.find(User.class, id).getFavorites();
		return list;
	}

	public void deleteVideoFavorite(String vid) {
		String jpql = "select o from Favorite o where o.video.id =:vid";
		try {
			TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
			query.setParameter("vid", vid);
			List<Favorite> fa = query.getResultList();
			if (fa == null) {
				return;
			} else {
				em.getTransaction().begin();
				em.remove(fa);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	public List<FavoriteVideoReport> reportFavoriteByVideo(){
		String jpql = "select new com.webvideo.utils.FavoriteVideoReport(f.video.title, count(f), min(f.likeDate), max(f.likeDate) ) from Favorite f group by f.video.title";
		List<FavoriteVideoReport> list = new ArrayList<FavoriteVideoReport>();
		try {
			TypedQuery<FavoriteVideoReport> query = em.createQuery(jpql, FavoriteVideoReport.class);
			 list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<FavoriteUserReport> reportFavoriteUser(String vid){
		String jpql = "select new com.webvideo.utils.FavoriteUserReport(f.user.id, f.user.fullName, "
				+ "f.user.email, f.likeDate) from Favorite f where f.video.id =:vid";
		TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class);
		query.setParameter("vid", vid);
		List<FavoriteUserReport> list = query.getResultList();
		return list;
	}
}
