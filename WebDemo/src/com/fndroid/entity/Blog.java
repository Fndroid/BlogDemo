package com.fndroid.entity;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */

public class Blog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String description;
	private String postDate;
	private String postStatus;

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** full constructor */
	public Blog(String title, String description, String postDate, String postStatus) {
		this.title = title;
		this.description = description;
		this.postDate = postDate;
		this.postStatus = postStatus;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostStatus() {
		return this.postStatus;
	}

	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

}