package com.radish.vo;

public class MeetJoin {
	private int meet_join_no;
	private int meet_no;
	private int user_no;
	private String meet_join_content;

	public MeetJoin(int meet_join_no, int meet_no, int user_no, String meet_join_content) {
		super();
		this.meet_join_no = meet_join_no;
		this.meet_no = meet_no;
		this.user_no = user_no;
		this.meet_join_content = meet_join_content;
	}

	public int getMeet_join_no() {
		return meet_join_no;
	}

	public void setMeet_join_no(int meet_join_no) {
		this.meet_join_no = meet_join_no;
	}

	public int getMeet_no() {
		return meet_no;
	}

	public void setMeet_no(int meet_no) {
		this.meet_no = meet_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getMeet_join_content() {
		return meet_join_content;
	}

	public void setMeet_join_content(String meet_join_content) {
		this.meet_join_content = meet_join_content;
	}

}
