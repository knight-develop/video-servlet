package com.webvideo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.webvideo.model.User;
import com.webvideo.utils.JPAUtil;

public class UserDAO {
	private EntityManager em = JPAUtil.getEntityManager();

	public boolean create(User us) {
		boolean result = false;
		try {
			em.getTransaction().begin();
			em.persist(us);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			// TODO: handle exception
		}
		return result;
	}

	public boolean update(User us) {
		boolean result = false;
		try {
			em.getTransaction().begin();
			em.merge(us);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(String id) {
		boolean result = false;
		try {
			User us = this.findByID(id);
			em.getTransaction().begin();
			em.remove(us);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			// TODO: handle exception
		}
		return result;
	}

	public User findByID(String id) {
		User us = new User();
		us = em.find(User.class, id);
		return us;
	}
	public User checkLogin(String id, String pass) {
		User us = this.findByID(id);
		if (us != null && us.getPassword().equalsIgnoreCase(pass)) {
			return us;
		}else {
			return null;
		}		
	}
	
	public List<User> findALL(){
		List<User> list = new ArrayList<>();
		String jpql = "Select u from User u";
		TypedQuery<User> query = em.createQuery(jpql,User.class );

		list = query.getResultList();
		return list;
	}

}
