package com.radish.vo;

public class Alram {
	private int alram_no;
	private int user_no;
	private int alram_category_no;
	private int link_no;
	private String alram_reg_datetime;
	private int alram_check;
	private int alram_content;

	public Alram(int alram_no, int user_no, int alram_category_no, int link_no, String alram_reg_datetime,
			int alram_check, int alram_content) {
		super();
		this.alram_no = alram_no;
		this.user_no = user_no;
		this.alram_category_no = alram_category_no;
		this.link_no = link_no;
		this.alram_reg_datetime = alram_reg_datetime;
		this.alram_check = alram_check;
		this.alram_content = alram_content;
	}

	public int getAlram_no() {
		return alram_no;
	}

	public void setAlram_no(int alram_no) {
		this.alram_no = alram_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getAlram_category_no() {
		return alram_category_no;
	}

	public void setAlram_category_no(int alram_category_no) {
		this.alram_category_no = alram_category_no;
	}

	public int getLink_no() {
		return link_no;
	}

	public void setLink_no(int link_no) {
		this.link_no = link_no;
	}

	public String getAlram_reg_datetime() {
		return alram_reg_datetime;
	}

	public void setAlram_reg_datetime(String alram_reg_datetime) {
		this.alram_reg_datetime = alram_reg_datetime;
	}

	public int getAlram_check() {
		return alram_check;
	}

	public void setAlram_check(int alram_check) {
		this.alram_check = alram_check;
	}

	public int getAlram_content() {
		return alram_content;
	}

	public void setAlram_content(int alram_content) {
		this.alram_content = alram_content;
	}

}
