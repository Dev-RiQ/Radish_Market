package com.radish.vo;

public class MeetCategory {
	private int meet_category_no;
	private String meet_category_name;

	public MeetCategory(int meet_category_no, String meet_category_name) {
		super();
		this.meet_category_no = meet_category_no;
		this.meet_category_name = meet_category_name;
	}

	public int getMeet_category_no() {
		return meet_category_no;
	}

	public void setMeet_category_no(int meet_category_no) {
		this.meet_category_no = meet_category_no;
	}

	public String getMeet_category_name() {
		return meet_category_name;
	}

	public void setMeet_category_name(String meet_category_name) {
		this.meet_category_name = meet_category_name;
	}

}
