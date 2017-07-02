package com.ankit.api.model;

public class News {

	Long id;
	String newsDate;
	String title;
	String imgURL;
	String excerpt;

	public News(Long id, String newsDate, String title, String imgURL, String excerpt) {
		this.id = id;
		this.newsDate = newsDate;
		this.title = title;
		this.imgURL = imgURL;
		this.excerpt = excerpt;
	}

	@Override
	public String toString() {
		return "newsList {" + "title='" + title + '\'' + ", excerpt='" + excerpt + '\'' + ", pubDate='" + newsDate
				+ '\'' + '}';
	}

	public News() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public String getTitle() {
		return title;
	}

	public String getExcerpt() {
		return excerpt;
	}

}
