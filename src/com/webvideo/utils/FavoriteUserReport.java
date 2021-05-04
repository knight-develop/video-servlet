package com.webvideo.utils;

import java.util.Date;

public class FavoriteUserReport {
	private String userId;
	private String fullName;
	private String emails;
	private Date likeDate;
	public FavoriteUserReport() {
		// TODO Auto-generated constructor stub
	}
	
	public FavoriteUserReport(String userId, String fullName, String emails, Date likeDate) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.emails = emails;
		this.likeDate = likeDate;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

}
