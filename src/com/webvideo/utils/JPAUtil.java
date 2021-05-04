package com.webvideo.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf;
	public static EntityManager getEntityManager() {
		if(emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("ASSJV4");
		}
		return emf.createEntityManager();
	}
	public static void close() {
		if(emf.isOpen()) {
			emf.close();
		}
	}
}
