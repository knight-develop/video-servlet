package com.webvideo.utils;

import java.util.Date;

public class FavoriteVideoReport {
	private String videoTitle;
	private long favoriteCount;
	private Date newestDate;
	private Date oldestDate;
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public long getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public Date getNewestDate() {
		return newestDate;
	}
	public void setNewestDate(Date newestDate) {
		this.newestDate = newestDate;
	}
	public Date getOldestDate() {
		return oldestDate;
	}
	public void setOldestDate(Date oldestDate) {
		this.oldestDate = oldestDate;
	}
	public FavoriteVideoReport(String videoTitle, long favoriteCount, Date newestDate, Date oldestDate) {
		super();
		this.videoTitle = videoTitle;
		this.favoriteCount = favoriteCount;
		this.newestDate = newestDate;
		this.oldestDate = oldestDate;
	}
	public FavoriteVideoReport() {
		// TODO Auto-generated constructor stub
	}
}
