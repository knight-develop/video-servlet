package com.webvideo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.webvideo.model.Share;
import com.webvideo.utils.JPAUtil;

public class ShareDAO {
	EntityManager em = JPAUtil.getEntityManager();
	public void insert(Share share) {
		try {
			em.getTransaction().begin();
			em.persist(share);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			// TODO: handle exception
		}
	}
	public void deleteVideoFavorite(String vid) {
		String jpql = "select o from Share o where o.video.id =:vid";
		try {
			TypedQuery<Share> query = em.createQuery(jpql, Share.class);
			query.setParameter("vid", vid);
			List<Share> share = query.getResultList();
			if (share == null) {
				return;
			} else {
				em.getTransaction().begin();
				em.remove(share);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
