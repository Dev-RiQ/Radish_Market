package com.radish.vo;

public class Meet {
	private int meet_no;
	private int host_user_no;
	private String meet_title;
	private String meet_content;
	private int meet_category_no;
	private int age_min;
	private int age_max;
	private String meet_img;

	public Meet(int host_user_no, String meet_title, String meet_content, int meet_category_no, int age_min,
			int age_max, String meet_img) {
		super();
		this.host_user_no = host_user_no;
		this.meet_title = meet_title;
		this.meet_content = meet_content;
		this.meet_category_no = meet_category_no;
		this.age_min = age_min;
		this.age_max = age_max;
		this.meet_img = meet_img;
	}
	public Meet(int meet_no, int host_user_no, String meet_title, String meet_content, int meet_category_no, int age_min,
			int age_max, String meet_img) {
		super();
		this.meet_no = meet_no;
		this.host_user_no = host_user_no;
		this.meet_title = meet_title;
		this.meet_content = meet_content;
		this.meet_category_no = meet_category_no;
		this.age_min = age_min;
		this.age_max = age_max;
		this.meet_img = meet_img;
	}

	public int getMeet_no() {
		return meet_no;
	}

	public void setMeet_no(int meet_no) {
		this.meet_no = meet_no;
	}

	public int getHost_user_no() {
		return host_user_no;
	}

	public void setHost_user_no(int host_user_no) {
		this.host_user_no = host_user_no;
	}

	public String getMeet_title() {
		return meet_title;
	}

	public void setMeet_title(String meet_title) {
		this.meet_title = meet_title;
	}

	public String getMeet_content() {
		return meet_content;
	}

	public void setMeet_content(String meet_content) {
		this.meet_content = meet_content;
	}

	public int getMeet_category_no() {
		return meet_category_no;
	}

	public void setMeet_category_no(int meet_category_no) {
		this.meet_category_no = meet_category_no;
	}

	public int getAge_min() {
		return age_min;
	}

	public void setAge_min(int age_min) {
		this.age_min = age_min;
	}

	public int getAge_max() {
		return age_max;
	}

	public void setAge_max(int age_max) {
		this.age_max = age_max;
	}

	public String getMeet_img() {
		return meet_img;
	}

	public void setMeet_img(String meet_img) {
		this.meet_img = meet_img;
	}

}
